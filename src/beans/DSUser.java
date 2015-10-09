package beans;

import java.io.Serializable;

public class DSUser implements Serializable {
	
	private String mName;
	private String mPassword;
	
	public String getName() {
		return mName;
	}
	public void setName(String name) {
		mName = name;
	}
	public String getPassword() {
		return mPassword;
	}
	public void setPassword(String password) {
		mPassword = password;
	}

}
