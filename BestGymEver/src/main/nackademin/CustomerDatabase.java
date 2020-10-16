package nackademin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Manages the customer database.
 * @author Joakim Edberg
 *
 */
public class CustomerDatabase {
	private File file;
	private Customer customer;

	/**
	 * Fetches and returns customers from file.
	 * @param path to customer database
	 * @return customers
	 * @throws FileNotFoundException if database file is not found
	 * @throws Exception if faulty information in database
	 */
	public List<Customer> getCustomers(String path) throws FileNotFoundException, Exception {

		List<Customer> customers = new ArrayList<>();

		String id;
		String name;
		String date;

		try (Scanner sc = new Scanner(new File(path))) {
			while (sc.hasNextLine()) {
				id = sc.findInLine("[0-9]{10,11}"); // 10 number ID
				
				name = sc.findInLine("[A-ZÅÄÖa-zåäö].*[A-ZÅÄÖa-zåäö]"); // first- and last name, incl åäö chars
				sc.nextLine();

				date = sc.findInLine("[0-9]{4}-[0-9]{2}-[0-9]{2}"); // date yyyy-mm-dd
				sc.nextLine();

				if ((id != null && id.length() == 10) && (name != null) && (date != null)) {
					customers.add(new Customer(name, id, LocalDate.parse(date)));
				} else {
					throw new Exception("Faulty data in file.");
				}
			}
		}
		return customers;
	}
	
	/**
	 * adds activity to customers file.
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
