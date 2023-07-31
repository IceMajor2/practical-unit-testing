import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BookingSystemTest {

	private BookingSystem SUT;

	private Set<Integer> bookings = Set.of(
			8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20
	);

	@BeforeEach
	void setUp() {
		SUT = new BookingSystem();
		SUT.setBookings(bookings);
	}

	@Test
	void getBookedHours_shouldReturnListOfBookedHoursTest() {
		Set<Integer> actualBookings = SUT.getBookings();
		assertThat(actualBookings).hasSameElementsAs(bookings);
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 11, 21 })
	void whenBookingSingleFreeHour_thenOkTest(int hour) {
		assertThat(SUT.getBookings()).doesNotContain(hour);
		assertThat(SUT.book(hour)).isTrue();
		assertThat(SUT.getBookings()).contains(hour);
	}

	@ParameterizedTest
	@CsvSource({
			"21, 22, [21;22]",
			"23, 1, [23;0;1]",
			"2, 3, [2;3]"
	})
	void whenBookingMultipleFreeHours_thenOkTest(int from, int to, String newHoursStr) {
		Integer[] newHours = extractIntegers(newHoursStr);
		assertThat(SUT.getBookings()).doesNotContain(newHours);
		assertThat(SUT.book(from, to)).isTrue();
		assertThat(SUT.getBookings()).contains(newHours);
	}

	@ParameterizedTest
	@ValueSource(ints = { 15, 20, 8, 12 })
	void whenBookingTakenHour_returnFalseTest(int hour) {
		boolean result = SUT.book(hour);
		assertThat(result)
				.withFailMessage("Already-booked hour should not be allowed to be booked again")
				.isFalse();
	}

	@ParameterizedTest
	@CsvSource({
			"6, 8",
			"10, 14",
			"11, 12",
			"19, 20"
	})
	void whenMultipleBookingTakenHour_returnFalseTest(int from, int to) {
		assertThat(SUT.book(from, to)).isFalse();
		assertThat(SUT.getBookings()).isEqualTo(bookings);
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