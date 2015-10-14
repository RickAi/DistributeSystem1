package managers;

import java.io.File;

import utils.Constants;

import com.google.gson.Gson;

public class StatisticManager {

	public static final File STATISTIC_FILE = new File(Constants.STATISTIC_FILE);
	public static Gson gson;

	static {
		gson = new Gson();
	}
	
	
	
}
