package exercise_7_13_6;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class OperatingSystemAssert extends AbstractAssert<OperatingSystemAssert, OperatingSystem> {

	public OperatingSystemAssert(OperatingSystem actual) {
		super(actual, OperatingSystemAssert.class);
	}

	public static OperatingSystemAssert assertThat(OperatingSystem actual) {
		return new OperatingSystemAssert(actual);
	}

	public OperatingSystemAssert is128bit() {
		isNotNull();
		Assertions.assertThat(actual.getNbOfBits())
				.withFailMessage("OS number of bits.\n expected: 128\n but was: %d"
						.formatted(actual.getNbOfBits()))
				.isEqualTo(128);
		return this;
	}

	public OperatingSystemAssert wasReleasedIn(int expected) {
		isNotNull();
		Assertions.assertThat(actual.getReleaseYear())
				.withFailMessage("OS release year.\n expected: %d\n but was: %d"
						.formatted(expected, actual.getReleaseYear()))
				.isEqualTo(expected);
		return this;
	}

	public OperatingSystemAssert hasVersion(int expected) {
		isNotNull();
		Assertions.assertThat(actual.getVersion())
				.withFailMessage("OS version.\n expected: %d\n but was: %d"
						.formatted(expected, actual.getVersion()))
				.isEqualTo(expected);
		return this;
	}
}
