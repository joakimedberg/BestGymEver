package nackademin;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class CustomerDatabaseTest {
	List<Customer> expected = new ArrayList<Customer>();
	CustomerDatabase cd = new CustomerDatabase();

	@Test
	void testIfDataIsValid() {

		try {
			// Given
			expected.add(new Customer("Alhambra Aromes", "7603021234", LocalDate.parse("2019-07-01")));
			expected.add(new Customer("Diamanda Djedi", "7608021234", LocalDate.parse("2020-01-30")));
			expected.add(new Customer("Åge Snööre", "8902027559", LocalDate.parse("2020-11-12")));

			// When
			List<Customer> actual;
			actual = cd.getCustomers("customersTest.txt");
			
			// Then
			assertEquals(expected, actual);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void throwExceptionIfIdIsTooShort() {

		try {
			cd.getCustomers("customersTest2.txt");
			fail();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void throwExceptionIfIdIsTooLong() {

		try {
			cd.getCustomers("customersTest3.txt");
			fail();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

	@Test
	public void throwExceptionIfIdIsDateIsInWrongForm() {

		try {
			cd.getCustomers("customersTest5.txt");
			fail();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testWithTrippleName() {

		try {
			List<Customer> actual = cd.getCustomers("customersTest4.txt");

			assertEquals("Alhambra Aromes Alabama", actual.get(0).getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	void testIfDatabaseIsCreated() {
		Random r = new Random();
		String id = String.valueOf(r.nextInt((999999-190000) + 1 ) + 190000);
		File f = new File(id + ".txt");
		assertFalse(f.exists());
		
		cd.addActivity(new Customer("Joakim Edberg", id , LocalDate.parse("1989-02-02")), LocalDate.parse("2020-10-15"));
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
