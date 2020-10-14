package nackademin;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class MembershipTest {

	Membership membership = new Membership();
	
	@Test
	void isActive() {
		// Given
		LocalDate date = LocalDate.parse("2020-06-23");
		
		// When
		boolean isActive = membership.isActive(date);
		
		// Then
		assertTrue(isActive);
	}
	
	@Test
	void isNotActive() {
		// Given
		LocalDate date = LocalDate.parse("2013-06-23");
		
		// When
		boolean isActive = membership.isActive(date);
		
		// Then
		assertFalse(isActive);
	}

}
