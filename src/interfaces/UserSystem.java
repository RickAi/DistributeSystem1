package interfaces;

import beans.DSUser;
import beans.feedbacks.UserFeedback;

public interface UserSystem {

	// 1. Registration by a user on the system;
	// judge the user is registered
	// register the user into the system
	public UserFeedback isRegistered(DSUser user);
	public UserFeedback register(DSUser user);

	// 2. Removal by a user of themselves from the system;
	// unregister the user from the system
	public UserFeedback unregister(DSUser user);

	// 3. Ability by a user to "log in" and "log out" from the system;
	// login into the system
	// logout from the system
	public UserFeedback login(DSUser user);
	public UserFeedback logout(DSUser user);

}
