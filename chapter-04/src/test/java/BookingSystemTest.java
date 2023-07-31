import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BookingSystemTest {

	private BookingSystem SUT;
	private List<Integer> bookings = List.of(
			8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21
	);

	@BeforeEach
	void setUp() {
		SUT = new BookingSystem();
		SUT.book(8, 10);
		SUT.book(12, 13);
		SUT.book(14, 17);
		SUT.book(19, 21);
	}

	@Test
	void getBookedHours_shouldReturnListOfBookedHoursTest() {
		List<Integer> actualBookings = SUT.getBookings();
		assertThat(actualBookings).containsExactlyElementsOf(bookings);
	}
}