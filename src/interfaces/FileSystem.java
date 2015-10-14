package interfaces;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

import beans.DSUser;
import beans.feedbacks.FileFeedback;

public interface FileSystem extends Remote {
	
	// 4. see files available
	public FileFeedback availableFiles() throws RemoteException;
	
	// 4. transfer file
	public FileFeedback downloadFile(String fileName, DSUser user) throws RemoteException;
	
	// 5. add file by user
	public FileFeedback uploadFile(File file, DSUser user) throws RemoteException;
	
	// 5. remove file by user
	public FileFeedback removeFile(String fileName, DSUser user) throws RemoteException;
	
}
