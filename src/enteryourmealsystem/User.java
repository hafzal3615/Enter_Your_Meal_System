package enteryourmealsystem;

import javax.swing.*;

public abstract class User {
	private String username;
	private String firstname;
	private String lastname;
	private String emailaddress;
	private JPasswordField password;
	public User(String username, String firstname, String lastname, String emailaddress, JPasswordField password ) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.emailaddress = emailaddress;
	}
		

}
