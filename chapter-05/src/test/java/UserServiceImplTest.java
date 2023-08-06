import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UserServiceImplTest {

	private static final String MD5_HASH = "207023ccb44feb4d7dadca005ce29a64";

	@Test
	void assignPasswordTest() throws Exception {
		// test doubles
		UserDAO dao = mock(UserDAO.class);
		SecurityService security = mock(SecurityService.class);
		User user = mock(User.class);
		// SUT (System Under Test)
		UserServiceImpl SUT = new UserServiceImpl(dao, security);

		when(security.md5(user.getPassword())).thenReturn(MD5_HASH);

		SUT.assignPassword(user);

		verify(dao).updateUser(user);
	}
}