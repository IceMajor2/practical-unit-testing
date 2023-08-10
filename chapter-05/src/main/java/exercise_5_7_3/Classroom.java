package exercise_5_7_3;

import java.time.DayOfWeek;

public class Classroom {

	public int getCleaningHour() {
		return -1;
	}

	public String getName() {
		return null;
	}

	public void book(DayOfWeek day, int from, int to, Equipment... equipment) {
//		IMPLEMENTATION:
//		List<Integer> bookedHours = bookings.getOrDefault(day, new ArrayList<>());
//		for(int i = from; i < to; i++) {
//			bookedHours.add(i);
//		}
//		bookings.put(day, bookedHours);
	}

	public boolean isAvailable(DayOfWeek day, int from, int to) {
		return false;
//		IMPLEMENTATION:
//		List<Integer> bookedHours = bookings.get(day);
//		if(bookedHours == null) return true;
//		for(int i = from; i < to; i++) {
//			if(bookedHours.contains(i)) return false;
//		}
//		return true;
	}
}
