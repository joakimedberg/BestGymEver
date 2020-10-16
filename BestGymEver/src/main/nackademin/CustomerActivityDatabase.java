package nackademin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Manages customer activity database.
 * @author Joakim Edberg
 *
 */
public class CustomerActivityDatabase {

	private File file;
	private Customer customer;

	/**
	 * adds activity to the database.
	 * @param customer 
	 * @param date date for activity
	 */
	public void addActivity(Customer customer, LocalDate date) {
		this.customer = customer;

		file = new File(customer.getpersonID() + ".txt");
		if (!file.exists()) {
			createDatabase();
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(customer.getpersonID() + ".txt", true))) {

			writer.newLine();
			writer.append(date.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createDatabase() {
	
		try {
			file.createNewFile();

			BufferedWriter writer = new BufferedWriter(new FileWriter(customer.getpersonID() + ".txt", true));
			writer.write(customer.getpersonID() + ", " + customer.getName());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
