package son.epam.shop.service;

import javax.mail.MessagingException;

import org.junit.Test;

import com.epam.shop.service.EmailService;

public class EmailServiceTest {

	@Test
	public void testMessageSending() throws MessagingException {

		EmailService.getInstance().notifyUserRegistered("ma31drom@gmail.com", 1L);

	}

}
