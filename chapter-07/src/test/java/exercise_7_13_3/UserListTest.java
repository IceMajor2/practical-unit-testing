package exercise_7_13_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserListTest {

	private UserList userList;

	@BeforeEach
	void setUp() {
		this.userList = new UserList();
	}

	@Test
	void expectEmptyList_whenNoUserWasAddedTest() {
		assertThat(userList.getUsers()).isEmpty();
	}
}