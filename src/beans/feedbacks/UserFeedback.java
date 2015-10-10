package beans.feedbacks;

import java.io.Serializable;

public class UserFeedback extends Feedback implements Serializable {
	
	/**
	 * 
	 * The feedback of User operation.
	 * register, unregister, login, logout, delete
	 * 
	 */

	public static final String REGISTER_FEED = "register";
	public static final String UNREGISTER_FEED = "unregister";
	public static final String IS_REGISTER_FEED = "is_register";
	public static final String LOGIN_FEED = "login";
	public static final String LOGOUT_FEED = "logout";
	
	public UserFeedback(String mFeedType, int result) {
		super(result);
		this.mFeedType = mFeedType;
	}
	
	private String mFeedType;
	
	public String getFeedType() {
		return mFeedType;
	}
	public void setFeedType(String feedType) {
		mFeedType = feedType;
	}
	
}
