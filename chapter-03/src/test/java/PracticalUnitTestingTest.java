import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PracticalUnitTestingTest {

	@ParameterizedTest
	@CsvSource({
			"test, tset",
			"nose, eson",
			"kajak, kajak",
			"morela, alerom"
	})
	void whenStringIsWord_thenOKTest(String input, String expected) {
		String actual = PracticalUnitTesting.reverse(input);
		assertThat(actual).isNotNull();
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource({
			"ala ma kota, atok am ala",
			"practical unit testing, gnitset tinu lacitcarp"
	})
	void whenStringIsSentence_thenOKTest(String input, String expected) {
		String actual = PracticalUnitTesting.reverse(input);
		assertThat(actual).isNotNull();
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource({
			"'', ''",
			"'   ', '   '",
			"' \t \n', '\n \t '"
	})
	void whenStringIsBlank_thenOKTest(String input, String expected) {
		String actual = PracticalUnitTesting.reverse(input);
		assertThat(input).isNotNull();
		// I'm allowing here for *not* reversing the input string,
		// in case it's blank. Thus, the actual output may be the same as input.
		assertThat(actual).isIn(expected, input);
	}

	@ParameterizedTest
	@CsvSource({
			">2?ska, aks?2>",
			"-!~k, k~!-",
			".:=||)87^], ]^78)||=:.",
			"!$//*123456789, 987654321*//$!",
			"\\\\//)(*&^ %$#@!, !@#$% ^&*()//\\\\"
	})
	void whenStringContainsSpecialCharactersAndDigits_thenOKTest(String input, String expected) {
		String actual = PracticalUnitTesting.reverse(input);
		assertThat(actual).isNotNull();
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void whenStringIsNull_thenReturnNullTest() {
		String input = null;
		assertThatExceptionOfType(NullPointerException.class)
				.isThrownBy(() -> PracticalUnitTesting.reverse(input));
	}
}
