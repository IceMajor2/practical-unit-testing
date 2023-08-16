package exercise_7_13_4;

import java.util.Calendar;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HelpDeskTest {



	private TimeProvider timeProvider = mock(TimeProvider.class);
	private HelpDesk helpDesk = new HelpDesk(timeProvider);
	private Issue issue = mock(Issue.class);

	static Stream<Integer> workingHoursOnFriday() {
		return Stream.of(
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
				10, 11, 12, 13, 14, 15, 16, 17, 18
		);
	}

	@ParameterizedTest
	@MethodSource("workingHoursOnFriday")
	void handlingIssueOnFridayIsAvailableOnlyUntilEOBHour(int workingHour) {
		when(timeProvider.getDay()).thenReturn(Calendar.FRIDAY);
		when(timeProvider.getHour()).thenReturn(workingHour);

		assertThat(helpDesk.willHandleIssue(issue)).isTrue();
	}
}