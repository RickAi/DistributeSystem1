package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class DSUsers implements Serializable {
	
	/**
	 * 
	 * DSUsers is the collection of users, it contains a list of user
	 * 
	 */
	
	private List<DSUser> users = new ArrayList<DSUser>();

	public List<DSUser> getUsers() {
		return users;
	}

	public void setUsers(List<DSUser> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (DSUser user : users) {
			builder.append(user + "\n");
		}
		return builder.toString();
	}
	
	public List<String> getNames(){
		List<String> names = new ArrayList<String>();
		for (DSUser user : users) {
			names.add(user.getName());
		}
		return names;
	}
	
}
