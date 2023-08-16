package exercise_7_13_5;

public class HelloRedesigned {
	
	private TimeProvider timeProvider;

	public HelloRedesigned(TimeProvider timeProvider) {
		this.timeProvider = timeProvider;
	}

	public String sayHello() {
		if (timeProvider.isMorning()) {
			return "Good Morning!";
		}
		return "Good Afternoon!";
	}
}