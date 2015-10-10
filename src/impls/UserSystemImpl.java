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
		if (dsUsers.getUsers().contains(user)) {
			userFeedback = new UserFeedback(UserFeedback.IS_REGISTER_FEED,
					Feedback.RESULT_SUCCESS);
		} else {
			userFeedback = new UserFeedback(UserFeedback.IS_REGISTER_FEED,
					Feedback.RESULT_FAIL);
		}
		return userFeedback;
	}

	public UserFeedback register(DSUser user) {
		UserFeedback userFeedback = null;
		if (DBManager.addUserIntoFile(user)) {
			userFeedback = new UserFeedback(UserFeedback.REGISTER_FEED,
					Feedback.RESULT_SUCCESS);
		} else {
			userFeedback = new UserFeedback(UserFeedback.REGISTER_FEED,
					Feedback.RESULT_FAIL);
		}
		return userFeedback;
	}

	public UserFeedback unregister(DSUser user) {
		UserFeedback userFeedback = null;
		if (DBManager.removeUserFromFile(user)) {
			userFeedback = new UserFeedback(UserFeedback.UNREGISTER_FEED,
					Feedback.RESULT_SUCCESS);
		} else {
			userFeedback = new UserFeedback(UserFeedback.UNREGISTER_FEED,
					Feedback.RESULT_FAIL);
		}
		return userFeedback;
	}

	public UserFeedback login(DSUser user) {
		UserFeedback userFeedback = null;
		if (DBManager.isUserInFile(user)) {
			userFeedback = new UserFeedback(UserFeedback.LOGIN_FEED,
					Feedback.RESULT_SUCCESS);
		} else {
			userFeedback = new UserFeedback(UserFeedback.LOGIN_FEED,
					Feedback.RESULT_FAIL);
		}
		return userFeedback;
	}

	public UserFeedback logout(DSUser user) {
		return null;
	}
	
	public boolean existUser(DSUsers dsUsers, DSUser user){
		List<DSUser> existedUsers = dsUsers.getUsers();
		String name = user.getName();
		for (DSUser dsUser : existedUsers) {
			return dsUser.getName().equals(name);
		}
		return false;
	}
}
