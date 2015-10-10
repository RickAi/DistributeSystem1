package managers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import utils.Constants;
import beans.DSUser;
import beans.DSUsers;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class DBManager {

	public static final File USERS_FILE = new File(Constants.USERS_FILE);
	public static Gson gson;

	static {
		gson = new Gson();
	}
	
	public static boolean isUserInFile(DSUser user){
		DSUsers dsUsers = getUsersFromFile();
		return dsUsers.getUsers().contains(user);
	}
	
	public static boolean removeUserFromFile(DSUser user) {
		DSUsers dsUsers = getUsersFromFile();
		boolean deleteResult = false;
		if(dsUsers.getUsers().contains(user)){
			dsUsers.getUsers().remove(user);
			deleteResult = true;
		}
		boolean emptyResult = emptyFile(USERS_FILE);
		String json = gson.toJson(dsUsers);
		boolean writeResult = writeToFile(USERS_FILE, json);
		
		return (deleteResult && emptyResult && writeResult);
	}
	

	public static boolean addUserIntoFile(DSUser user) {
		DSUsers dsUsers = getUsersFromFile();
		boolean addResult = dsUsers.getUsers().add(user);
		boolean emptyResult = emptyFile(USERS_FILE);
		String json = gson.toJson(dsUsers);
		boolean writeResult = writeToFile(USERS_FILE, json);
		
		return (addResult && emptyResult && writeResult);
	}

	public static DSUsers getUsersFromFile() {
		try {
			return gson.fromJson(new FileReader(USERS_FILE), DSUsers.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

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
	
	public static boolean writeToFile(File file, String data) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fileWritter = new FileWriter(file.getName(), true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(data);
			bufferWritter.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
