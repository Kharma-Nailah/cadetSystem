/**
 * This class implements a question.
 * @author Chisomo Dunkley - 620120184
 */

import java.util.ArrayList;

public class Quetions {
	private String questionID;
	private String question;
	private static int counter = 0;
	private ArrayList<String> question_list = new ArrayList<String>();
	
	/**
	 * This constructor accepts a question and generates a unique identifier for each question.
	 * @param question- The question
	 */
	public Quetions(String question) {
		this.question = question;
		counter++;
		questionID = counter + "";
	}
	
	/**
	 * This method returns a questions ID number.
	 * @return questionID -  The question's ID
	 */
	public String getquestionID() {
		return questionID;
	}
	
	/**
	 * This method returns a question.
	 * @return question-  The question
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * This method sets the value of the questions ID.
	 * @param questionID - The question's Id
	 */
	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}
	
	/**
	 * This method sets the question.
	 * @param question -  The question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	
	/**
	 * This method adds a new question the the list of questions.
	 * @param question_list - The list of questions
	 * @param questionId - The question's ID
	 * @param question - The question
	 */
	public void addQ(String question_list, String questionId , String question) { 
			this.question_list.add(question);
	}
	
	/**
	 * This method edits a question.
	 * @param questionId- The question's ID
	 * @param question- The question
	 */
	public void editQ(String questionId, String question) {
		this.editQ(questionId, question);
	}
	
	/**
	 * This method deletes a question from the question list.
	 * @param question_list- The list of questions
	 * @param questionId- The question's ID
	 * @param question- The question
	 */
	public void deleteQ(String question_list, String questionId , String question) {
			this.question_list.remove(questionID);
		}
	}
