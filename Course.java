/**
 * This class implements a course
 * @author Chisomo Dunkley - 620120184
 */


import Grade.Grade;
import Instuctor.Instructor;
import Testbank.Testbank;

public class Course {
	public Grade grade;
	public Testbank testbank;
	public Instructor instructor;
	private String lessons;
	private String starlev;
	
	/**
	 * This constructor accepts the lessons and the star level
	 * @param lessons- The lesson
	 * @param starlev-The star level
	 */
	public Course(String lessons, String starlev) {
		super();
		this.lessons = lessons;
		this.starlev = starlev;
	}
	
	/**
	 * This method returns the lesson.
	 * @return lessons- The lesson
	 */
	public String getLessons() {
		return lessons;
	}
	
	/**
	 * This method returns the star level.
	 * @return starlev - The star level
	 */
	public String getStarlev() {
		return starlev;
	}
	
	/**
	 * This method sets the lesson.
	 * @param lessons - The lesson
	 */
	public void setLessons(String lessons) {
		this.lessons = lessons;
	}
	
	/**
	 * This method sets the value of the star level.
	 * @param starlev- The star level
	 */
	public void setStarlev(String starlev) {
		this.starlev = starlev;
	}
}
