import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class taxiFrame extends JFrame{

	private JTextField textField;
	private JButton button1;
	private JButton button2;
	private JPanel panel;
	private ArrayList<Fleet> fleet;
	
	
	public taxiFrame(ArrayList<Fleet> fleet) {
	
		this.fleet = fleet;
		
		panel = new JPanel();
		textField = new JTextField(25);
		button1 = new JButton("Εμφάνιση Αυτονομίας");
		button2 = new JButton("Αποθήκευση σε Αρχείο");
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("Taxi Application");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.add(textField);
		panel.add(button1);
		panel.add(button2);
		
		
		ButtonListener listener = new ButtonListener();
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		
		this.setContentPane(panel);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = null;
			double consSum = 0;
		    int plithos = 0;
		    String cityName = null;
			if(e.getSource().equals(button1)) {
				cityName = textField.getText();
				
				for(Fleet f: fleet) {
					plithos = f.getTaxies().size();
					for(Taxi t: f.getTaxies())
						consSum += f.totalTaxiCalc();
					if(cityName.equals(f.getName())) {
						name = f.getName();
					}
				}
						
				
				System.out.println("Name: " + cityName);
				System.out.println("Plithos taxi: " + plithos);
				System.out.println("Synoliki autonomia stolou taxi: " + consSum);
				
			}else {
				try {
					File file = new File("ics21055.txt");
					//ELEGXOS AN DHMIOURGHTHIKE TWRA H AN YPHRXE TO ARXEIO
					if (file.createNewFile()) {
				        System.out.println("File created: " + file.getName());
				      } else {
				        System.out.println("File already exists.");
				      }
					BufferedWriter writer = new BufferedWriter(new FileWriter(file));
					
					writer.write("Fleet's name: " + textField.getText());
					writer.newLine();
					String dName = null;
					String dPlate = null;
					double dCons = 0;
					for(Fleet f: fleet)
						for(Taxi t: f.getTaxies()) {
							dName = t.driversName();
							dPlate = t.driversPlate();
							dCons = t.consumptionCalc();
							consSum += t.consumptionCalc();
							writer.write("Drivers name: " + dName + " -Drivers Plate: " + dPlate + " -Drivers Consumption: " + dCons);
							writer.newLine();
						}
						writer.newLine();
						writer.write("Total consumption: " + consSum);
						System.out.println("Donee");
						writer.close();
						//writer.write("Drivers name: " + dName + "Drivers Plate: " + dPlate + "Drivers Consumption: " + dCons);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
				
			}
			
		}
	}
