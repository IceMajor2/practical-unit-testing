package exercise_5_7_3;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;

public class BookingService {

	private Collection<Classroom> classrooms = new ArrayList<>();

	public void addClassroom(Classroom classroom) {
		this.classrooms.add(classroom);
	}

	public Collection<Classroom> getClassrooms() {
		return this.classrooms;
	}

	public void book(Classroom classroom, DayOfWeek day, int from, int to) {
	}

	public Collection<Classroom> getAvailableClassrooms(DayOfWeek day, int from, int to) {
		return null;
	}
}
