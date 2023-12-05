import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.*;


public class SignInFrame extends JFrame {
	private JPanel panel;
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton signInButton;
	private JButton registerButton;
	
	public SignInFrame() {
		usernameField = new JTextField("username");
		passwordField = new JTextField("password");
		signInButton = new JButton("Sign In");
		registerButton = new JButton("Register");
		panel = new JPanel();
		
		//ActionListener for signInButton
				signInButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent ae) {
						DataBase db = new DataBase();
						
						String username, password;
						username = usernameField.getText();
						password = passwordField.getText();
						
						UserAccount account = null;
						
						boolean found = false;
						for(UserAccount acc : db.getUserAccounts()) {
							if(username.equals(acc.getUsername()) && password.equals(acc.getPassword())) {
								account = acc;
								found = true;
							}
						}
						if(!found) {
							new WrongUsernameOrPasswordFrame();
						}
						else {
							account.signedInAccountSerialization();
							new HomeFrame();
							dispose();
						}
					}
					
				});
		
		//Actionlistener for registerButton
		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterFrame();
				dispose();
				
			}
			
		});
		
		panel.add(usernameField);
		panel.add(passwordField);
		panel.add(signInButton);
		panel.add(registerButton);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Sign In Screen");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class WrongUsernameOrPasswordFrame extends JFrame {
	private JPanel panel;
	private JLabel label;
	private JButton okButton;
	
	public WrongUsernameOrPasswordFrame() {
		panel = new JPanel();
		label = new JLabel("Wrong Username or Password");
		okButton = new JButton("ok");
		
		okButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		panel.add(label);
		panel.add(okButton);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(200, 100);
		this.setTitle("Wrong Username or Password Screen");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
