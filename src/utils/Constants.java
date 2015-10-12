package utils;

import java.awt.GraphicsConfiguration;

import javax.swing.Icon;

public class Constants {
	
	// DB
	public static final String USERS_FILE = "DB/users/users.json";
	public static final String USERS_RECORDS = "DB/records/user_records.json";
	public static final String FILES_RECORDS = "DB/records/file_records.json";
	public static final String FILE_DIR = "DB/files";
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
	

}
