package impls;

import java.util.List;

import managers.DBManager;
import beans.DSUser;
import beans.DSUsers;
import beans.feedbacks.Feedback;
import beans.feedbacks.UserFeedback;
import interfaces.UserSystem;

public class UserSystemImpl implements UserSystem {

	public UserFeedback isRegistered(DSUser user) {
		UserFeedback userFeedback = null;
		DSUsers dsUsers = DBManager.getUsersFromFile();
		System.out.println(dsUsers);
		if (DBManager.existedUser(dsUsers, user) != null) {
			userFeedback = new UserFeedback(UserFeedback.IS_REGISTER_FEED,
					Feedback.RESULT_TRUE);
		} else {
			userFeedback = new UserFeedback(UserFeedback.IS_REGISTER_FEED,
					Feedback.RESULT_FALSE);
		}
		return userFeedback;
	}

	public UserFeedback register(DSUser user) {
		UserFeedback userFeedback = null;
		if (!hasRegistered(user)) {
			DBManager.addUserIntoFile(user);
			userFeedback = new UserFeedback(UserFeedback.REGISTER_FEED,
					Feedback.RESULT_TRUE);
		} else {
			userFeedback = new UserFeedback(UserFeedback.REGISTER_FEED,
					Feedback.RESULT_FALSE);
		}
		return userFeedback;
	}

	public UserFeedback unregister(DSUser user) {
		UserFeedback userFeedback = null;
		if (hasRegistered(user)) {
			DBManager.removeUserFromFile(user);
			userFeedback = new UserFeedback(UserFeedback.UNREGISTER_FEED,
					Feedback.RESULT_TRUE);
		} else {
			userFeedback = new UserFeedback(UserFeedback.UNREGISTER_FEED,
					Feedback.RESULT_FALSE);
		}
		return userFeedback;
	}

	public UserFeedback login(DSUser user) {
		UserFeedback userFeedback = null;
		if (DBManager.isUserInFile(user)) {
			userFeedback = new UserFeedback(UserFeedback.LOGIN_FEED,
					Feedback.RESULT_TRUE);
		} else {
			userFeedback = new UserFeedback(UserFeedback.LOGIN_FEED,
					Feedback.RESULT_FALSE);
		}
		return userFeedback;
	}

	public UserFeedback logout(DSUser user) {
		UserFeedback userFeedback = null;
		if (DBManager.isUserInFile(user)) {
			userFeedback = new UserFeedback(UserFeedback.LOGOUT_FEED,
					Feedback.RESULT_TRUE);
		} else {
			userFeedback = new UserFeedback(UserFeedback.LOGIN_FEED,
					Feedback.RESULT_FALSE);
		}
		return userFeedback;
	}
	
	private boolean hasRegistered(DSUser user){
		UserFeedback feed = isRegistered(user);
		return (feed.getResult() == Feedback.RESULT_TRUE);
	}
	
}
