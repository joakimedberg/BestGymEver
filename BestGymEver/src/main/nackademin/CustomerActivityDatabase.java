package nackademin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerActivityDatabase {
	private List<CustomerActivity> activities;
	
	private File file;
	private Customer customer;

	public CustomerActivityDatabase(Customer customer) {
		activities = new ArrayList<CustomerActivity>();
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
	
	public void fetchData() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(customer.getpersonID()));
			
			String row;
	
			reader.readLine();
			while (( row = reader.readLine()) != null) {	
					activities.add(new CustomerActivity(LocalDate.parse(row)));		
			}			
			reader.close();
			
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
