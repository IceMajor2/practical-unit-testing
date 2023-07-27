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
	void whenStringIsWord_thenReturnReversedTest(String input, String expected) {
		String actual = PracticalUnitTesting.reverse(input);
		assertThat(actual).isNotNull();
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource({
			"ala ma kota, atok am ala",
			"practical unit testing, gnitset tinu lacitcarp"
	})
	void whenStringIsSentence_thenReturnReversedTest(String input, String expected) {
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
	void whenStringIsBlank_thenReverseShouldNotChangeTest(String input, String expected) {
		String actual = PracticalUnitTesting.reverse(input);
		assertThat(input).isNotNull();
		assertThat(actual).isIn(expected, input);
	}

	@Test
	void whenStringIsNull_thenReturnNullTest() {
		String input = null;
		assertThatExceptionOfType(NullPointerException.class)
				.isThrownBy(() -> PracticalUnitTesting.reverse(input));
	}
}
