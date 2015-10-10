package client;

import interfaces.FileSystem;
import interfaces.StatisticSystem;
import interfaces.UserSystem;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import utils.Constants;

public class Client {
	
	private UserSystem userSystem;
	private FileSystem fileSystem;
	private StatisticSystem statisticSystem;
	
	
	
	
	public void initServices(){
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry();
			userSystem = (UserSystem) registry.lookup(Constants.SERVICE_USER);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	

}
