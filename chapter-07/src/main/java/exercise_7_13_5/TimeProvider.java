package exercise_7_13_5;

import java.util.Calendar;

public interface TimeProvider {

	Calendar getTime();

	boolean isMorning();
}
