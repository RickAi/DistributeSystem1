package impls;

import interfaces.UserSystem;
import managers.UserManager;
import beans.DSUser;
import beans.DSUsers;
import beans.feedbacks.Feedback;
import beans.feedbacks.UserFeedback;

public class UserSystemImpl implements UserSystem {

	/**
	 * UserSystem's implementation, the user can register, unregister, login, 
	 * logout with this class's instance
	 * 
	 */
	
	
	// whether the user is registered in the DB
	public UserFeedback isRegistered(DSUser user) {
		UserFeedback userFeedback = null;
		DSUsers dsUsers = UserManager.getUsersFromFile();
		System.out.println(dsUsers);
		if (UserManager.existedUser(dsUsers, user) != null) {
			userFeedback = new UserFeedback(UserFeedback.IS_REGISTER_FEED,
					Feedback.RESULT_TRUE);
		} else {
			userFeedback = new UserFeedback(UserFeedback.IS_REGISTER_FEED,
					Feedback.RESULT_FALSE);
		}
		return userFeedback;
	}

	// register the user in the DB
	public UserFeedback register(DSUser user) {
		UserFeedback userFeedback = null;
		if (!hasRegistered(user)) {
			UserManager.addUserIntoFile(user);
			userFeedback = new UserFeedback(UserFeedback.REGISTER_FEED,
					Feedback.RESULT_TRUE);
		} else {
			userFeedback = new UserFeedback(UserFeedback.REGISTER_FEED,
					Feedback.RESULT_FALSE);
		}
		return userFeedback;
	}

	// delete the user's info in the DB
	public UserFeedback unregister(DSUser user) {
		UserFeedback userFeedback = null;
		if (hasRegistered(user)) {
			UserManager.removeUserFromFile(user);
			userFeedback = new UserFeedback(UserFeedback.UNREGISTER_FEED,
					Feedback.RESULT_TRUE);
		} else {
			userFeedback = new UserFeedback(UserFeedback.UNREGISTER_FEED,
					Feedback.RESULT_FALSE);
		}
		return userFeedback;
	}

	// login service for the user
	public UserFeedback login(DSUser user) {
		UserFeedback userFeedback = null;
		if (UserManager.isUserAuthorized(user)) {
			userFeedback = new UserFeedback(UserFeedback.LOGIN_FEED,
					Feedback.RESULT_TRUE);
		} else {
			userFeedback = new UserFeedback(UserFeedback.LOGIN_FEED,
					Feedback.RESULT_FALSE);
		}
		return userFeedback;
	}

	// logout service for the user
	public UserFeedback logout(DSUser user) {
		UserFeedback userFeedback = null;
		if (UserManager.isUserAuthorized(user)) {
			userFeedback = new UserFeedback(UserFeedback.LOGOUT_FEED,
					Feedback.RESULT_TRUE);
		} else {
			userFeedback = new UserFeedback(UserFeedback.LOGIN_FEED,
					Feedback.RESULT_FALSE);
		}
		return userFeedback;
	}
	
	// whether the user has registered in the DB
	private boolean hasRegistered(DSUser user){
		UserFeedback feed = isRegistered(user);
		return (feed.getResult() == Feedback.RESULT_TRUE);
	}
	
}
