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

	@ParameterizedTest
	@ValueSource(strings = {"ospaLL_][/hJU", "r_j#y&YByE-n_aHY", "gX=h?e#C#*en"})
	void shouldReturnInvalidOnPasswordNoDigitsTest(String password) {
		assertThat(PasswordValidator.isValid(password))
				.withFailMessage("Validation should be false as everything but digits is ok")
				.isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"&n2'$xvg<c{m", "4d)@,a_k<r3>?^zxe^", "4>*=)q3-q/y:$w"})
	void shouldReturnInvalidOnPasswordNoUppercaseTest(String password) {
		assertThat(PasswordValidator.isValid(password))
				.withFailMessage("Validation should be false as everything but uppercase letter count is ok")
				.isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"CG'+Y.P4&NS$2]", ">$'6D77-#{M5&[KHX}+", "+-_4H+>RWP35"})
	void shouldReturnInvalidOnPasswordNoLowercaseTest(String password) {
		assertThat(PasswordValidator.isValid(password))
				.withFailMessage("Validation should be false as everything but lowercase letter count is ok")
				.isFalse();
	}
}