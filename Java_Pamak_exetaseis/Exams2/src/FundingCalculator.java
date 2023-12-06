import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;

public class FundingCalculator extends JFrame {
	
	private JPanel panel = new JPanel();
	private JList<String> citiesList = new JList<>();
	private DefaultListModel<String> citiesModel = new DefaultListModel<>();
	
	private JButton cityFundingButton = new JButton("Calculate City Funding");
	
	private JTextField fundingTextField = new JTextField("calculated funding");
	ArrayList<City> cities;
	
	public FundingCalculator() {
		File file = new File("Cities.ser");
		
		try {
			FileInputStream in = new FileInputStream(file);
			ObjectInputStream obIn = new ObjectInputStream(in);
			
			cities = (ArrayList<City>) obIn.readObject();
			
			obIn.close();
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(City c: cities) {
			citiesModel.addElement(c.getEdra());
		}
		
		
		/*
		 * citiesModel.addElement("City 1"); citiesModel.addElement("City 2");
		 * citiesModel.addElement("City 3"); citiesModel.addElement("City 4");
		 */
		citiesList.setModel(citiesModel);
			
		panel.add(citiesList);
		panel.add(cityFundingButton);
		panel.add(fundingTextField);
		
		ButtonListener listener = new ButtonListener();
		cityFundingButton.addActionListener(listener);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Funding Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(cityFundingButton)) {
				
				int city= citiesList.getSelectedIndex();
				
				City name = cities.get(city);
				
				String adf ="" + name.calculateFunding();
				fundingTextField.setText(adf);
				
			}
			
		}
		
		
	}
	
}
