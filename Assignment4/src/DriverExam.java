import java.util.ArrayList;

/**
 * The class that grades student's exams and reports the results.
 *
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 */
public class DriverExam {
	private ArrayList<Character> answers;
	private StudentExam exam;
	
	/**
	 * Creates and instantiates a DriverExam object
	 */
	public DriverExam() {
		// Add correct answers to list
		answers = new ArrayList<Character>();
		answers.add(new Character('B'));
		answers.add(new Character('D'));
		answers.add(new Character('A'));
		answers.add(new Character('A'));
		answers.add(new Character('C'));
		answers.add(new Character('A'));
		answers.add(new Character('B'));
		answers.add(new Character('A'));
		answers.add(new Character('C'));
		answers.add(new Character('D'));
		answers.add(new Character('B'));
		answers.add(new Character('C'));
		answers.add(new Character('D'));
		answers.add(new Character('A'));
		answers.add(new Character('D'));
		answers.add(new Character('C'));
		answers.add(new Character('C'));
		answers.add(new Character('B'));
		answers.add(new Character('D'));
		answers.add(new Character('A'));
	}
	
	/**
	 * Returns whether the student passed the test
	 * 
	 * @return True if the student passed, false otherwise
	 */
	public boolean passedTest() {
		return numQuestionsCorrect() > 15;
	}
	
	/**
	 * Returns the number of questions the student got correct on the exam
	 * 
	 * @return The number of correct answers
	 */
	public int numQuestionsCorrect() {
		int number = 0;
		String givenAnswer;
		String rightAnswer;
		
		for(int i = 0; i < answers.size(); i++) {
			givenAnswer = exam.getAnswers().get(i).toString();
			rightAnswer = answers.get(i).toString();
			
			if(givenAnswer.equals(rightAnswer)) {
				number++;
			}
		}
		
		return number;
	}
	
	/**
	 * Returns the number of questions the student got incorrect on the exam
	 * 
	 * @return The number of incorrect answers
	 */
	public int numQuestionsIncorrect() {
		int number = 0;
		String givenAnswer;
		String rightAnswer;
		
		for(int i = 0; i < answers.size(); i++) {
			givenAnswer = exam.getAnswers().get(i).toString();
			rightAnswer = answers.get(i).toString();
			
			if(!givenAnswer.equals(rightAnswer)) {
				number++;
			}
		}
		
		return number;
	}
	
	/**
	 * Returns a list of questions that the student missed
	 * 
	 * @return A list of missed questions
	 */
	public ArrayList<Integer> whichQuestionsMissed() {
		ArrayList<Integer> questions = new ArrayList<Integer>();
		String givenAnswer;
		String rightAnswer;
		
		for(int i = 0; i < answers.size(); i++) {
			givenAnswer = exam.getAnswers().get(i).toString();
			rightAnswer = answers.get(i).toString();
			
			if(!givenAnswer.equals(rightAnswer)) {
				questions.add(i + 1);
			}
		}
		
		return questions;
	}
	
	/**
	 * Generates a report about the student's exam results
	 * 
	 * @param name The student's name
	 * @param answers The student's answers
	 * @return A string containing the report
	 */
	public String report(String name, char[] answers) {
		String report = "";
		
		// Convert answers array to array list
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < answers.length; i++) {
			list.add(new Character(answers[i]));
		}
		
		// Create student exam object
		exam = new StudentExam(list, name);
		
		// Get exam results data
		int correctQuestions = numQuestionsCorrect();
		int incorrectQuestions = numQuestionsIncorrect();
		ArrayList<Integer> missedQuestions = whichQuestionsMissed();
		
		// Build report string
		report += name + " " + (passedTest() ? "PASSED" : "FAILED") + "\n\n";
		report += "Correct: " + correctQuestions + ", Incorrect: " + 
			incorrectQuestions + "\n\n";
		report += "Missed questions: ";
		
		if(missedQuestions.size() != 0) {
			for(int i = 0; i < missedQuestions.size(); i++) {
				report += missedQuestions.get(i) + 
					(i + 1 == missedQuestions.size() ? "" : ", ");
			}
		} else {
			report += "None";
		}
		
		// Return report string
		return report;
	}
}
