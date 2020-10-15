package nackademin;

import java.time.LocalDate;

/**
 * 
 * @author Joakim Edberg
 *
 */
public class Membership {
	
	/**
	 * Return true if membership have been payed within a year, otherwise returns false.
	 * @param membershipLastPayed
	 * @return
	 */
	public boolean isActive(LocalDate membershipLastPayed) {
		if (membershipLastPayed.plusYears(1).isAfter(LocalDate.now())) 
			return true;			
		else
			return false;		
	}
			
	

}
