import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;


public class RegisterFrame extends JFrame {
	private JPanel panel;
	private JTextField firstNameField, lastNameField, emailField, usernameField, passwordField, confirmPasswordField;
	private JButton registerButton;
	private JCheckBox termsCheckBox;
	
	public RegisterFrame() {
		panel = new JPanel();
		
		firstNameField = new JTextField("First name");
		lastNameField = new JTextField("Last name");
		emailField = new JTextField("Email");
		usernameField = new JTextField("Username");
		passwordField = new JTextField("Password");
		confirmPasswordField = new JTextField("Confirm Password");
		termsCheckBox = new JCheckBox("I accept the Terms of Use & Privacy Policy");
		registerButton = new JButton("Register Now");
		
		//ActionListener for registerButton
		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				DataBase db = new DataBase();
			
				String firstName, lastName, email, username, password, confirmPassword;
				
				firstName = firstNameField.getText();
				lastName = lastNameField.getText();
				email = emailField.getText();
				username = usernameField.getText();
				password = passwordField.getText();
				confirmPassword = confirmPasswordField.getText();
				
				boolean usernameAlreadyExists = false;
				boolean emailAlreadyExists = false;
				
				for(UserAccount acc : db.getUserAccounts()) {
					if(username.equals(acc.getUsername())) {
						usernameAlreadyExists = true;
					}
					if(email.equals(acc.getEmail())) {
						emailAlreadyExists = true;
					}
				}
				if(termsCheckBox.isSelected()) {
					if(!usernameAlreadyExists && !emailAlreadyExists) {
						if(password.equals(confirmPassword)) {
							if(password.length() >= 8) {
								UserAccount acc = new UserAccount(firstName, lastName, email, username, password);
								db.addUserAccount(acc);
								
								new SignInFrame();
								dispose();
							}
							else new PasswordTooShortFrame();
						}
						else new WrongConfirmPasswordFrame();
					}
					else new PersonalDataAlreadyExistFrame();
				}
				else new AcceptTermsFrame();
			}
			
		});
		
		panel.add(firstNameField);
		panel.add(lastNameField);
		panel.add(emailField);
		panel.add(usernameField);
		panel.add(passwordField);
		panel.add(confirmPasswordField);
		panel.add(termsCheckBox);
		panel.add(registerButton);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Register Screen");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}

class WrongConfirmPasswordFrame extends JFrame {
	private JPanel panel;
	private JLabel label;
	private JButton okButton;
	
	public WrongConfirmPasswordFrame() {
		panel = new JPanel();
		label = new JLabel("Fields Password and Confirm Password don't match");
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
		this.setSize(350, 100);
		this.setTitle("Wrong Confirm Password Screen");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

class PasswordTooShortFrame extends JFrame {
	private JPanel panel;
	private JLabel firstLabel, secondLabel;
	private JButton okButton;
	
	public PasswordTooShortFrame() {
		panel = new JPanel();
		firstLabel = new JLabel("Password Too Short");
		secondLabel = new JLabel("Please enter a password at least 8 characters long");
		okButton = new JButton("ok");
		
		okButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		panel.add(firstLabel);
		panel.add(secondLabel);
		panel.add(okButton);
		
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setSize(350, 150);
		this.setTitle("Too Short Password Screen");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

class PersonalDataAlreadyExistFrame extends JFrame {
	private JPanel panel;
	private JLabel label;
	private JButton okButton;
	
	public PersonalDataAlreadyExistFrame() {
		panel = new JPanel();
		label = new JLabel("This Username/Email is already taken");
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
		this.setSize(300, 100);
		this.setTitle("Personal Data Already Exist Screen");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

class AcceptTermsFrame extends JFrame {
	private JPanel panel;
	private JLabel label;
	private JButton okButton;
	
	public AcceptTermsFrame() {
		panel = new JPanel();
		label = new JLabel("You need to accept the Terms of Use & Privacy Policy to register");
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
		this.setSize(400, 100);
		this.setTitle("Accept Terms Screen");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}