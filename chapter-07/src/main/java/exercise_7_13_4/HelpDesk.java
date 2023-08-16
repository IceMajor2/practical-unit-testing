package exercise_7_13_4;

import java.util.Calendar;

public class HelpDesk {

	private TimeProvider timeProvider;
	public final static int EOB_HOUR = 17;

	public HelpDesk(TimeProvider timeProvider) {
		this.timeProvider = timeProvider;
	}

	public boolean willHandleIssue(Issue issue) {
		if(issue == null) throw new NullPointerException();
		int dayOfWeek = timeProvider.getDay();
		if(dayOfWeek < 1 || dayOfWeek > 7) throw new IllegalArgumentException();
		if (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek) {
			return false;
		}
		if (Calendar.FRIDAY == dayOfWeek) {
			int hour = timeProvider.getHour();
			if(hour < 0 || hour > 23) throw new IllegalArgumentException();
			if (hour > EOB_HOUR) {
				return false;
			}
		}
		return true;
	}
}