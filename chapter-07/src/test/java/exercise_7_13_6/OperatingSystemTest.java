package exercise_7_13_6;

import org.junit.jupiter.api.Test;

class OperatingSystemTest {

	private OperatingSystem os;

	@Test
	void testUsingMatcher() {
		OperatingSystem min9 = new Mindows9();
		OperatingSystemAssert.assertThat(min9)
				.is128bit()
				.wasReleasedIn(2019)
				.hasVersion(9);
	}
}