import java.util.ArrayList;

/**
 * A class that represents an individual student's exam.
 *
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 */
public class StudentExam {
	private ArrayList<Character> answers;
	private String name;
		
	/**
	 * Constructs a StudentExam object
	 */
	public StudentExam() {
		answers = new ArrayList<Character>();
		name = "";
	}

	/**
	 * Constructs a StudentExam object given the student's answers and name
	 * 
	 * @param answers The student's answers
	 * @param name The student's name
	 */
	public StudentExam(ArrayList<Character> answers, String name) {
		this.answers = answers;
		this.name = name;
	}

	/**
	 * Returns the student's answers
	 * 
	 * @return The student's answers
	 */
	public ArrayList<Character> getAnswers() {
		return answers;
	}
	
	/**
	 * Sets the student's answers
	 * 
	 * @param answers The student's answers
	 */
	public void setAnswers(ArrayList<Character> answers) {
		this.answers = answers;
	}

	/**
	 * Returns the student's name
	 * 
	 * @return The student's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the student's name
	 * 
	 * @param name The student's name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
