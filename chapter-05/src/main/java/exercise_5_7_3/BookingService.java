package exercise_5_7_3;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class BookingService {

	private Collection<Classroom> classrooms = new ArrayList<>();

	public void addClassroom(Classroom classroom) {
		if(this.classrooms.contains(classroom)) throw new IllegalArgumentException();
		this.classrooms.add(classroom);
	}

	public Collection<Classroom> getClassrooms() {
		return this.classrooms;
	}

	public void book(String classroomName, DayOfWeek day, int from, int to, Equipment... equipment) {
		isHourValid(from, to);
		Classroom classroom = this.getByClassroomName(classroomName);
		if(classroom != null) classroom.book(day, from, to, equipment);
	}

	public Collection<Classroom> getAvailableClassrooms(DayOfWeek day, int from, int to) {
		return this.classrooms.stream()
				.filter(classroom -> classroom.isAvailable(day, from, to))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	private void isHourValid(int from, int to) {
		throwExceptionWhenNumberIsNotHour(from);
		throwExceptionWhenNumberIsNotHour(to);
		if(to < from) throw new IllegalArgumentException();
	}

	private void throwExceptionWhenNumberIsNotHour(int number) {
		if(number < 0 || number > 23) throw new IllegalArgumentException();
	}

	private Classroom getByClassroomName(String classroomName) {
		return this.classrooms.stream()
				.filter(classroom -> classroom.getName().equals(classroomName))
				.findFirst()
				.orElse(null);
	}
}
