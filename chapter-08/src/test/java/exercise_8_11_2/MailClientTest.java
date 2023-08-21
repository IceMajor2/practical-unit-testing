package exercise_8_11_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MailClientTest {

	private Email email;
	private EmailServer emailServer;
	private MailClient SUT;

	@BeforeEach
	void setUp() {
		this.emailServer = mock(EmailServer.class);
		this.email = new Email("example@ex.com", "Title", "Text");
		this.SUT = new MailClient();
		SUT.setEmailServer(emailServer);
	}

	@Test
	void sendEmailTest() {
		SUT.sendEmail("example@ex.com", "Title", "Text");

		verify(emailServer).sendEmail(email);
	}
}