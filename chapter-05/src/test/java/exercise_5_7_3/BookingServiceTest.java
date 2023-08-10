package exercise_5_7_3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
}