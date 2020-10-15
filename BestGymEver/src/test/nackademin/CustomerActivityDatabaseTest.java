package nackademin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class CustomerActivityDatabaseTest {

	CustomerActivityDatabase cad = new CustomerActivityDatabase();
	
	@Test
	void testIfDatabaseIsCreated() {
		File f = new File("8902025522");
		assertFalse(f.exists());
		
		cad.addActivity(new Customer("Joakim Edberg", "8902025522", LocalDate.parse("1989-02-02")), LocalDate.now());
		assertTrue(f.exists());
			
	}

}
