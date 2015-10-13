package interfaces;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

import beans.feedbacks.FileFeedback;

public interface FileSystem extends Remote {
	
	// 4. see files available
	public FileFeedback availableFiles() throws RemoteException;
	
	// 4. transfer file
	public FileFeedback downloadFile() throws RemoteException;
	
	// 5. add file by user
	public FileFeedback uploadFile(File file) throws RemoteException;
	
	// 5. remove file by user
	public FileFeedback removeFile() throws RemoteException;
	
}
