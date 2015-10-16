package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	
	/**
	 * 
	 * TimeUtils is a class to convert date time representation
	 */
	
	// return the current time string
	public static String getCurrentTimeString(){
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(currentDate);
	}

}
