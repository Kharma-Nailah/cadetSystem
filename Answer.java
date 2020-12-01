/**
 * This class implements the answers to the questions.
 * @author Chisomo Dunkley - 620120184
 */

import java.util.ArrayList;

public class Answer {
	private String ansID;
	private String ans;
	private static int counter = 0;
	private ArrayList<String> answer_list = new ArrayList<String>();
	
	/**
	 * This constructor accepts an answer and generates a unique identifier for each answer.
	 * @param ans- The answer
	 */
	public Answer(String ans) {
		this.ans = ans;
		counter++;
		ansID = counter + "";
	}
	
	/**
	 * This method returns an answer's ID number.
	 * @return ansID- The answer's ID
	 */
	public String getAnsID() {
		return ansID;
	}
	
	/**
	 * This method returns an answer.
	 * @return ans- The answer
	 */
	public String getAns() {
		return ans;
	}
	
	/**
	 * This method sets the value of the answer's ID
	 * @param ansID- The answer's ID
	 */
	public void setAnsID(String ansID) {
		this.ansID = ansID;
	}
	
	/**
	 * This method sets the answer.
	 * @param ans- The answer
	 */
	public void setAns(String ans) {
		this.ans = ans;
	}
	
	/**
	 * This method adds a new answer the the list of answers.
	 * @param answer_list- The list of answers
	 * @param ansId- The answer's ID
	 * @param ans- The answer
	 */
	public void addQ(String answer_list, String ansId , String ans) { 
		this.answer_list.add(ans);
	}
	
	/**
	 * This method edits an answer.
	 * @param ansId- The answer's ID
	 * @param ans- The answer
	 */
	public void editA(String ansId, String ans) {
		this.editA(ansId, ans);
	}
	
	/**
	 * This method deletes an answer from the question list.
	 * @param answer_list- The list of answers
	 * @param ansId- The answer's ID
	 * @param ans- The answer
	 */
	public void deleteQ(String answer_list, String ansId , String ans) {
		this.answer_list.remove(ansID);
		}
}
	 