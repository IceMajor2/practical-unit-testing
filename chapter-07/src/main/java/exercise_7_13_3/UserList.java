package exercise_7_13_3;

import java.util.ArrayList;
import java.util.List;

public class UserList {

	private List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return this.users;
	}

	public void addUser(User user) {
		users.add(user);
	}
}
