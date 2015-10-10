package client;

import interfaces.UserSystem;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import beans.DSUser;
import beans.feedbacks.UserFeedback;




public class ClientMain {
	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry();
			UserSystem userSystem = (UserSystem) registry.lookup("UserSystem");
			UserFeedback feed = userSystem.register(new DSUser("linus", "linus"));
			System.out.println(feed);
			UserFeedback feed2 = userSystem.login(new DSUser("linus", "linus"));
			System.out.println(feed2);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}

}
