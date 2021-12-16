package com.epam.shop.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailService {

	private static EmailService instance;
	private Properties props;

	private final static String UNAME = "training.2021.2.grodno@gmail.com";
	private final static String PASS = "JavaGrodnoTraining2021";

	private EmailService() {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");


		props = prop;
		instance = this;
	}

	public static EmailService getInstance() {
		if (instance == null) {
			EmailService.instance = new EmailService();
		}
		return instance;
	}

	public void notifyUserRegistered(String email, Long id) throws MessagingException {

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(UNAME, PASS);
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("from@training.grodno.epam.com"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		message.setSubject("You were successfully registered");

		String msg = "This is my first email using JavaMailer. New User id is: " + id;

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);

		message.setContent(multipart);

		Transport.send(message);
	}
}
