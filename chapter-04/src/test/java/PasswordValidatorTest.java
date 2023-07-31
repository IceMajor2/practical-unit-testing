import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordValidatorTest {

	@ParameterizedTest
	@ValueSource(strings = { "ostYb_hB7@8#", "mks1\\l__HYHA", "76&JPa_krL01+" })
	void shouldReturnValidOnStrongPasswordTest(String password) {
		assertThat(PasswordValidator.isValid(password))
				.withFailMessage("Validation should return true as password is strong enough")
				.isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = { "ospaLL_][/hJU", "r_j#y&YByE-n_aHY", "gX=h?e#C#*en" })
	void shouldReturnInvalidOnPasswordNoDigitsTest(String password) {
		assertThat(PasswordValidator.isValid(password))
				.withFailMessage("Validation should be false as everything but digits is ok")
				.isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = { "&n2'$xvg<c{m", "4d)@,a_k<r3>?^zxe^", "4>*=)q3-q/y:$w" })
	void shouldReturnInvalidOnPasswordNoUppercaseTest(String password) {
		assertThat(PasswordValidator.isValid(password))
				.withFailMessage("Validation should be false as everything but uppercase letter count is ok")
				.isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = { "CG'+Y.P4&NS$2]", ">$'6D77-#{M5&[KHX}+", "+-_4H+>RWP35" })
	void shouldReturnInvalidOnPasswordNoLowercaseTest(String password) {
		assertThat(PasswordValidator.isValid(password))
				.withFailMessage("Validation should be false as everything but lowercase letter count is ok")
				.isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = { "7nYvL5vK3ddK", "Chu6zHuyqSd8V", "mKzCWgYarhHX2vLHvm5nwa" })
	void shouldReturnInvalidOnPasswordNoSymbolTest(String password) {
		assertThat(PasswordValidator.isValid(password))
				.withFailMessage("Validation should be false as everything but symbol presence is ok")
				.isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = { "eT%P#V'vh6^", "2p:,Du_F", "E7:x7j" })
	void shouldReturnInvalidOnPasswordTooShortTest(String password) {
		assertThat(PasswordValidator.isValid(password))
				.withFailMessage("Validation should be false as everything but password length is ok")
				.isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = { "h3thzt", "vavzxtv828c895zgb", "#O]TIG*CH*_]SHS", "``?;++\\,#^_",
			"~{/?(`$@}59|-5`:4+4284(}[=.\\", "u.ybv\"t<+c^]", ";GAR%,?\\" })
	void shouldReturnInvalidOnPasswordFailingMultipleConstraintsTest(String password) {
		assertThat(PasswordValidator.isValid(password)).isFalse();
	}
}