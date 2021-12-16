package com.epam.shop.repo;

import java.util.Map;

import com.epam.shop.domain.Person;
import com.epam.shop.repo.mapping.PersonMapper;

public class PersonRepo extends AbstractCRUDRepository<Person> {

	private static PersonRepo instance;

	private PersonRepo() {
		super(new PersonMapper(), "person");
		instance = this;
	}

	public static PersonRepo getInstance() {
		if (instance == null) {
			PersonRepo.instance = new PersonRepo();
		}
		return instance;
	}

	protected Map<String, String> updateValues(Person person) {
		return Map.of(
				"last_name","'"+ person.getLastName()+"'", 
				"first_name","'"+ person.getFirstName()+"'", 
				"locked", person.getLocked().toString(), 
				"login", "'"+person.getLogin()+"'", 
				"password","'"+ person.getPassword()+"'", 
				"email", "'"+person.getEmail()+"'", 
				"role", String.valueOf(person.getRole().ordinal())
				);
	}
}
