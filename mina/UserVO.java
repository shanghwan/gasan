package mina;

public class UserVO {

	private String user_id;
	private String pwd;
	private String userName;

	
	public UserVO() {}

	public UserVO(String user_id, String pwd, String userName) {
		this.user_id = user_id;
		this.pwd = pwd;
		this.userName = userName;
	}


	public String getUser_id() {
		return user_id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
