package nackademin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity for customer.
 * @author Joakim Edberg
 *
 */
public class Customer {

	private LocalDate membershipLastPayed;
	private String name, personID;
	private Membership membership;

	public Customer(String name, String personID, LocalDate membershipLastPayed) {

		membership = new Membership();

		this.membershipLastPayed = membershipLastPayed;
		this.name = name;
		this.personID = personID;
	}

	public boolean hasActiveMembership() {
		return membership.isActive(membershipLastPayed);
	}
	
	public Membership getMembership() {
		return membership;
	}

	public String getName() {
		return name;
	}

	public String getpersonID() {
		return personID;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", personID=" + personID + ", active=" + hasActiveMembership() + "]";
	}

	/**
	 * Overrides equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || (this.getClass() != obj.getClass())) {
			return false;
		}

		Customer guest = (Customer) obj;

		return (guest.name.equals(name) 
				&& guest.personID.equals(personID) 
				&& guest.membershipLastPayed.equals(membershipLastPayed));
	}

}
