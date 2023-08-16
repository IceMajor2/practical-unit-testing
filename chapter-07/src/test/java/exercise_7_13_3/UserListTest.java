package exercise_7_13_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class UserListTest {

	private UserList userList;
	private User userA = mock(User.class, "userA");
	private User userB = mock(User.class, "userB");

	@BeforeEach
	void setUp() {
		this.userList = new UserList();
	}

	@Test
	void expectEmptyList_whenNoUserWasAddedTest() {
		assertThat(userList.getUsers()).isEmpty();
	}

	@Test
	void expectUserListOfOneSize_whenOneUserWasAddedTest() {
		userList.addUser(userA);
		assertThat(userList.getUsers())
				.containsExactly(userA);
	}

	@Test
	void expectUserListOfTwoSize_whenTwoUsersWereAddedTest() {
		userList.addUser(userA);
		userList.addUser(userB);
		assertThat(userList.getUsers())
				.containsExactly(userA, userB);
	}
}