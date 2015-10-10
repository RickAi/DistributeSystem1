package beans;

import java.io.Serializable;


public class DSUser implements Serializable {
	
	private String name;
	private String password;
	
	public DSUser(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = this.name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		password = this.password;
	}
	@Override
	public String toString() {
		return "(" + name + " : " + password + ")";
	}

}
