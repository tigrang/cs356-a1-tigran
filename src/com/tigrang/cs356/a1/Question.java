package com.tigrang.cs356.a1;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Question {

	private int id;

	private String label;

	private Map<String, String> options;

	private Set<String> answer;

	public Question(int id, String label, String answer) {
		this.id = id;
		this.label = label;
		this.options = new HashMap();
		this.answer = new HashSet<String>();
		this.answer.add(answer);
	}

	public Question(int id, String label, Set<String> answer) {
		this.id = id;
		this.label = label;
		this.answer = answer;
		this.options = new HashMap();
	}

	public static Question singleAnswer(int id, String label, String answer) {
		return new Question(id, label, answer);
	}

	public static Question multipleChoice(int id, String label, Set<String> answers) {
		return new Question(id, label, answers);
	}

	public static Question trueFalse(int id, String label, String answer) {
		return Question.singleAnswer(id, label, answer)
			.addOption("T", "True")
			.addOption("F", "False");
	}

	public int getId() {
		return this.id;
	}

	public Question addOption(String value) {
		this.options.put(value, null);
		return this;
	}

	public Question addOption(String value, String label) {
		this.options.put(value, label);
		return this;
	}

	public Question addOptions(Map<String, String> options) {
		this.options.putAll(options);
		return this;
	}

	public Question removeOption(String value) {
		this.options.remove(value);
		return this;
	}

	public Map<String, String> getOptions() {
		return this.options;
	}

	public Set<String> getAnswer() {
		return this.answer;
	}

	public String toString() {
		String str = this.id + ". " + this.label;
		for (Map.Entry<String, String> entry : this.options.entrySet()) {
			str += "\n\t" + entry.getKey() + "";
			if (entry.getValue() != null) {
				str += ") "  + entry.getValue();
			}
		}
		return str;
	}
}