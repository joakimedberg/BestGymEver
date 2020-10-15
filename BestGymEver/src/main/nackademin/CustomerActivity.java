package nackademin;

import java.time.LocalDate;

/**
 * Entity for customer activity.
 * @author Joakim Edberg
 *
 */
public class CustomerActivity {
	private LocalDate date;

	public CustomerActivity(LocalDate date) {
		this.date = date;
	}
	
	public LocalDate getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "	Activity [date=" + date + "]";
	}

}
