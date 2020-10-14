package nackademin;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CustomerDatabaseTest {
	List<Customer> expected = new ArrayList<Customer>();

	
	
	@Test
	void testIfFetchedDataIsValid() {
		// Given
		CustomerDatabase cd = new CustomerDatabase("customersTest.txt");
		expected.add(new Customer("Alhambra Aromes","7603021234", LocalDate.parse("2019-07-01")));
		expected.add(new Customer("Diamanda Djedi","7608021234", LocalDate.parse("2020-01-30")));
		expected.add(new Customer("Åge Snööre","8902020000", LocalDate.parse("2020-11-12")));
		
		// When
		List<Customer> actual = cd.getCustomers();
		
		// Then
		assertEquals(expected, actual);
		
		

	}

}
