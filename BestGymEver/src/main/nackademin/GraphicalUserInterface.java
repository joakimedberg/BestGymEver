package nackademin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class GraphicalUserInterface {
	
	public static void main(String [] args) {	
		GraphicalUserInterface gui = new GraphicalUserInterface();
		gui.initGUI();
	
	}
	
	private CustomerDatabase cd;
	private Customer customer;
	private CustomerActivityDatabase cad;
	
	private void initGUI () {
		String path = "customers";
		cd = new CustomerDatabase(path);
				
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		

		JTextField search = new JTextField(10);
		JButton button = new JButton("SÖK");
		JButton enter = new JButton("->");
		JLabel result = new JLabel();

		panel.add(new JLabel("Namn eller personnr: "));
		panel.add(search);
		panel.add(button);
		panel.add(result);
		panel.add(enter);

		frame.add(panel);
		frame.setSize(300, 100);
		
		enter.setVisible(false);
		frame.setVisible(true);

		// search function
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<Customer> customers = cd.getCustomers();
				String searchValue = search.getText();
						
				for (Customer c : customers) {
					if (c.getName().equalsIgnoreCase(searchValue) || c.getpersonID().equalsIgnoreCase(searchValue)) {				
						if (c.hasActiveMembership()) {
							result.setText("Aktiv"); // active membership
							enter.setVisible(true);
							customer = c;
							
						} else {
							result.setText("Inaktiv"); // non active membership
						}
						break;
					}
					result.setText("Ej kund");		 // not customer
				}
			}
		});	
		
		// add activity 
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cad = new CustomerActivityDatabase(customer);
				cad.writeData(LocalDate.now());
				enter.setVisible(false);
				
			}
		});
	}
	
	
	

}
