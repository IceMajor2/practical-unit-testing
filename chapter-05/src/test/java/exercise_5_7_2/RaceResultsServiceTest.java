package exercise_5_7_2;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RaceResultsServiceTest {

	private Logger logger = mock(Logger.class);

	private RaceResultsService raceResults = new RaceResultsService(logger);

	private Message message = mock(Message.class);

	private Message anotherMessage = mock(Message.class);

	private Client clientA = mock(Client.class, "clientA");

	private Client clientB = mock(Client.class, "clientB");


	@Test
	void notSubscribedClientShouldNotReceiveMessage() {
		raceResults.send(message);

		verify(clientA, never()).receive(message);
		verify(clientB, never()).receive(message);
	}

	@Test
	void subscribedClientShouldReceiveMessage() {
		raceResults.addSubscriber(clientA);
		raceResults.send(message);

		verify(clientA).receive(message);
	}

	@Test
	void allSubscribedClientsShouldReceiveMessages() {
		raceResults.addSubscriber(clientA);
		raceResults.addSubscriber(clientB);
		raceResults.send(message);

		verify(clientA).receive(message);
		verify(clientB).receive(message);
	}

	@Test
	void shouldSendOnlyOneMessageToMultiSubscriber() {
		raceResults.addSubscriber(clientA);
		raceResults.addSubscriber(clientA);
		raceResults.send(message);
		verify(clientA).receive(message);
	}

	@Test
	void unsubscribedClientShouldNotReceiveMessages() {
		raceResults.addSubscriber(clientA);
		raceResults.removeSubscriber(clientA);

		raceResults.send(message);

		verify(clientA, never()).receive(message);
		verify(clientB, never()).receive(message);
	}

	@Test
	void shouldSendMessageOnlyForCategorySubscribers() {
		raceResults.addSubscriber(clientA);
		raceResults.addSubscriber(clientB);

		when(clientA.getCategories()).thenReturn(List.of("F1", "cycling"));
		when(clientB.getCategories()).thenReturn(List.of("football"));
		when(message.getCategory()).thenReturn("F1");

		raceResults.send(message);

		verify(clientA).receive(message);
		verify(clientB, never()).receive(message);
	}

	@Test
	void eachSentMessageShouldBeLogged() {
		String logText = "Message was sent!";

		raceResults.addSubscriber(clientA);
		raceResults.addSubscriber(clientB);

		raceResults.send(message);

		verify(logger, times(2)).log(message, logText);
	}

	@Test
	void shouldSentMultipleMessages() {
		raceResults.addSubscriber(clientA);
		raceResults.addSubscriber(clientB);

		raceResults.send(message);
		raceResults.send(anotherMessage);

		verify(clientA).receive(message);
		verify(clientB).receive(message);
		verify(clientA).receive(anotherMessage);
		verify(clientB).receive(anotherMessage);
	}

	@Test
	void unsubscribingWhenAlreadyUnsubscribedShouldReturnVoid() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> raceResults.removeSubscriber(clientA));
	}
}