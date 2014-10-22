package com.tigrang.cs356.a1;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class SimulationDriver {

	private static IClickerService iClickerService;

	public static void main(String[] args) throws Exception {
		iClickerService = new DefaultClickerService();

		Set<String> answers = new HashSet<String>(Arrays.asList("B", "C", "D"));
		Question q1 = Question.multipleChoice(1, "Which of the following are programming languages?", answers)
			.addOption("A", "Milk")
			.addOption("B", "Java")
			.addOption("C", "C++")
			.addOption("D", "Python");

		Question q2 = Question.trueFalse(2, "Is this written in Java?", "T");

		Question q3 = Question.singleAnswer(3, "What is 1 + 5?", "6")
			.addOption("3")
			.addOption("7")
			.addOption("10")
			.addOption("6");

		simulate(q1);
		simulate(q2);
		simulate(q3);
	}

	private static void simulate(Question question) {
		iClickerService.setQuestion(question);
		iClickerService.displayQuestion();

		System.out.println("\nGenerating 30 random responses...\n");

		Random rand = new Random();

		for (int i = 1; i <= 30; i++) {
			Student student = new Student(i);
			Map<String, String> options = iClickerService.getQuestion().getOptions();
			Object[] values = options.keySet().toArray();

			Set<String> response = new HashSet<String>();

			for (int j = 0; j < iClickerService.getQuestion().getAnswer().size(); j++) {
				int index = rand.nextInt(options.size());
				response.add((String) values[index]);
			}

			iClickerService.submitResponse(student, response);
		}

		iClickerService.displayResults();
		System.out.println("\n--------------------------");
	}
}