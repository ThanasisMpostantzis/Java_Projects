import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ContainerFrame extends JFrame {
	
	private JPanel panel = new JPanel();
	private JPanel fieldPanel = new JPanel();
	private JTextField codeField, destinationField, weightField, powerField;
	private JButton createBulkButton, createRefrButton;
	private JList shipList;
	
	private ArrayList<Ship> ship;
	public ContainerFrame(ArrayList<Ship> ship1) {
		ship = ship1;
		panel.setLayout(new BorderLayout());
		fieldPanel.setLayout(new GridLayout(3,2));
		codeField = new JTextField("Code");
		destinationField = new JTextField("Destination");
		weightField = new JTextField("Weight");
		powerField = new JTextField("Power");
		createBulkButton = new JButton("Create Bulk");
		createRefrButton = new JButton("Create Refr");
		shipList = new JList();
		
		DefaultListModel<String> model = new DefaultListModel();
		
		for(Ship shi: ship)
			model.addElement(shi.getName());
		
		shipList.setModel(model);
		
		fieldPanel.add(codeField);
		fieldPanel.add(destinationField);
		fieldPanel.add(weightField);
		fieldPanel.add(powerField);
		fieldPanel.add(createBulkButton);
		fieldPanel.add(createRefrButton);
		
		panel.add(fieldPanel, BorderLayout.CENTER);
		panel.add(shipList, BorderLayout.SOUTH);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		createBulkButton.addActionListener(listener);
		createRefrButton.addActionListener(listener);
		
		this.setSize(400, 400);
		this.setVisible(true);
		this.setTitle("Charge Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{

		@SuppressWarnings("null")
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String code = null, destination = null;
			double weight, power;
			code = codeField.getText();
			destination = destinationField.getText(); 
			
			if(e.getSource().equals(createBulkButton)) {
				weight = Double.parseDouble(weightField.getText()); 
				Bulk b1 = new Bulk(destination, code, weight); 
				System.out.println("Bulk Charge: " + b1.calculateCharge() + " Ship:" + ship.get(shipList.getSelectedIndex()).getName());
				 
			}else {
				power = Double.parseDouble(powerField.getText());
				Refridgerator r1 = new Refridgerator(destination, code, power); 
				System.out.println("Refr Charge: " + r1.calculateCharge() + " Ship:" + ship.get(shipList.getSelectedIndex()).getName());
			}
			
		}
		
	}
}
