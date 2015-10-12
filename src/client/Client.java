package client;

import interfaces.FileSystem;
import interfaces.StatisticSystem;
import interfaces.UserSystem;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import managers.ServiceManager;

import client.view.ClientFrame;

import utils.Constants;

public class Client {
	
	private ClientFrame clientFrame;
	
	public Client() {
		clientFrame = new ClientFrame();
		initServices();
	}
	
	private void initServices(){
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry();
			ServiceManager.userSystem = (UserSystem) registry.lookup(Constants.SERVICE_USER);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	

}
