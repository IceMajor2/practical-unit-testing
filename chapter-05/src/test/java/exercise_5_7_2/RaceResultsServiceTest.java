package exercise_5_7_2;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class RaceResultsServiceTest {

	private RaceResultsService raceResults = new RaceResultsService();

	private Message message = mock(Message.class);

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
	}

	@Test
	void shouldSendMessageOnlyForCategorySubscribers() {
		clientA.addCategory("F1", "cycling");
		clientB.addCategory("football");
		raceResults.addSubscriber(clientA);
		message.addCategory("F1");

		raceResults.send(message);

		verify(clientA).receive(message);
		verify(clientB, never()).receive(message);
	}
}