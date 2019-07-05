package miniproj;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class viewelection extends JFrame {

	private JPanel contentPane;
	JComboBox comboBox;
	private JButton btnSelect;
	private JTable table;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					viewelection frame = new viewelection();
					frame.Fillcombo();
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
public void Fillcombo() {
	try {Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/polling","root", "karthik");
		String sql="Select * from election";
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			String name=rs.getString("ename");
			comboBox.addItem(name);
		}
		
		
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null,e);
}
}/**
	 * Create the frame.
	 */
	public viewelection() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1177, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Election");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(273, 28, 257, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelectElection = new JLabel("Select election");
		lblSelectElection.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSelectElection.setBounds(115, 132, 158, 21);
		contentPane.add(lblSelectElection);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(273, 135, 187, 21);
		contentPane.add(comboBox);
		
		btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/polling","root", "karthik");
				String sql="Select * from candidate where ceid in(Select eid from election where ename='"+comboBox.getSelectedItem()+"')";
				PreparedStatement stmt=con.prepareStatement(sql);
                ResultSet rs=stmt.executeQuery(sql);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch(Exception e) {
                	e.printStackTrace();
                }
			}
		});
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSelect.setBounds(333, 181, 85, 21);
		contentPane.add(btnSelect);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 260, 932, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				adminnext ad=new adminnext();
				ad.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBack.setBounds(770, 543, 85, 21);
		contentPane.add(btnBack);
	}
}
