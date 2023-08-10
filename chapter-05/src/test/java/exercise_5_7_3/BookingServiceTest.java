package exercise_5_7_3;

import java.time.DayOfWeek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BookingServiceTest {

	private Classroom roomA1 = mock(Classroom.class, "A1");
	private Classroom roomB2 = mock(Classroom.class, "B2");
	private Classroom roomC3 = mock(Classroom.class, "C3");
	private BookingService bookingService = new BookingService();

	@BeforeEach
	void setUp() {
		when(roomA1.getName()).thenReturn("A1");
		when(roomB2.getName()).thenReturn("B2");
		when(roomC3.getName()).thenReturn("C3");
	}

	@Test
	void shouldReturnAllClassrooms() {
		bookingService.addClassroom(roomA1);
		bookingService.addClassroom(roomB2);
		bookingService.addClassroom(roomC3);

		assertThat(bookingService.getClassrooms())
				.containsExactlyInAnyOrder(roomA1, roomB2, roomC3);
	}

	@Test
	void shouldThrowExceptionWhenDoubleAddingClassroom() {
		bookingService.addClassroom(roomA1);
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> bookingService.addClassroom(roomA1));
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

		when(roomA1.isAvailable(DayOfWeek.FRIDAY, 10, 13)).thenReturn(false);
		when(roomB2.isAvailable(DayOfWeek.FRIDAY, 10, 15)).thenReturn(true);
		when(roomC3.isAvailable(DayOfWeek.FRIDAY, 10, 15)).thenReturn(true);

		assertThat(bookingService.getAvailableClassrooms(DayOfWeek.FRIDAY, 10, 15))
				.containsExactlyInAnyOrder(roomB2, roomC3);
	}

	@ParameterizedTest
	@CsvSource({
			"-5, 5",
			"24, 6",
			"30, 9",
			"15, 24",
			"10, 99",
			"11, -5",
			"24, 24"
	})
	void shouldThrowExceptionWhenGettingAvailableClassroomsWithNonHourNumbers(int from, int to) {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> bookingService.getAvailableClassrooms(DayOfWeek.SATURDAY, from, to));
	}

	@ParameterizedTest
	@CsvSource({
			"10, 8",
			"23, 0",
			"5, 2"
	})
	void shouldThrowExceptionWhenGettingAvailableClassroomsWithInvalidHours(int from, int to) {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> bookingService.getAvailableClassrooms(DayOfWeek.SATURDAY, from, to));
	}

	@Test
	void shouldReturnNoClassroomsWhenNoClassroomWasAdded() {
		assertThat(bookingService.getAvailableClassrooms(DayOfWeek.THURSDAY, 0, 23))
				.isEmpty();
	}

	@Test
	void enableBookingOfClassroomByName() {
		when(roomA1.isAvailable(DayOfWeek.SATURDAY, 15, 16))
				.thenReturn(true);

		bookingService.addClassroom(roomA1);
		bookingService.book("A1", DayOfWeek.SATURDAY, 15, 16);

		verify(roomA1).book(DayOfWeek.SATURDAY, 15, 16);
	}

	@Test
	void shouldDoNothingWhenClassroomIsNotInBookingService() {
		bookingService.book("B2", DayOfWeek.MONDAY, 5, 23);

		verify(roomB2, never()).book(DayOfWeek.MONDAY, 5, 23);
	}

	@ParameterizedTest
	@CsvSource({
			"-1, -24",
			"-1, 6",
			"25, 23",
			"0, 30"
	})
	void throwExceptionOnHourOutOfBounds(int from, int to) {
		bookingService.addClassroom(roomA1);
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> bookingService.book("A1", DayOfWeek.THURSDAY, from, to));
	}

	@ParameterizedTest
	@CsvSource({
			"12, 10",
			"10, 9",
			"23, 15",
			"4, 0"
	})
	void throwExceptionIfFromHourIsGreaterThanToHour(int from, int to) {
		bookingService.addClassroom(roomA1);
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> bookingService.book("A1", DayOfWeek.THURSDAY, from, to));
	}

	@Test
	void enableBookingWithEquipment() {
		when(roomC3.isAvailable(DayOfWeek.TUESDAY, 10, 14)).thenReturn(true);

		bookingService.addClassroom(roomC3);
		bookingService.book("C3", DayOfWeek.TUESDAY, 10, 14, Equipment.PROJECTOR);

		verify(roomC3).book(DayOfWeek.TUESDAY, 10, 14, Equipment.PROJECTOR);
	}
}