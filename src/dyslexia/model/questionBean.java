package dyslexia.model;

public class questionBean {
	String questionID,questionNumber,questionDescription,questionChoice1,questionChoice2,questionChoice3,questionChoice4,questionCorrectAnswer,testID;
	boolean valid;
	
	public String getQuestionID() {
		return questionID;
	}
	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}
	public String getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(String questionNumber) {
		this.questionNumber = questionNumber;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public String getQuestionChoice1() {
		return questionChoice1;
	}
	public void setQuestionChoice1(String questionChoice1) {
		this.questionChoice1 = questionChoice1;
	}
	public String getQuestionChoice2() {
		return questionChoice2;
	}
	public void setQuestionChoice2(String questionChoice2) {
		this.questionChoice2 = questionChoice2;
	}
	public String getQuestionChoice3() {
		return questionChoice3;
	}
	public void setQuestionChoice3(String questionChoice3) {
		this.questionChoice3 = questionChoice3;
	}
	public String getQuestionChoice4() {
		return questionChoice4;
	}
	public void setQuestionChoice4(String questionChoice4) {
		this.questionChoice4 = questionChoice4;
	}
	public String getQuestionCorrectAnswer() {
		return questionCorrectAnswer;
	}
	public void setQuestionCorrectAnswer(String questionCorrectAnswer) {
		this.questionCorrectAnswer = questionCorrectAnswer;
	}
	public String getTestID() {
		return testID;
	}
	public void setTestID(String testID) {
		this.testID = testID;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
