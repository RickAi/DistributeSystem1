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
		initServices();
		initFrame();
	}
	
	private void initFrame() {
		clientFrame = new ClientFrame();
		clientFrame.isServiceConnected();
	}

	private void initServices(){
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry();
			ServiceManager.userSystem = (UserSystem) registry.lookup(Constants.SERVICE_USER);
			ServiceManager.fileSystem = (FileSystem) registry.lookup(Constants.SERVICE_FILE);
			ServiceManager.statisticSystem = (StatisticSystem) registry.lookup(Constants.SERVICE_STATISTIC);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	

}
