package beans.feedbacks;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class FileFeedback extends Feedback implements Serializable {
	
	public static final String DOWNLOAD_FILES = "download_files";
	public static final String AVAILABLE_FILES = "avialable_files";
	public static final String UPLOAD_FILE = "upload_file";
	public static final String REMOVE_FILES = "remove_file";
	private File file;
	private ArrayList<String> fileNames;
	
	public FileFeedback(int mResult) {
		super(mResult);
	}
	
	public FileFeedback(){
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public ArrayList<String> getFileNames() {
		return fileNames;
	}

	public void setFileNames(ArrayList<String> fileNames) {
		this.fileNames = fileNames;
	}
	
	
	
}
