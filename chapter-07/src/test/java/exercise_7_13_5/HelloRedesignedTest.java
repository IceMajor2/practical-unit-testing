package exercise_7_13_5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HelloRedesignedTest {

	private TimeProvider timeProvider = mock(TimeProvider.class);
	private HelloRedesigned hello = new HelloRedesigned(timeProvider);

	@Test
	void returnGoodMorningOnMorningTest() {
		when(timeProvider.isMorning()).thenReturn(true);

		assertThat(hello.sayHello()).isEqualTo("Good Morning!");
	}

	@Test
	void returnGoodAfternoonOnAfternoonTest() {
		when(timeProvider.isMorning()).thenReturn(false);

		assertThat(hello.sayHello()).isEqualTo("Good Afternoon!");
	}
}