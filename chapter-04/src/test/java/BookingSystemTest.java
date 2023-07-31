import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class BookingSystemTest {

	private BookingSystem SUT;

	private List<Integer> bookings = List.of(
			8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20
	);

	@BeforeEach
	void setUp() {
		SUT = new BookingSystem();
		SUT.setBookings(bookings);
	}

	@Test
	void getBookedHours_shouldReturnListOfBookedHoursTest() {
		List<Integer> actualBookings = SUT.getBookings();
		assertThat(actualBookings).containsExactlyElementsOf(bookings);
	}

	@ParameterizedTest
	@CsvSource({
			"21, 22",
			"23, 1",
			"2, 3"
	})
	void whenBookingMultipleFreeHours_thenOkTest(int from, int to) {
		assertThat(SUT.getBookings()).doesNotContain(21, 22, 23, 24, 1, 2, 3);
		SUT.book(from, to);
		assertThat(SUT.getBookings()).contains(21, 22, 23, 24, 1, 2, 3);
	}
}