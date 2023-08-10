package exercise_5_7_3;

import java.time.DayOfWeek;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingServiceTest {

	private Classroom roomA1 = mock(Classroom.class, "A1");
	private Classroom roomB2 = mock(Classroom.class, "B2");
	private Classroom roomC3 = mock(Classroom.class, "C3");
	private BookingService bookingService = new BookingService();

	@Test
	void shouldReturnAllClassrooms() {
		bookingService.addClassroom(roomA1);
		bookingService.addClassroom(roomB2);
		bookingService.addClassroom(roomC3);

		assertThat(bookingService.getClassrooms())
				.containsExactlyInAnyOrder(roomA1, roomB2, roomC3);
	}

	@Test
	void shouldReturnNoClassrooms() {
		assertThat(bookingService.getClassrooms()).isEmpty();
	}

	@Test
	void shouldReturnAvailableClassrooms() {
		bookingService.addClassroom(roomA1);
		bookingService.addClassroom(roomB2);
		bookingService.addClassroom(roomC3);

		when(roomA1.isAvailable(DayOfWeek.FRIDAY, 10, 15)).thenReturn(false);
		when(roomB2.isAvailable(DayOfWeek.FRIDAY, 10, 15)).thenReturn(true);
		when(roomC3.isAvailable(DayOfWeek.FRIDAY, 10, 15)).thenReturn(true);

		assertThat(bookingService.getAvailableClassrooms(DayOfWeek.FRIDAY, 10, 15))
				.containsExactlyInAnyOrder(roomB2, roomC3);

	}
}