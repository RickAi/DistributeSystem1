package interfaces;

import beans.feedbacks.FileFeedback;

public interface FileSystem {
	
	// 4. see files available
	public FileFeedback availableFiles();
	
	// 4. transfer file
	public FileFeedback downloadFile();
	
	// 5. add file by user
	public FileFeedback uploadFile();
	
	// 5. remove file by user
	public FileFeedback removeFile();
	
}
