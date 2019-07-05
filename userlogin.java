package miniproj;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class userlogin extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JPasswordField pass1;
	private JPasswordField pass2;
	private JTextField age;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userlogin frame = new userlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
	/**
	 * Create the frame.
	 */
	public userlogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 624, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUserLogin.setBounds(155, 25, 138, 28);
		contentPane.add(lblUserLogin);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFirstName.setBounds(29, 92, 95, 21);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLastName.setBounds(29, 144, 95, 13);
		contentPane.add(lblLastName);
		
		JLabel lblCreatePassword = new JLabel("Create password");
		lblCreatePassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCreatePassword.setBounds(29, 222, 125, 36);
		contentPane.add(lblCreatePassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConfirmPassword.setBounds(29, 280, 145, 28);
		contentPane.add(lblConfirmPassword);
		
		fname = new JTextField();
		fname.setBounds(182, 96, 165, 19);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(182, 144, 165, 19);
		contentPane.add(lname);
		lname.setColumns(10);
		
		pass1 = new JPasswordField();
		pass1.setBounds(182, 234, 165, 19);
		contentPane.add(pass1);
		
		pass2 = new JPasswordField();
		pass2.setBounds(184, 288, 163, 19);
		contentPane.add(pass2);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s3=age.getText();
				 int s=Integer.parseInt(s3);
				if(s<18)
				 {
					 JOptionPane.showMessageDialog(null,"Your age must be 18 or more");
					 
					 
				 }
				else
				{
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/polling","root", "karthik");
				String sql= "INSERT INTO userlogin " +
		                   "VALUES ('"+fname.getText()+"','"+lname.getText()+"','"+age.getText()+"','"+pass1.getText()+"','"+pass2.getText()+"')";
				PreparedStatement stmt=con.prepareStatement(sql);
				 String passwd=pass1.getText();
				 String passwd2=pass2.getText();
				 String s1=fname.getText();
				 String s2=lname.getText();
				
				if(passwd.equals(passwd2) && s1.isEmpty()==false && s2.isEmpty()==false)
				 { close();
				  stmt.executeUpdate(sql);
				  userreg ur=new userreg();
				  ur.setVisible(true);
				 }
				 else 
					 {JOptionPane.showMessageDialog(null,"Passwords do not match/Fill all fields");}
			
                con.close();
				
				
				}catch(Exception e)
				{
					System.out.print(e);
				}
			}
			}});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.setBounds(208, 340, 85, 21);
		contentPane.add(btnLogin);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAge.setBounds(29, 178, 66, 28);
		contentPane.add(lblAge);
		
		age = new JTextField();
		age.setBounds(182, 186, 165, 19);
		contentPane.add(age);
		age.setColumns(10);
	}

}
