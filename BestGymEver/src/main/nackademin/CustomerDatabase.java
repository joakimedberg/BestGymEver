package nackademin;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerDatabase {
	
	private List<Customer> customers = new ArrayList<Customer>();
	private String path;
	
	public CustomerDatabase(String path) {
		this.path = path;
		fetchDatabase();
	}
		
	private void fetchDatabase() {
		
		String id;
		String name;
		String date;
					
		try {
			Scanner sc = new Scanner(new File(path));
			while (sc.hasNextLine()) {
					id = sc.findInLine("[0-9]{10}");	// 10 number ID
					name = sc.findInLine("[A-ZÅÄÖa-zåäö].*[A-ZÅÄÖa-zåäö]"); // first- and last name, incl åäö chars
					sc.nextLine();
					date = sc.findInLine("[0-9]{4}-[0-9]{2}-[0-9]{2}"); // date yyyy-mm-dd

					if ( (id != null) && (name != null) && (date != null) ) {
						customers.add(new Customer(name, id, LocalDate.parse(date) ));
					}
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}
	
	
	
}
