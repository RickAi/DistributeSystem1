package beans;

import java.io.Serializable;
import java.util.Date;

import utils.Constants;

public class DSStatistic implements Serializable {
	
	/**
	 * DSStatistic is the statistic of file model
	 * 
	 */
	
	private String userName;
	private int action;
	private String fileName;
	private String time;
	
	public DSStatistic(String userName, int action, String fileName, String time) {
		super();
		this.userName = userName;
		this.action = action;
		this.fileName = fileName;
		this.time = time;
	}
	
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
	
	@Override
	public String toString() {
		return time + "  " + userName + " " + getActionString(action);
	}
	
	public String getActionString(int action){
		String actionString = null;
		switch (action) {
		case Constants.FILE_REPORT_DOWNLOAD:
			actionString = "download " + fileName;
			break;
		case Constants.FILE_REPORT_REMOVE:
			actionString = "remove " + fileName;
			break;
		case Constants.FILE_REPORT_UPLOAD:
			actionString = "upload " + fileName;
			break;
		default:
			actionString = "unknown action";
			break;
		}
		return actionString;
	}
}
