package exercise_7_13_4;

import java.util.Calendar;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HelpDeskTest {


	private TimeProvider timeProvider = mock(TimeProvider.class);

	private HelpDesk helpDesk = new HelpDesk(timeProvider);

	private Issue issue = mock(Issue.class);

	static Stream<Integer> workingHoursOnFriday() {
		return Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
				10, 11, 12, 13, 14, 15, 16, 17);
	}

	static Stream<Integer> workingHours() {
		return Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
				10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
				20, 21, 22, 23);
	}

	@ParameterizedTest
	@MethodSource("workingHoursOnFriday")
	void handlingIssueOnFridayIsAvailableOnlyUntilEOBHour(int workingHour) {
		when(timeProvider.getDay()).thenReturn(Calendar.FRIDAY);
		when(timeProvider.getHour()).thenReturn(workingHour);

		assertThat(helpDesk.willHandleIssue(issue)).isTrue();
	}

	@ParameterizedTest
	// '2' is Monday, '3' is Tuesday, '4' is Wednesday, '5' is Thursday
	@ValueSource(ints = {2, 3, 4, 5})
	void handlingIssueOnBusinessDaysTest(int day) {
		workingHours().forEach(hour -> {
			when(timeProvider.getHour()).thenReturn(hour);
			when(timeProvider.getDay()).thenReturn(day);

			assertThat(helpDesk.willHandleIssue(issue)).isTrue();
		});
	}

	@Test
	void givenNullAsIssue_whenWillHandleIssue_thenExpectExceptionThrownTest() {
		assertThatExceptionOfType(NullPointerException.class)
				.isThrownBy(() -> helpDesk.willHandleIssue(null));
	}

	// I'm unsure whether the below tests should be implemented.
	// They make production code way bigger and less readable.
	// But I'm going by the suggestions in the book.
	@ParameterizedTest
	@ValueSource(ints = {8, 9, 10, 93825, -5})
	void willHandleIssue_unexpectedValueFromGetDayDOCTest(int invalidDay) {
		when(timeProvider.getDay()).thenReturn(invalidDay);

		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> helpDesk.willHandleIssue(issue));
	}
}