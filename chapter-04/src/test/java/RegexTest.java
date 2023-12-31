import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class RegexTest {

	@ParameterizedTest
	@CsvSource(value = {
			"abc 12; ''",
			"cdefg 345 12bb23; 345",
			"cdefg 345 12bbb33 678tt; 345, 678",
			"ofds002la021 410358; 002, 021, 410358",
			"ksauokfsdornspvfuIUFk; ''",
			"IOSdjaJS0akKna12 20Lo123938%% kauAn492; 123938, 492"
	}, delimiter = ';')
	void shouldReturnDigitSequencesLongerThanTwoTest(String input, String expected) {
		String actual = Regex.digitSequence(input);
		assertThat(actual).isNotNull();
		assertThat(actual).isEqualTo(expected);
	}
}