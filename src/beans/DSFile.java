package beans;

import java.io.File;
import java.util.Date;

public class DSFile {
	
	private File mFile;
	private DSUser mCreator;
	private Date mCreatedTime;
	
	public File getmFile() {
		return mFile;
	}
	public void setmFile(File mFile) {
		this.mFile = mFile;
	}
	public DSUser getmCreator() {
		return mCreator;
	}
	public void setmCreator(DSUser mCreator) {
		this.mCreator = mCreator;
	}
	public Date getmCreatedTime() {
		return mCreatedTime;
	}
	public void setmCreatedTime(Date mCreatedTime) {
		this.mCreatedTime = mCreatedTime;
	}

}
