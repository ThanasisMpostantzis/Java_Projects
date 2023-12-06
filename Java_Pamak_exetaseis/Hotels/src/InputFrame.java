import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InputFrame extends JFrame {
	
	private JPanel panel;
	private JPanel diamoniPanel;
	private JPanel allInclusivePanel;
	private JPanel buttonPanel;
	
	private JLabel diamoniLabel;
	private JLabel hotelLabel;
	private JLabel allInclusiveLabel;
	
	private JList listView;
	private DefaultListModel model;
	
	private JTextField daysField;
	private JTextField mealsField;
	
	private JButton storeButton;
	private JButton calculateCostButton;
	
	private JTextField costField;

	private ArrayList<Hotel> hotels = new ArrayList<>();
	
	public InputFrame(ArrayList<Hotel> hotels) {
		
		this.hotels = hotels;
		
	    try {
			FileInputStream in = new FileInputStream("hotels.ser");
			ObjectInputStream obIn = new ObjectInputStream(in);
			
			this.hotels = (ArrayList<Hotel>) obIn.readObject();
			
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
		
		panel = new JPanel();
		diamoniPanel = new JPanel();
		allInclusivePanel = new JPanel();
		buttonPanel = new JPanel();	
		
		listView = new JList();
		model = new DefaultListModel();
		
		Collections.sort(this.hotels);
		
		for(Hotel h: this.hotels) {
			model.addElement(h.getName());
		}
		
		/*
		 * model.addElement("Dummy Hotel Name 1");
		 * model.addElement("Dummy Hotel Name 2");
		 * model.addElement("Dummy Hotel Name 3");
		 * model.addElement("Dummy Hotel Name 4");
		 */
		
		listView.setModel(model);
		
		diamoniLabel = new JLabel("Stoixeia Diamonis");
		hotelLabel = new JLabel("Hotel");
		allInclusiveLabel = new JLabel("AllInclusive");
		
		daysField = new JTextField("Hmeres Diamonis");
		mealsField = new JTextField("Plithos Geumatwn (1,2,3)");
		costField = new JTextField("Synoliko Kostos");
		
		storeButton = new JButton("Apothikeusi Kratisis");
		calculateCostButton = new JButton("Ypologismos Kostous");
		
		diamoniPanel.setLayout(new BoxLayout(diamoniPanel, BoxLayout.Y_AXIS));
		diamoniLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		diamoniPanel.add(diamoniLabel);
		hotelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		diamoniPanel.add(hotelLabel);
		diamoniPanel.add(listView);
		diamoniPanel.add(daysField);
		diamoniPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		allInclusivePanel.setLayout(new GridLayout(2,0));
		allInclusivePanel.add(allInclusiveLabel);
		allInclusivePanel.add(mealsField);
		allInclusivePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		buttonPanel.setLayout(new GridLayout(2,0));
		buttonPanel.add(storeButton);
		buttonPanel.add(calculateCostButton);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		panel.add(diamoniPanel);
		panel.add(allInclusivePanel);
		panel.add(buttonPanel);
		panel.add(costField);
		
		ButtonListener listener = new ButtonListener();
		storeButton.addActionListener(listener);
		calculateCostButton.addActionListener(listener);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(200, 320);
		this.setLocation(200, 0);
		this.setTitle("Input");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String n;
			double sum = 0;
			int days, meals;
			Booking a1;
			if(e.getSource().equals(storeButton)) {
				n = (String) listView.getSelectedValue();
				
				days = Integer.parseInt(daysField.getText());
				meals = Integer.parseInt(mealsField.getText());
				for(Hotel h: hotels) {
					if(h.getName().equals(listView.getSelectedValue().toString())) {
						if(meals > 1) {
							a1 = new AllInclusive(meals, days);
							sum += a1.bookingCost();
							h.resAdd(a1);
							System.out.println("Your booking has been successfully stored to: " + n);

						}else {
							a1 = new Booking(days);
							sum += a1.bookingCost();
							h.resAdd(a1);
							System.out.println("Your booking has been successfully stored to: " + n);

						}
					}
				}
			}else {
				for(Hotel h: hotels) {
					if(listView.getSelectedValue().toString().equals(h.getName())) {
						sum = h.totalCost();
					}
				}
				
				costField.setText("" + sum);
			}
			}
		}
	}


