package exercise_8_11_1;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringReverseTest {

	@Test
	void reverseTest() {
		String toReverse = RandomStringUtils.randomAlphabetic(100);
		String expected = StringUtils.reverse(toReverse);

		assertThat(StringReverse.reverse(toReverse)).isEqualTo(expected);
	}
}