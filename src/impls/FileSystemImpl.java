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
		return null;
	}

	public FileFeedback downloadFile() {
		return null;
	}
	
	public FileFeedback uploadFile(File file) {
		FileInputStream inputStream;  
        FileOutputStream outputStream;
        FileFeedback fileFeedback = new FileFeedback();
        
        
        File uploadedFile = new File(Constants.FILE_DIR + '/' + file.getName());
        if(uploadedFile.exists()){
        		fileFeedback.setResult(Feedback.RESULT_FALSE);
        		return fileFeedback;
        } else{
        		try {
					uploadedFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
        }
        
		try {
			inputStream = new FileInputStream(file);  
			outputStream = new FileOutputStream(Constants.FILE_DIR);
			int b = 0;  
			byte[] buffer = new byte[512];  
			while (b != -1){  
				b = inputStream.read(buffer);  
				//4.写到输出流(out)中  
				outputStream.write(buffer,0,b);  
			}  
			outputStream.flush(); 
			inputStream.close();  
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

	public FileFeedback removeFile() {
		return null;
	}

}
