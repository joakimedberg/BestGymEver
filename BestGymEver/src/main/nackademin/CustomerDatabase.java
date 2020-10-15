package nackademin;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerDatabase {

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
					throw new Exception("Faulty data in database");
				}
			}
		}
		return customers;

	}

}
