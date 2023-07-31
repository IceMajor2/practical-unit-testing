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
			"21, 22, [21;22]",
			"23, 1, [23;24;1]",
			"2, 3, [2;3]"
	})
	void whenBookingMultipleFreeHours_thenOkTest(int from, int to, String newHoursStr) {
		Integer[] newHours = extractIntegers(newHoursStr);
		assertThat(SUT.getBookings()).doesNotContain(newHours);
		SUT.book(from, to);
		assertThat(SUT.getBookings()).contains(newHours);
	}

	private Integer[] extractIntegers(String string) {
		String substring = string.substring(string.indexOf('[') + 1, string.lastIndexOf(']'));
		String[] numStrs = substring.split(";");
		Integer[] ints = new Integer[numStrs.length];
		int index = 0;
		for (String numStr : numStrs) {
			ints[index] = Integer.valueOf(numStr);
			index++;
		}
		return ints;
	}
}