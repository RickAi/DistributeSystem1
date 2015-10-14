package beans;

import java.io.Serializable;
import java.util.Date;

public class DSReport implements Serializable {
	private String time;
	private String userName;
	private int action;
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
}
