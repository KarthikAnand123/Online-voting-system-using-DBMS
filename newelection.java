package miniproj;

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
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class newelection extends JFrame {

	private JPanel contentPane;
	private JTextField eid;
	private JTextField ename;
	private JTextField datee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newelection frame = new newelection();
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
	public newelection() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 717, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Election ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(279, 28, 176, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblElectionId = new JLabel("Election ID");
		lblElectionId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblElectionId.setBounds(89, 98, 105, 13);
		contentPane.add(lblElectionId);
		
		eid = new JTextField();
		eid.setBounds(215, 98, 184, 19);
		contentPane.add(eid);
		eid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(88, 136, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		ename = new JTextField();
		ename.setBounds(215, 136, 184, 19);
		contentPane.add(ename);
		ename.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDate.setBounds(88, 174, 58, 13);
		contentPane.add(lblDate);
		
		JButton btnAddCandidates = new JButton("Next");
		btnAddCandidates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/polling","root", "karthik");
				String sql= "INSERT INTO election " +
		                   "VALUES ('"+eid.getText()+"','"+ename.getText()+"','"+datee.getText()+"')";
				PreparedStatement stmt=con.prepareStatement(sql);
				 String passwd=eid.getText();
				 String passwd2=ename.getText();
				 String s1=datee.getText();
				 
				 if(s1.isEmpty()==false && passwd.isEmpty()==false && passwd2.isEmpty()==false)
				 { close();
				  stmt.executeUpdate(sql);
				  candsel cs=new candsel();
				  cs.setVisible(true);
				 }
				 else 
					 {JOptionPane.showMessageDialog(null,"Fill all fields");}
			
                con.close();
				
				
				}catch(Exception e)
				{
					System.out.print(e);
				}
			}
		});
		btnAddCandidates.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddCandidates.setBounds(279, 226, 166, 21);
		contentPane.add(btnAddCandidates);
		
		datee = new JTextField();
		datee.setBounds(215, 174, 184, 19);
		contentPane.add(datee);
		datee.setColumns(10);
	}
}
