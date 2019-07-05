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

public class adminreg extends JFrame {

	private JPanel contentPane;
	private JTextField uname;
	private JPasswordField pass1;
	private JPasswordField pass2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminreg frame = new adminreg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
	public adminreg() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 695, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(291, 22, 108, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(76, 128, 141, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Create Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(76, 168, 149, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(76, 199, 149, 30);
		contentPane.add(lblNewLabel_3);
		
		uname = new JTextField();
		uname.setBounds(262, 137, 204, 19);
		contentPane.add(uname);
		uname.setColumns(10);
		
		pass1 = new JPasswordField();
		pass1.setBounds(262, 172, 204, 19);
		contentPane.add(pass1);
		
		pass2 = new JPasswordField();
		pass2.setBounds(262, 208, 204, 19);
		contentPane.add(pass2);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/polling","root", "karthik");
				String sql= "INSERT INTO adminlogin " +
		                   "VALUES ('"+uname.getText()+"','"+pass1.getText()+"')";
				PreparedStatement stmt=con.prepareStatement(sql);
				 String passwd=pass1.getText();
				 String passwd2=pass2.getText();
				 if(passwd.equals(passwd2))
				 {close();
				 stmt.executeUpdate(sql);
				  login lo=new login();
				  lo.setVisible(true);
				 }
				 else
					 JOptionPane.showMessageDialog(null,"Passwords do not match");
			
                con.close();
				
				
				}catch(Exception e)
				{
					System.out.print(e);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(232, 268, 85, 21);
		contentPane.add(btnNewButton);
	}

}
