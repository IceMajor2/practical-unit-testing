package exercise_7_13_5;

import java.util.Calendar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleTimeProviderTest {

	private Calendar calendar = mock(Calendar.class);

	private TimeProvider timeProvider = new SimpleTimeProvider(calendar);

	private static int[] morningHours() {
		return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
	}

	private static int[] afternoonHours() {
		return new int[] { 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 };
	}

	@ParameterizedTest
	@MethodSource("morningHours")
	void givenMorningHour_whenIsMorning_thenReturnTrueTest(int morningHour) {
		when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(morningHour);

		assertThat(timeProvider.isMorning()).isTrue();
	}

	@ParameterizedTest
	@MethodSource("afternoonHours")
	void givenAfternoonHour_whenIsMorning_thenReturnFalseTest(int afternoonHour) {
		when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(afternoonHour);

		assertThat(timeProvider.isMorning()).isFalse();
	}
}
