package nackademin;


import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void throwExceptionIfIdIsTooShort() {

		try {
			cd.getCustomers("customersTest2.txt");
			fail();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void throwExceptionIfIdIsTooLong() {

		try {
			cd.getCustomers("customersTest3.txt");
			fail();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	@Test
	public void throwExceptionIfIdIsDateIsInWrongForm() {

		try {
			cd.getCustomers("customersTest5.txt");
			fail();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testWithTrippleName() {

		try {
			List<Customer> actual = cd.getCustomers("customersTest4.txt");

			assertEquals("Alhambra Aromes Alabama", actual.get(0).getName());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
