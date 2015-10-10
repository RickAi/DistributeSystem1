package test;

import impls.UserSystemImpl;
import interfaces.UserSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import beans.DSUser;
import beans.DSUsers;
import beans.feedbacks.UserFeedback;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import utils.Constants;


public class TestLab {
	
	public static final File USERS_FILE = new File(Constants.USERS_FILE);
	
	public static void main(String[] args) {
		testData();
		
//		addData();
	}
	
	private static void testData() {
		UserSystem userSystem = new UserSystemImpl();
		UserFeedback register;
		try {
			register = userSystem.logout(new DSUser("cirrus", "cirrus"));
			System.out.println(register);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static void addData(){
		DSUsers dsUsers = new DSUsers();
		List<DSUser> users = dsUsers.getUsers();
		users.add(new DSUser("admin", "admin"));
		users.add(new DSUser("cirrus", "cirrus"));
		Gson gson = new Gson();
		String json = gson.toJson(dsUsers);
		System.out.println(json);
	}

}
