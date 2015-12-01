/**
 * @Author:Yicun Zeng.
 * @Author:Ryan Wong.
 * @Course:CSC 335.
 * @Instructor:Rick Mercer. 
 * Contains users info and provide validation to JukeBox.
 */
package model;

import java.io.Serializable;
import java.util.HashMap;

public class UserCollection extends HashMap<String,User> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2523280912241692930L;

	public UserCollection() {
		this.put("Chris", new User("Chris", "1"));
		this.put("Devon", new User("Devon", "22"));
		this.put("River", new User("River", "333"));
		this.put("Ryan", new User("Ryan", "4444"));
	}

	public boolean validateStudent(String id, String password) {
		return get(id).getPassword().equals(password);
	}
}
