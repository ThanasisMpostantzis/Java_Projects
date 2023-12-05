import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.*;

public class HomeFrame extends JFrame {
	private UserAccount signedInAccount;
	private JPanel panel, userPanel, actionsPanel, recyclePanel;
	private JLabel usernameLabel, tokensLabel, recycleLabel;
	private JButton useButton, stakeButton, borrowButton, lendButton, donateButton, statisticsButton, logoutButton;
	private JButton infoButton, plasticButton, paperButton, glassButton, metalButton, organicButton;
	
	public HomeFrame () {
		DataBase db = new DataBase();
		//deserialization of signed in account
		try {
			FileInputStream fileIn = new FileInputStream("signedInAccount.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			signedInAccount = (UserAccount) in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("signedInAccount.ser File Not Found HomeFrame signed in account deserialization");
		} catch (IOException e) {
			System.out.println("signedInAccount.ser IO Exception HomeFrame signed in account deserialization");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}
		
		
		panel = new JPanel();
		
		//userPanel
		userPanel = new JPanel();
		
		usernameLabel = new JLabel("User: " + signedInAccount.getUsername());
		tokensLabel = new JLabel("Tokens: " + Integer.toString(signedInAccount.getTokens()));
		logoutButton = new JButton("Logout");
		
		//ActionListener for logoutButton
		logoutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				db.saveSignedInAccount(signedInAccount);
				dispose();
				new SignInFrame();
			}
		});
		
		userPanel.add(usernameLabel);
		userPanel.add(tokensLabel);
		userPanel.add(logoutButton);
		
		
		//recyclePanel
		recyclePanel = new JPanel();
		
		recycleLabel = new JLabel("Recycle");
		plasticButton = new JButton("Plastic");
		paperButton = new JButton("Paper");
		glassButton = new JButton("Glass");
		metalButton = new JButton("Metal");
		organicButton = new JButton("Organic");
		
		plasticButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String materialName = "Plastic";
				Material m = db.getSpecificMaterial(materialName);
				new FirstRecycleFrame(m);
				dispose();
			}
			
		});
		
		paperButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String materialName = "Paper";
				Material m = db.getSpecificMaterial(materialName);
				new FirstRecycleFrame(m);
				dispose();
			}
			
		});
		
		glassButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String materialName = "Glass";
				Material m = db.getSpecificMaterial(materialName);
				new FirstRecycleFrame(m);
				dispose();
			}
			
		});
		
		metalButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String materialName = "Metal";
				Material m = db.getSpecificMaterial(materialName);
				new FirstRecycleFrame(m);
				dispose();
			}
			
		});
		
		organicButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String materialName = "Organic";
				Material m = db.getSpecificMaterial(materialName);
				new FirstRecycleFrame(m);
				dispose();
			}
			
		});
		
		
		recyclePanel.add(recycleLabel);
		recyclePanel.add(plasticButton);
		recyclePanel.add(paperButton);
		recyclePanel.add(glassButton);
		recyclePanel.add(metalButton);
		recyclePanel.add(organicButton);
		
		panel.add(userPanel);
		panel.add(recyclePanel);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(700, 400);
		this.setTitle("Home Screen");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class FirstRecycleFrame extends JFrame {
	private UserAccount signedInAccount;
	private JPanel panel;
	private JLabel recycleLabel, firstLabel, secondLabel;
	private JButton recycleButton, homeButton;
	
	public FirstRecycleFrame(Material m) {
		//deserialization of signed in account
		try {
			FileInputStream fileIn = new FileInputStream("signedInAccount.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			signedInAccount = (UserAccount) in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("signedInAccount.ser File Not Found FirstRecycleFrame signed in account deserialization");
		} catch (IOException e) {
			System.out.println("signedInAccount.ser IO Exception FirstRecycleFrame signed in account deserialization");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}
		
		panel = new JPanel();
		homeButton = new JButton("Back");
		recycleLabel = new JLabel("Recycle");
		firstLabel = new JLabel("You chose to recycle " + m.getName().toLowerCase() + "!");
		secondLabel = new JLabel("Please insert " + m.getName().toLowerCase() + " materials to the gap.");
		recycleButton = new JButton("RECYCLE NOW");
		
		homeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new HomeFrame();
				dispose();
			}
		});
		
		recycleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				signedInAccount.recycleMaterial(m);
				new SecondRecycleFrame(m);
				dispose();
			}
			
		});
		
		panel.add(homeButton);
		panel.add(recycleLabel);
		panel.add(firstLabel);
		panel.add(secondLabel);
		panel.add(recycleButton);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(300, 300);
		this.setTitle("First Recycle Screen");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

class SecondRecycleFrame extends JFrame {
	private JPanel panel;
	private JLabel recycleLabel, firstLabel, secondLabel;
	private JButton homeButton;
	
	public SecondRecycleFrame(Material m) {		
		panel = new JPanel();
		homeButton = new JButton("Back");
		recycleLabel = new JLabel("Recycle");
		firstLabel = new JLabel("Materials accepted.");
		secondLabel = new JLabel("Congratulations you earn " +m.getReward() + " tokens!");
		
		homeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new HomeFrame();
				dispose();
			}
		});
		
		panel.add(homeButton);
		panel.add(recycleLabel);
		panel.add(firstLabel);
		panel.add(secondLabel);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(300, 300);
		this.setTitle("Second Recycle Screen");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

