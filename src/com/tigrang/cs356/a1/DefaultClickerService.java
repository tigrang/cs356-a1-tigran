package com.tigrang.cs356.a1;

import java.util.Set;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.HashSet;

public class DefaultClickerService implements IClickerService {

	private Question question;

	private Map<Student, Set<String>> responses;

	public DefaultClickerService() {
		this.responses = new HashMap();
	}

	public void setQuestion(Question question) {
		this.responses.clear();
		this.question = question;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void submitResponse(Student student, String response) {
		this.submitResponse(student, new HashSet(Arrays.asList(response)));
	}

	public void submitResponse(Student student, Set<String> response) {
		this.responses.put(student, response);
	}

	public void displayQuestion() {
		System.out.println(this.question);
	}

	public void displayResults() {
		final TreeMap<String, Integer> aggregations = new TreeMap();
		for (Map.Entry<Student, Set<String>> entry : responses.entrySet()) {
			String values = Arrays.toString(entry.getValue().toArray());
			aggregations.put(values, aggregations.containsKey(values) ? aggregations.get(values) + 1 : 1);
		}

		for (Map.Entry<String, Integer> entry : aggregations.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		System.out.println("\nCorrect answer: " + Arrays.toString(this.question.getAnswer().toArray()));
	}
}