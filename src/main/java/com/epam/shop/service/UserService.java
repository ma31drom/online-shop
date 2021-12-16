package com.epam.shop.service;

import javax.mail.MessagingException;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.shop.domain.Person;
import com.epam.shop.domain.PersonRole;
import com.epam.shop.exception.UserNotFoundForLoginException;
import com.epam.shop.repo.PersonRepo;

public class UserService {

	public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	private static UserService instance;

	private UserService() {

		instance = this;
	}

	public static UserService getInstance() {
		if (instance == null) {
			UserService.instance = new UserService();
		}
		return instance;
	}

	public Person registerUser(String firstName, String lastName, String login, String password,
			String email) {

		String hashPassword = hashPassword(password);

		Person person = new Person();

		person.setEmail(email);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setLocked(Boolean.FALSE);
		person.setLogin(login);
		person.setPassword(hashPassword);
		person.setRole(PersonRole.USER);

		Person save = PersonRepo.getInstance().save(person);

		try {
			EmailService.getInstance().notifyUserRegistered(email, save.getId());
		} catch (MessagingException e) {
			LOGGER.error("MEssage sending failed", e);
		}
		return save;
	}

	public Person login(String login, String password) {
		Person findByLogin = PersonRepo.getInstance().findByLogin(login);
		if (findByLogin != null) {
			String hashInDB = findByLogin.getPassword();
			String hashPassword = hashPassword(password);
			if (hashInDB.equals(hashPassword)) {
				return findByLogin;
			}
		}
		throw new UserNotFoundForLoginException(login);
	}

	private String hashPassword(String password) {
		return DigestUtils.md5Hex(password).toUpperCase();
	}
}
