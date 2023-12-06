import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.*;

public class GUI extends JFrame{

	private JPanel panel = new JPanel();
	private JButton button = new JButton("Calculate Charge");
	
	private Ship ship;
	
	public GUI(Ship s1) {
		
		ship = s1;
		
		panel.add(button);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		
		this.setSize(400, 400);
		this.setVisible(true);
		this.setTitle("Charge Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			double total = ship.calculateTotalCharge();
			System.out.println("Total charge: "+ total);
			
		}
		
	}
}
