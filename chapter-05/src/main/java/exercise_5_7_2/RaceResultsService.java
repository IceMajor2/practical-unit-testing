package exercise_5_7_2;

import java.util.Collection;
import java.util.HashSet;

public class RaceResultsService {

	private Collection<Client> clients = new HashSet<Client>();

	private Logger logger;

	public RaceResultsService(Logger logger) {
		this.logger = logger;
	}

	public void addSubscriber(Client client) {
		clients.add(client);
	}

	public void send(Message message) {
		for (Client client : clients) {
			if (client.getCategories().contains(message.getCategory())
					|| client.getCategories().isEmpty()) {
				client.receive(message);
				logger.log(message, "Message was sent!");
			}
		}
	}

	public void removeSubscriber(Client client) {
		if(!clients.contains(client)) {
			throw new IllegalArgumentException();
		}
		clients.remove(client);
	}
}