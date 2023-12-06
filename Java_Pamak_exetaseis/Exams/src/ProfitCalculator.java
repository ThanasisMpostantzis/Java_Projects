import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfitCalculator extends JFrame {
	
	private JPanel panel = new JPanel();
	private JList<String> providersList = new JList<>();
	private DefaultListModel<String> providerModel = new DefaultListModel<>();
	
	private JButton profitButton = new JButton("Calculate Provider Profit");
	
	private JTextField profitTextField = new JTextField("calculated profit", 30);
	private ArrayList<Provider> providerss;
	
	public ProfitCalculator(ArrayList<Provider> providers) {
		providerss = providers;
		
		/*
		 * providerModel.addElement("Provider 1");
		 * providerModel.addElement("Provider 2");
		 * providerModel.addElement("Provider 3");
		 */
		providersList.setModel(providerModel);
			
		panel.add(providersList);
		panel.add(profitButton);
		panel.add(profitTextField);
		
		for(Provider p : providerss) {
			providerModel.addElement(p.getCoName());
		}
		
		providersList.setModel(providerModel);
		
		ButtonListener listener = new ButtonListener();
		profitButton.addActionListener(listener);
		
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Profit Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String providerName = providersList.getSelectedValue();
			String sum = null;
			for(Provider p : providerss) {
				if(providerName.equals(p.getCoName())) {
					sum = "Provider consumption " + p.getCoName() + ": " + p.calculateTotalNetEnergy();
				}
				
			}
			profitTextField.setText(sum);
		}
		
	}
	
}