package exercise_5_7_3;

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
}
