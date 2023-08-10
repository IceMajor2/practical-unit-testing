package exercise_5_7_3;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class BookingService {

	private Collection<Classroom> classrooms = new ArrayList<>();

	public void addClassroom(Classroom classroom) {
		this.classrooms.add(classroom);
	}

	public Collection<Classroom> getClassrooms() {
		return this.classrooms;
	}

	public void book(Classroom classroom, DayOfWeek day, int from, int to) {
		classroom.book(day, from, to);
	}

	public Collection<Classroom> getAvailableClassrooms(DayOfWeek day, int from, int to) {
		return this.classrooms.stream()
				.filter(classroom -> classroom.isAvailable(day, from, to))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}
