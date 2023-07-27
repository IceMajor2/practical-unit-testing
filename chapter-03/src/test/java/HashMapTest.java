import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class HashMapTest {

	Map<Integer, String> data;

	@BeforeEach
	void setUp() {
		data = new HashMap<>();
		data.put(1, "One");
		data.put(2, "Two");
		data.put(3, "Three");
		data.put(4, "Four");
		data.put(5, "Five");
	}

	@ParameterizedTest
	@CsvSource({
			"1, One",
			"2, Two",
			"3, Three",
			"4, Four",
			"5, Five"
	})
	void getReturnsKeyTest(int key, String value) {
		String actual = data.get(key);
		assertThat(actual).isEqualTo(value);
	}

	@ParameterizedTest
	@CsvSource({
			"1, Jeden",
			"2, Dwa",
			"3, Trzy",
			"4, Cztery",
			"5, Piec"
	})
	void putReplacesPreviousValueTest(int key, String replacement) {
		String previous = data.get(key);
		assertThat(previous).isNotNull();

		data.put(key, replacement);
		String actual = data.get(key);
		assertThat(actual).isEqualTo(replacement);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void clearRemovesAllMappingsTest(int key) {
		assertThat(data).isNotEmpty();
		data.clear();
		assertThat(data).isEmpty();
		String actual = data.get(key);
		assertThat(actual).isNull();
	}

	@Test
	void nullCanBeUsedAsKeyTest() {
		data.put(null, "Nothingness");
		String getNull = data.get(null);
		assertThat(getNull).isEqualTo("Nothingness");
	}
}
