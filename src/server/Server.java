package server;

import impls.UserSystemImpl;
import interfaces.UserSystem;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import utils.Constants;

public class Server {
	
	public void bindServices(){
		Registry registry;
		try {
			registry = LocateRegistry.createRegistry(Constants.SERVICE_PORT);
			UserSystem userSystem = (UserSystem) UnicastRemoteObject.exportObject(new UserSystemImpl(), 0);
			registry.bind(Constants.SERVICE_USER, userSystem);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

}
