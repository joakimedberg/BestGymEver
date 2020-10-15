package nackademin;

import java.io.File;
import java.io.FileNotFoundException;
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
		int row = 1;
					
		try (Scanner sc = new Scanner(new File(path))){			
			while (sc.hasNextLine()) {
					id = sc.findInLine("[0-9]{10}");	// 10 number ID
					name = sc.findInLine("[A-ZÅÄÖa-zåäö].*[A-ZÅÄÖa-zåäö]"); // first- and last name, incl åäö chars
					sc.nextLine();
					++row;
					date = sc.findInLine("[0-9]{4}-[0-9]{2}-[0-9]{2}"); // date yyyy-mm-dd
					sc.nextLine();
					++row;
					if ( (id != null) && (name != null) && (date != null) ) {
						customers.add(new Customer(name, id, LocalDate.parse(date) ));
					}
					else {
						throw new Exception("Fault in file at ROW " + row);
					}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}
	
	public void printDatabase() {
		for (Customer c : customers) {
			System.out.println(c.toString());
		}
	}
	
	
	
}
