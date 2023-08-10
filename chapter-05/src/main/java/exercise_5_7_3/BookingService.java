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

	public void book(String classroomName, DayOfWeek day, int from, int to) {
		throwExceptionWhenNumberIsNotHour(from);
		throwExceptionWhenNumberIsNotHour(to);
		Classroom classroom = this.getByClassroomName(classroomName);
		classroom.book(day, from, to);
	}

	private void throwExceptionWhenNumberIsNotHour(int number) {
		if(number < 0 || number > 24) throw new IllegalArgumentException();
	}

	private Classroom getByClassroomName(String classroomName) {
		return this.classrooms.stream()
				.filter(classroom -> classroom.getName().equals(classroomName))
				.findFirst()
				.orElse(null);
	}

	public Collection<Classroom> getAvailableClassrooms(DayOfWeek day, int from, int to) {
		return this.classrooms.stream()
				.filter(classroom -> classroom.isAvailable(day, from, to))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}
