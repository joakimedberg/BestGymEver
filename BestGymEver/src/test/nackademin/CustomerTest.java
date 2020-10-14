package nackademin;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void hasActiveMembership() {
		
		// Given
		String name = "Joakim Edberg";
		String personID = "8902020000";
		LocalDate date = LocalDate.parse("2020-02-02");
		Customer customer = new Customer(name, personID, date);
		
		// When
		boolean active = customer.hasActiveMembership();
		
		// Then
		assertTrue(active);
	}
	
	@Test
	void hasNotActiveMembership() {
		
		// Given
		String name = "Joakim Edberg";
		String personID = "8902020000";
		LocalDate date = LocalDate.parse("2018-02-02");
		Customer customer = new Customer(name, personID, date);
		
		// When
		boolean active = customer.hasActiveMembership();
		
		// Then
		assertFalse(active);
	}

}
