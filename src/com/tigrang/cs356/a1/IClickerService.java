package com.tigrang.cs356.a1;

import java.util.Set;

public interface IClickerService {

/**
 * Set the curent question to be asked
 *
 * @return void
 */
	public void setQuestion(Question question);

/**
 * Get the current question
 *
 * @return Question
 */
	public Question getQuestion();

/**
 * Submit a single response answer by the given student response for the current question
 *
 * @return void
 */
	public void submitResponse(Student student, String response);

/**
 * Submit a multiple response answer by the given student response for the current question
 *
 * @return void
 */
	public void submitResponse(Student student, Set<String> response);

/**
 * Display the current question
 *
 * @return void
 */
	public void displayQuestion();

/**
 * Display the results for the current question
 *
 * @return void
 */
	public void displayResults();
}