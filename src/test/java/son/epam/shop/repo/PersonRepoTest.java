package son.epam.shop.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.epam.shop.domain.Person;
import com.epam.shop.domain.PersonRole;
import com.epam.shop.repo.PersonRepo;

public class PersonRepoTest {

	@Test
	public void testPersonRepoInsertGet() {

		PersonRepo instance = PersonRepo.getInstance();

		Person p = new Person();
		p.setEmail("ma31drom@gmail.com");
		p.setFirstName("Max");
		p.setLastName("Naumovich");
		p.setLocked(Boolean.FALSE);
		p.setLogin("ma31drom");
		p.setPassword("password");
		p.setRole(PersonRole.ADMIN);

		instance.save(p);

		Person person2 = instance.getById(p.getId());

		assertEquals(p, person2);

		p.setFirstName("Maxim");

		instance.save(p);

		Person personAfterUpdate = instance.getById(p.getId());

		assertEquals("Maxim", personAfterUpdate.getFirstName());

		List<Person> findAllSorded = instance.findAllSorded("first_name", 1, 0);

		assertEquals(p, findAllSorded.get(0));

		instance.deleteById(p.getId());

		assertNull(instance.getById(p.getId()));

	}

}
