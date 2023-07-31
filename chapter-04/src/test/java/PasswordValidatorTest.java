import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordValidatorTest {

	@ParameterizedTest
	@ValueSource(strings = {"ostYb_hB7@8#", "mks1\\l__HYHA", "76&JPa_krL01+"})
	void shouldReturnValidOnStrongPasswordTest(String password) {
		assertThat(PasswordValidator.isValid(password))
				.withFailMessage("Validation should return true as password is strong enough")
				.isTrue();
	}
}