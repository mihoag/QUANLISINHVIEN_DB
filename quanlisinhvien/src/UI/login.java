package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import JDBCconnection.SQLconnection;
import control.control_account;

public class login extends JFrame {

	public JTextField txt_username;
	public JTextField txt_pass;

	public login() {
		getContentPane().setBackground(new Color(240, 234, 185));
		this.setTitle("Login");
		this.setLocationRelativeTo(null);
		this.setSize(400, 400);
		///////////
		
		
		/////
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(149, 10, 124, 72);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblUsername.setBounds(10, 92, 98, 50);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblPassword.setBounds(10, 160, 98, 50);
		getContentPane().add(lblPassword);
		
		txt_username = new JTextField();
		txt_username.setBounds(120, 107, 240, 29);
		getContentPane().add(txt_username);
		txt_username.setColumns(10);
		txt_username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txt_pass = new JTextField();
		txt_pass.setColumns(10);
		txt_pass.setBounds(120, 169, 240, 29);
		getContentPane().add(txt_pass);
		txt_pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		JButton btn_login = new JButton("Login");
		btn_login.setBackground(new Color(162, 226, 82));
		btn_login.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_login.setBounds(56, 237, 124, 50);
		getContentPane().add(btn_login);
		btn_login.setOpaque(true);
		
		JButton btn_signup = new JButton("Sign up");
		btn_signup.setBackground(new Color(162, 226, 82));
		btn_signup.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_signup.setBounds(202, 237, 124, 50);
		getContentPane().add(btn_signup);
		btn_signup.setOpaque(true);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBackground(new Color(162, 226, 82));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnExit.setBounds(138, 297, 124, 50);
		getContentPane().add(btnExit);
		btnExit.setOpaque(true);
		
		//////////
		control_account ac = new control_account(this);
		btn_login.addActionListener(ac);
		btn_signup.addActionListener(ac);
		btnExit.addActionListener(ac);

		
		//////////////////
		this.setVisible(true);
	}
       public static void main(String[] args) {
		/*Connection c = SQLconnection.getConnection();
		if(c != null)
		{
			System.out.println("Dang nhap thah cong");
		}
		else {
			System.out.println("That bai");
		}*/
    	   
    	   new login();
	}
}
