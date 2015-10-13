package impls;

import interfaces.FileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import utils.Constants;

import beans.feedbacks.Feedback;
import beans.feedbacks.FileFeedback;

public class FileSystemImpl implements FileSystem {

	public FileFeedback availableFiles() {
		File root = new File(Constants.FILE_DIR);
		
		
		return null;
	}

	public FileFeedback downloadFile(String fileName) {
		File file = new File(Constants.FILE_DIR + "/" + fileName);
		FileFeedback fileFeedback = new FileFeedback();
		if(file.exists()){
			fileFeedback.setFile(file);
			fileFeedback.setResult(Feedback.RESULT_TRUE);
		} else{
			fileFeedback.setResult(Feedback.RESULT_FALSE);
		}
		return fileFeedback;
	}

	// TODO: user thread
	public FileFeedback uploadFile(File file) {
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

		return fileFeedback;
	}

	public FileFeedback removeFile(String fileName) {
		File file = new File(Constants.FILE_DIR + "/" + fileName);
		FileFeedback fileFeedback = new FileFeedback();
		if(file.exists()){
			file.delete();
			fileFeedback.setResult(Feedback.RESULT_TRUE);
		} else{
			fileFeedback.setResult(Feedback.RESULT_FALSE);
		}
		return fileFeedback;
	}

}
