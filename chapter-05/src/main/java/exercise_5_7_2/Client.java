package exercise_5_7_2;

import java.util.List;

public interface Client {
	void receive(Message message);
	List<String> getCategories();
}