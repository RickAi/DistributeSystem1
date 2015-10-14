package impls;

import interfaces.FileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import managers.StatisticManager;

import utils.Constants;

import beans.DSStatistic;
import beans.DSUser;
import beans.feedbacks.Feedback;
import beans.feedbacks.FileFeedback;

public class FileSystemImpl implements FileSystem {

	public FileFeedback availableFiles() {
		File root = new File(Constants.FILE_DIR);
		String[] strs = root.list();
		List<String> names = Arrays.asList(strs);
		
		FileFeedback fileFeedback = new FileFeedback(Feedback.RESULT_TRUE);
		fileFeedback.setFileNames(names);
		return fileFeedback;
	}

	public FileFeedback downloadFile(String fileName, DSUser user) {
		File file = new File(Constants.FILE_DIR + "/" + fileName);
		FileFeedback fileFeedback = new FileFeedback();
		boolean writeResult = StatisticManager.writeStatstic(Constants.FILE_REPORT_DOWNLOAD, fileName, user);
		if(file.exists() && writeResult){
			fileFeedback.setFile(file);
			fileFeedback.setResult(Feedback.RESULT_TRUE);
		} else{
			fileFeedback.setResult(Feedback.RESULT_FALSE);
		}
		return fileFeedback;
	}

	// TODO: user thread
	public FileFeedback uploadFile(File file, DSUser user) {
		FileInputStream inputStream;
		FileOutputStream outputStream;
		FileFeedback fileFeedback = new FileFeedback();

		File uploadedFile = new File(Constants.FILE_DIR + '/' + file.getName());
		if (uploadedFile.exists()) {
			fileFeedback.setResult(Feedback.RESULT_FALSE);
			return fileFeedback;
		} else {
			try {
				uploadedFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			inputStream = new FileInputStream(file);
			outputStream = new FileOutputStream(uploadedFile);
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = inputStream.read(buf)) > 0) {
				outputStream.write(buf, 0, len);
			}
			if (inputStream != null)
				inputStream.close();
			if (outputStream != null)
				outputStream.close();
			fileFeedback.setResult(Feedback.RESULT_TRUE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fileFeedback.setResult(Feedback.RESULT_FALSE);
		} catch (IOException e) {
			e.printStackTrace();
			fileFeedback.setResult(Feedback.RESULT_FALSE);
		} 
		
		boolean writeResult = StatisticManager.writeStatstic(Constants.FILE_REPORT_DOWNLOAD, file.getName(), user);
		if(writeResult){
			fileFeedback.setResult(Feedback.RESULT_FALSE);
		}

		return fileFeedback;
	}

	public FileFeedback removeFile(String fileName, DSUser user) {
		File file = new File(Constants.FILE_DIR + "/" + fileName);
		FileFeedback fileFeedback = new FileFeedback();
		boolean writeResult = StatisticManager.writeStatstic(Constants.FILE_REPORT_DOWNLOAD, fileName, user);
		if(file.exists() && writeResult){
			file.delete();
			fileFeedback.setResult(Feedback.RESULT_TRUE);
		} else{
			fileFeedback.setResult(Feedback.RESULT_FALSE);
		}
		return fileFeedback;
	}

}
