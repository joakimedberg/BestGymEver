package nackademin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI to manage customers and their activity at BestGymEver.
 * @author Joakim Edberg
 *
 */
public class GraphicalUserInterface {
	static Customer customer;
	static CustomerDatabase cd = new CustomerDatabase();
	static CustomerActivityDatabase cad = new CustomerActivityDatabase();
	
	// path to file containing customers
	final static String path = "customers.txt";

	public static void main(String[] args) {
		
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

		try {
			
			List<Customer> customers = cd.getCustomers(path);

			// search function
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					/* TODO 
					 * Either dismiss personIDs with other characters, eg. 123456-1234
					 * or convert to only numbers.
					 * Reconstruct string if there's multiply space between names.
					 */
					String searchValue = search.getText().trim();

					for (Customer c : customers) {
						if (c.getName().equalsIgnoreCase(searchValue)
								|| c.getpersonID().equalsIgnoreCase(searchValue)) {
							if (c.hasActiveMembership()) {
								result.setText("Aktiv"); // active membership
								enter.setVisible(true);
								customer = c;

							} else {
								result.setText("Inaktiv"); // non active membership
							}
							break;
						}
						result.setText("Ej kund"); // not customer
					}
				}
			});

			// add activity
			enter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cad.addActivity(customer, LocalDate.now());
					enter.setVisible(false);
					search.setText(null);
					result.setText(null);

				}
			});

		} catch (FileNotFoundException e) {
			result.setText("Hittar inte fil.");
			e.printStackTrace();
		} catch (Exception e2) {
			result.setText("Felaktig kunddata i fil.");
			e2.printStackTrace();
		}

	}

}
