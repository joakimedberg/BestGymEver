package nackademin;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class CustomerActivityDatabaseTest {

	CustomerActivityDatabase cad = new CustomerActivityDatabase();
	
	@Test
	void testIfDatabaseIsCreated() {
		Random r = new Random();
		String id = String.valueOf(r.nextInt((999999-190000) + 1 ) + 190000);
		File f = new File(id + ".txt");
		assertFalse(f.exists());
		
		cad.addActivity(new Customer("Joakim Edberg", id , LocalDate.parse("1989-02-02")), LocalDate.parse("2020-10-15"));
		assertTrue(f.exists());
		
		
		try (Scanner sc = new Scanner(f)) {
			String expected = id + ", Joakim Edberg";
			
			assertEquals(expected, sc.nextLine());
			
			expected = "2020-10-15";
			assertEquals(expected, sc.nextLine());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
