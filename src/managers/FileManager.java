package managers;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import utils.Constants;

public class FileManager {
	
	public static final File FILES_DIR = new File(Constants.FILE_DIR);
	
	public static int getNumberOfFiles(){
		File filesDir = FILES_DIR;
		String[] fileNames = filesDir.list();
		List<String> fileList = Arrays.asList(fileNames);
		return fileList.size();
	}
	

}
