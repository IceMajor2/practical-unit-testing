package exercise_7_13_4;

import java.util.Calendar;

public class HelpDesk {

	private TimeProvider timeProvider;
	public final static int EOB_HOUR = 17;

	public boolean willHandleIssue(Issue issue) {
		int dayOfWeek = timeProvider.getDay();
		if (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek) {
			return false;
		}
		if (Calendar.FRIDAY == dayOfWeek) {
			int hour = timeProvider.getHour();
			if (hour > EOB_HOUR) {
				return false;
			}
		}
		return true;
	}
}