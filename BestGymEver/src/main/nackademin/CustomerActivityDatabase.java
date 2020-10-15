package nackademin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class CustomerActivityDatabase {

	private File file;
	private Customer customer;

	public void addActivity(Customer customer, LocalDate date) {

		file = new File(customer.getpersonID());
		if (!file.exists()) {
			createDatabase();
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(customer.getpersonID(), true))) {

			writer.newLine();
			writer.append(date.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createDatabase() {

		try {
			file.createNewFile();

			BufferedWriter writer = new BufferedWriter(new FileWriter(customer.getpersonID(), true));
			writer.write(customer.getpersonID() + ", " + customer.getName());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
