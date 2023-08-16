package exercise_7_13_5;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleTimeProviderTest {

	private TimeProvider timeProvider = new SimpleTimeProvider();

	private Calendar calendar = mock(Calendar.class);

	private static int[] morningHours() {
		return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
	}

	@ParameterizedTest
	@MethodSource("morningHours")
	void givenMorningHour_whenIsMorning_thenReturnTrueTest(int morningHour) {
		when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(morningHour);

		assertThat(timeProvider.isMorning()).isTrue();
	}
}
