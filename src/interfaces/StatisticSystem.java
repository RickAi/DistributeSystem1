package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import beans.feedbacks.StatisticFeedback;

public interface StatisticSystem extends Remote {
	
	// file usage
	public StatisticFeedback getFileUsage() throws RemoteException;
	
	// number of file
	public StatisticFeedback getNumberOfFile() throws RemoteException;
	
}
