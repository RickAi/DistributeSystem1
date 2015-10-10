package beans.feedbacks;

import java.io.Serializable;

public class FileFeedback extends Feedback implements Serializable {
	
	public static final String DOWNLOAD_FILES = "download_files";
	public static final String AVAILABLE_FILES = "avialable_files";
	public static final String UPLOAD_FILE = "upload_file";
	public static final String REMOVE_FILES = "remove_file";
	
	public FileFeedback(int mResult) {
		super(mResult);
	}
	
	
	
}
