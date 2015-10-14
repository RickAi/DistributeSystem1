package beans.feedbacks;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class FileFeedback extends Feedback implements Serializable {
	
	public static final String DOWNLOAD_FILES = "download_files";
	public static final String AVAILABLE_FILES = "avialable_files";
	public static final String UPLOAD_FILE = "upload_file";
	public static final String REMOVE_FILES = "remove_file";
	private File file;
	private List<String> fileNames;
	private String fileName;
	
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

	public List<String> getFileNames() {
		return fileNames;
	}

	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
}
