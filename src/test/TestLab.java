package test;

import impls.UserSystemImpl;
import interfaces.StatisticSystem;
import interfaces.UserSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import managers.StatisticManager;

import beans.DSStatistic;
import beans.DSStatistics;
import beans.DSUser;
import beans.DSUsers;
import beans.feedbacks.UserFeedback;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import utils.Constants;
import utils.TimeUtils;


public class TestLab {
	
	public static final File USERS_FILE = new File(Constants.USERS_FILE);
	
	public static void main(String[] args) {
//		testStatisticData();
//		testUserData();
		
//		addStatisticData();
//		addUserData();
	}
	
	private static void testStatisticData() {
		StatisticManager.addStatisticIntoFile(new DSStatistic("navyblue", 2, "navyblue.xlsx", "2015-10-13 14:38"));
		DSStatistics statistics = StatisticManager.getReportsFromFile();
		System.out.println(statistics);
	}

	private static void testUserData() {
		UserSystem userSystem = new UserSystemImpl();
		UserFeedback register;
		try {
			register = userSystem.logout(new DSUser("cirrus", "cirrus"));
			System.out.println(register);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void addStatisticData(){
		DSStatistics dsStatistics = new DSStatistics();
		List<DSStatistic> statistics = dsStatistics.getStatistics();
		statistics.add(new DSStatistic("admin", 1, "example.xlsx", "2015-10-14"));
		statistics.add(new DSStatistic("cirrus", 2, "money.xlsx", "2015-10-13"));
		Gson gson = new Gson();
		String json = gson.toJson(dsStatistics);
		System.out.println(json);
	}
	

	public static void addUserData(){
		DSUsers dsUsers = new DSUsers();
		List<DSUser> users = dsUsers.getUsers();
		users.add(new DSUser("admin", "admin"));
		users.add(new DSUser("cirrus", "cirrus"));
		Gson gson = new Gson();
		String json = gson.toJson(dsUsers);
		System.out.println(json);
	}

}
