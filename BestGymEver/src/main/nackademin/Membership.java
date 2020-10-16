package nackademin;

import java.time.LocalDate;

/**
 * Representing a customers membership.
 * @author Joakim Edberg
 *
 */
public class Membership {
	
	private LocalDate membershipLastPayed;
		
	public Membership (LocalDate membershipLastPayed) {
		this.membershipLastPayed = membershipLastPayed;
	}
	
	/**
	 * Return true if membership have been payed within a year, otherwise returns false.
	 * @param membershipLastPayed
	 * @return 
	 */
	public boolean isActive() {
		if (membershipLastPayed.plusYears(1).isAfter(LocalDate.now())) 
			return true;			
		else
			return false;		
	}
			
	

}
