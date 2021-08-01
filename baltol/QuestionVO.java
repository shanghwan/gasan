package baltol;

public class QuestionVO {
	
	private String user_id;
	private String question;
	private String answer;
	
	public QuestionVO() {}
	
	public QuestionVO(String user_id, String question, String answer) {
		this.user_id = user_id;
		this.question = question;
		this.answer = answer;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
