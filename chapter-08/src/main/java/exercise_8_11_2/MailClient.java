package exercise_8_11_2;

public class MailClient {

	public void sendEmail(String address, String title, String body) {
		Email email = new Email(address, title, body);
		EmailServer.sendEmail(email);
	}
}