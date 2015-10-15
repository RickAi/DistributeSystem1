package utils;

import java.awt.GraphicsConfiguration;

import javax.swing.Icon;

public class Constants {
	
	// DB
	public static final String STATISTIC_FILE = "DB/statistics/statistics.json";
	public static final String USERS_FILE = "DB/users/users.json";
	public static final String USERS_RECORDS = "DB/records/user_records.json";
	public static final String FILES_RECORDS = "DB/records/file_records.json";
	public static final String FILE_DIR = "DB/files";
	public static final String FILE_DOWNLOAD_DIR = "downloads";
	public static final String EMPTY_STRING = "";
	
	// Service
	public static final int SERVICE_PORT = 1099;
	public static final String SERVICE_USER = "UserSystem";
	public static final String SERVICE_STATISTIC = "StatisticSystem";
	public static final String SERVICE_FILE = "FileSystem";
	
	// Client view
	public static final int FRAME_WIDTH = 600;
	public static final int FRAME_HEIGHT = 400;
	public static final String CLIENT_NAME = "DS";
	
	// Panels
	public static final String LOGIN_BUTTON = "login";
	public static final String REGISTER_BUTTON = "register";
	public static final String FILE_REPORT = "file report";
	public static final String FILE_UPLOAD = "upload file";
	public static final String USER_LOGOUT = "logout";
	public static final String USER_DELETE = "delete user";
	public static final String FILE_ADD = "add file";
	public static final String FILE_REMOVE = "remove file";
	public static final String FILE_DOWNLOAD = "download";
	public static final String BACK = "back";
	
	// Errors
	public static final int ERROR_NO_CONNECTION = 0;
	public static final int ERROR_USER_LOGIN = 1;
	public static final int ERROR_USER_REGISTER = 2;
	public static final int ERROR_USER_UNREGISTER = 3;
	public static final int ERROR_USER_IS_REGISTER = 4;
	public static final int ERROR_FILE_DOWNLOAD = 5;
	public static final int ERROR_FILE_UPLOAD = 6;
	public static final int ERROR_FILE_AVAILABLE = 7;
	public static final int ERROR_FILE_REMOVE = 8;
	public static final int ERROR_SATISTIC_NUMBER = 9;
	public static final int ERROR_SATISTIC_FILE = 10;
	public static final int ERROR_REGISTER_PASSWORD = 11;
	public static final int ERROR_USER_LOGOUT = 12;
	public static final int ERROR_FILE_NO_CONTENT = 13;
	public static final int ERROR_FILE_NO_SELECTED = 14;
	public static final int SUCCESS_FILE_DOWNLOAD = 15;
	public static final int SUCCESS_FILE_REMOVE = 16;
	
	// Success
	public static final int SUCCESS_REGISTER = 0;
	public static final int SUCCESS_UPLOAD_FILE = 1;
	public static final int SUCCESS_LOGIN = 2;
	public static final int SUCCESS_LOGOUT = 3;
	public static final int SUCCESS_UNREGISTER = 4;
	
	// file report
	public static final int FILE_REPORT_DOWNLOAD = 0;
	public static final int FILE_REPORT_UPLOAD = 1;
	public static final int FILE_REPORT_REMOVE = 2;
	

}
