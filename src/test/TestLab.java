package test;

import impls.UserSystemImpl;
import interfaces.UserSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

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
		UserSystem userSystem = new UserSystemImpl();
		UserFeedback registered = userSystem.isRegistered(new DSUser("admin", "admin"));
		System.out.println(registered);
	}

}
