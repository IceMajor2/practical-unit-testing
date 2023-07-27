import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class FahrenheitCelsiusConverterTest {

	@ParameterizedTest
	@CsvSource({
			"0, 32",
			"37, 98",
			"100, 212"
	})
	void shouldConvertCelsiusToFahrenheit(int celsius, int fahrenheit) {
		assertThat(FahrToCelsConverter.toFahrenheit(celsius)).isEqualTo(fahrenheit);
	}

	@ParameterizedTest
	@CsvSource({
			"0, 32",
			"37, 100",
			"100, 212"
	})
	void shouldConvertFahrenheitToCelsius(int celsius, int fahrenheit) {
		assertThat(FahrToCelsConverter.toCelsius(fahrenheit)).isEqualTo(celsius);
	}
}