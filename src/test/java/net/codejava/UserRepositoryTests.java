package net.codejava;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository repo;

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setPnr("df1234");
		user.setSeatNO("w3");
		user.setBaggage("21");
		user.setEmail("ravikumar@gmail.com");
		user.setPassword("ravi2020");
		user.setFirstName("Ravi");
		user.setLastName("Kumar");

		User savedUser = repo.save(user);

		User existUser = entityManager.find(User.class, savedUser.getId());

		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

	}

	
	  @Test public void testFindByEmail() { 
		  String email = "name@codejava.net"; 
	  User user = repo.findByEmail(email);
	  
	  assertThat(user.getEmail()).isEqualTo(email); }
	 

}
