package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import beans.DSUser;
import beans.feedbacks.UserFeedback;

public interface UserSystem extends Remote {

	// 1. Registration by a user on the system;
	// judge the user is registered
	// register the user into the system
	public UserFeedback isRegistered(DSUser user) throws RemoteException;
	public UserFeedback register(DSUser user) throws RemoteException;

	// 2. Removal by a user of themselves from the system;
	// unregister the user from the system
	public UserFeedback unregister(DSUser user) throws RemoteException;

	// 3. Ability by a user to "log in" and "log out" from the system;
	// login into the system
	// logout from the system
	public UserFeedback login(DSUser user) throws RemoteException;
	public UserFeedback logout(DSUser user) throws RemoteException;

}
