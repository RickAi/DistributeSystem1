package beans.feedbacks;

import java.io.Serializable;

public class UserFeedback extends Feedback implements Serializable {

	public static final String REGISTER_FEED = "register";
	public static final String LOGIN_FEED = "login";
	public static final String LOGOUT_FEED = "logout";
	
	private String mFeedType;
	
	public String getFeedType() {
		return mFeedType;
	}
	public void setFeedType(String feedType) {
		mFeedType = feedType;
	}
	
}
