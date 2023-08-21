package exercise_8_11_2;

public class MailClient {

	private EmailServer emailServer;

	public void setEmailServer(EmailServer emailServer) {
		this.emailServer = emailServer;
	}

	public void sendEmail(String address, String title, String body) {
		Email email = new Email(address, title, body);
		this.emailServer.sendEmail(email);
	}
}