package exercise_7_13_5;

import java.util.Calendar;

public class SimpleTimeProvider implements TimeProvider {

	private Calendar calendar;

	public SimpleTimeProvider() {
		this.calendar = Calendar.getInstance();
	}

	public SimpleTimeProvider(Calendar calendar) {
		this.calendar = calendar;
	}

	@Override
	public boolean isMorning() {
		return calendar.get(Calendar.HOUR_OF_DAY) < 12;
	}
}
