import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BookingSystem {

	private Set<Integer> bookings;

	/**
	 * Allows to book multiple hours: both parameters are inclusive.
	 */
	public boolean book(int from, int to) {
		if(from < 0 || from > 23 || to < 0 || to > 24){
			throw new IllegalArgumentException("Hours are numbers between <0;23>");
		}
		if (to < from) {
			to += 24;
		}
		Set<Integer> hoursToBook = new HashSet<>();
		for (int i = from; i <= to; i++) {
			int hour = i % 24;
			if(bookings.contains(hour)) return false;
			hoursToBook.add(hour);
		}
		bookings.addAll(hoursToBook);
		return true;
	}

	/**
	 * Book only a single hour.
	 */
	public boolean book(int hour) {
		return book(hour, hour);
	}

	public Set<Integer> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Integer> bookings) {
		this.bookings = new LinkedHashSet<>(bookings);
	}
}
