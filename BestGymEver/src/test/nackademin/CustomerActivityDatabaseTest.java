package nackademin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class CustomerActivityDatabaseTest {

	CustomerActivityDatabase cad = new CustomerActivityDatabase();
	
	@Test
	void testIfDatabaseIsCreated() {
		File f = new File("8902025522");
		assertFalse(f.exists());
		
		cad.addActivity(new Customer("Joakim Edberg", "8902025522", LocalDate.parse("1989-02-02")), LocalDate.parse("2020-10-15"));
		assertTrue(f.exists());
		
		
		try (Scanner sc = new Scanner(f)) {
			String expected = "8902025522, Joakim Edberg";
			
			assertEquals(expected, sc.nextLine());
			
			expected = "2020-10-15";
			assertEquals(expected, sc.nextLine());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
