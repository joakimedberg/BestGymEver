package nackademin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerActivityDatabase {
	private List<CustomerActivity> activities = new ArrayList<CustomerActivity>();
	
	private File file;
	private Customer customer;

	public CustomerActivityDatabase(Customer customer) {
		this.customer = customer;
		
		file = new File(customer.getpersonID());
		if (!file.exists()) {
			createDatabase();
		}
	}

	public List<CustomerActivity> getActivity() {
		return activities;
	}

	public void writeData(LocalDate date) {
		try {
						
			BufferedWriter writer = new BufferedWriter(new FileWriter(customer.getpersonID(), true));
			
			writer.newLine();
			writer.append(date.toString());
			
			writer.close();

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
	
	public void printDatabase() {
		for (CustomerActivity c : activities) {
			System.out.println(c.toString());
		}
	}

}
