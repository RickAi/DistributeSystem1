package managers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import utils.Constants;

import com.google.gson.Gson;

public class DBManager {
	
	/**
	 * 
	 * The parent manager class for DB management
	 */

	// initialize gson service
	public static Gson gson;

	static {
		gson = new Gson();
	}

	// blank the file's content
	public static boolean emptyFile(File file) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(Constants.EMPTY_STRING);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// write data into the file
	public static boolean writeToFile(File file, String data) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fileWritter = new FileWriter(file);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(data);
			bufferWritter.flush();
			bufferWritter.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
