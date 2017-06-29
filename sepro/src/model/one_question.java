package model;

public class one_question {
	private int questionID;
	private char Title;
	private char direction;
	private char must_an;
	private int paperid;
	private char topicid;
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public char getTitle() {
		return Title;
	}
	public void setTitle(char title) {
		Title = title;
	}
	public char getDirection() {
		return direction;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}
	public char getMust_an() {
		return must_an;
	}
	public void setMust_an(char must_an) {
		this.must_an = must_an;
	}
	public int getPaperid() {
		return paperid;
	}
	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}
	public char getTopicid() {
		return topicid;
	}
	public void setTopicid(char topicid) {
		this.topicid = topicid;
	}
}
