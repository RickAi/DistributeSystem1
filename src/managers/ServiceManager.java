package managers;

import beans.DSUser;
import client.view.ClientFrame;
import interfaces.FileSystem;
import interfaces.StatisticSystem;
import interfaces.UserSystem;

public class ServiceManager {
	
	/**
	 * 
	 * ServiceManager is the singleton manager for the ClientFrame and DSUser and three system
	 */
	
	public static UserSystem userSystem;
	public static FileSystem fileSystem;
	public static StatisticSystem statisticSystem;
	
	public static ClientFrame clientFrame;
	public static DSUser dsUser;
	
	
}
