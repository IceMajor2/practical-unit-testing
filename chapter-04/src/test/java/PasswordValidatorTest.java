import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PasswordValidatorTest {

	@Test
	void shouldReturnValidOnStrongPasswordTest() {
		String password = "ostYb_hB7@8#";
		assertThat(PasswordValidator.isValid(password))
				.withFailMessage("Validation should return true as password is strong enough")
				.isTrue();
	}
}