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
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class userreg extends JFrame {

	private JPanel contentPane;
	public static JTextField vjid;
	private JTextField fname;
	private JTextField lname;
	private JTextField age;
	public String str;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userreg frame = new userreg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public String sendinfo() {
	 String s=vjid.getText();
	 return s;
	}
	public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
	/**
	 * Create the frame.
	 */
	public userreg() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 861, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(306, 27, 251, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblVoterid = new JLabel("VoterID");
		lblVoterid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVoterid.setBounds(101, 163, 124, 30);
		contentPane.add(lblVoterid);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFirstName.setBounds(101, 213, 90, 25);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLastName.setBounds(101, 265, 90, 25);
		contentPane.add(lblLastName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAge.setBounds(101, 312, 77, 25);
		contentPane.add(lblAge);
		
		JLabel lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBirthDate.setBounds(101, 364, 90, 25);
		contentPane.add(lblBirthDate);
		
		JLabel lblConstituency = new JLabel("Constituency");
		lblConstituency.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConstituency.setBounds(101, 411, 107, 25);
		contentPane.add(lblConstituency);
		
		vjid = new JTextField();
		vjid.setBounds(235, 172, 238, 19);
		contentPane.add(vjid);
		vjid.setColumns(10);
		
		fname = new JTextField();
		fname.setBounds(235, 219, 238, 19);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(235, 271, 238, 19);
		contentPane.add(lname);
		lname.setColumns(10);
		
		age = new JTextField();
		age.setBounds(235, 318, 238, 19);
		contentPane.add(age);
		age.setColumns(10);
		
		JDateChooser bday = new JDateChooser();
		bday.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bday.setBounds(235, 364, 238, 19);
		contentPane.add(bday);
		bday.setDateFormatString("yyyy-MM-dd");
		
		JComboBox cons = new JComboBox();
		cons.setModel(new DefaultComboBoxModel(new String[] {"rrnagar", "basvangudi", "Nanjangud", "Hunsur"}));
		cons.setBounds(235, 411, 238, 22);
		contentPane.add(cons);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/polling","root", "karthik");
				//Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=rootpassword");
				Statement stmt2=con.createStatement();
				String sql1="Select * from voting where vid='"+vjid.getText()+"'";
				ResultSet rs1=stmt2.executeQuery(sql1);
				if(rs1.next())
            	{JOptionPane.showMessageDialog(null,"You have already voted");
            	userreg u=new userreg();
            	u.setVisible(false);
            	close();
            	u.setVisible(true);
            	}
				else
				{
				try {
				Statement stmt=con.createStatement();
				String sql="Select * from voter where vid='"+vjid.getText()+"'and votname='"+fname.getText()+"'and vage='"+age.getText()+"'and constituency= '"+cons.getSelectedItem()+"'";
                ResultSet rs=stmt.executeQuery(sql)	;
                   
                    if(rs.next())
                   {
                	   close();
                   	voternext vn=new voternext();
                   	vn.setVisible(true);
                   }
                   else
                	   JOptionPane.showMessageDialog(null,"You have entered wrong details");
             
                
                con.close();
				
				
				}catch(Exception e)
				{
					System.out.print(e);
				}
			}}catch(Exception e) {
				e.printStackTrace();
			}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegister.setBounds(556, 500, 107, 21);
		contentPane.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				firstpage fp=new firstpage();
				fp.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(712, 500, 85, 21);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("Please register to vote");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(101, 88, 527, 30);
		contentPane.add(lblNewLabel_1);
	}
}
