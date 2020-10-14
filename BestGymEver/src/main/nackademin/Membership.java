package nackademin;

import java.time.LocalDate;

public class Membership {
	
	public boolean isActive(LocalDate membershipLastPayed) {
		if (membershipLastPayed.plusYears(1).isAfter(LocalDate.now())) 
			return true;			
		else
			return false;		
	}
			
	

}
