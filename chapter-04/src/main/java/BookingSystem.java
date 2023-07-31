import java.util.ArrayList;
import java.util.List;

public class BookingSystem {

	private List<Integer> bookings;

	/**
	 * Allows to book multiple hours: both parameters are inclusive
	 */
	public void book(int from, int to) {
		if(to < from) {
			to += 24;
		}
		for(int i = from; i <= to; i++) {
			bookings.add(i % 24);
		}
	}

	/**
	 * Book only a single hour.
	 */
	public void book(int hour) {

	}

	public List<Integer> getBookings() {
		return bookings;
	}

	public void setBookings(List<Integer> bookings) {
		this.bookings = new ArrayList<>(bookings);
	}
}
