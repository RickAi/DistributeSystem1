package server;

import impls.FileSystemImpl;
import impls.StatisticSystemImpl;
import impls.UserSystemImpl;
import interfaces.FileSystem;
import interfaces.StatisticSystem;
import interfaces.UserSystem;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import utils.Constants;

public class Server {
	
	/**
	 * 
	 * Server class to used to open services in port 1099
	 */
	
	public void bindServices(){
		Registry registry;
		try {
			registry = LocateRegistry.createRegistry(Constants.SERVICE_PORT);
			UserSystem userSystem = (UserSystem) UnicastRemoteObject.exportObject(new UserSystemImpl(), 0);
			registry.bind(Constants.SERVICE_USER, userSystem);
			FileSystem fileSystem = (FileSystem) UnicastRemoteObject.exportObject(new FileSystemImpl(), 0);
			registry.bind(Constants.SERVICE_FILE, fileSystem);
			StatisticSystem statisticSystem = (StatisticSystem) UnicastRemoteObject.exportObject(new StatisticSystemImpl(), 0);
			registry.bind(Constants.SERVICE_STATISTIC, statisticSystem);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}

}
