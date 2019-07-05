package miniproj;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class vote<usereg> extends JFrame {

	private JPanel contentPane;
	JComboBox comboBox;
	private JTable table;
	private JTextField textField;
	private JLabel lblVotId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {userreg us=new userreg();
				vote frame = new vote();
				     frame.textField.setText(us.sendinfo());
					
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
	}
	/**
	 * Create the frame.
	 */
	public vote() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1010, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vote");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(398, 48, 114, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelectElection = new JLabel("Select Election");
		lblSelectElection.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSelectElection.setBounds(157, 111, 176, 36);
		contentPane.add(lblSelectElection);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(314, 122, 225, 21);
		contentPane.add(comboBox);
		
		JButton btnSelect = new JButton("Select");
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
		btnSelect.setBounds(594, 122, 85, 21);
		contentPane.add(btnSelect);
		
		JButton btnVote = new JButton("Vote");
		btnVote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row=table.getSelectedRow();
				String vid=textField.getText();
				String cell1=table.getModel().getValueAt(row,0).toString();
				String cell2=table.getModel().getValueAt(row,1).toString();
				String cell3=table.getModel().getValueAt(row,3).toString();
				
				
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/polling","root", "karthik");
				String sql= "INSERT INTO voting " +
		                   "VALUES ('"+vid+"','"+cell1+"','"+cell2+"','"+cell3+"')";
				PreparedStatement stmt=con.prepareStatement(sql);
				 stmt.executeUpdate(sql);
				 JOptionPane.showMessageDialog(null,"Voted sucessfully");
				 close();
				 userreg fp=new userreg();
				 fp.setVisible(true);
				 
				 }catch(Exception e) {
				e.printStackTrace();
				
			}
			}
		});
		btnVote.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnVote.setBounds(427, 505, 85, 21);
		contentPane.add(btnVote);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 220, 715, 197);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		userreg u=new userreg();
		String str=u.vjid.getText();
		
		textField = new JTextField();
		textField.setBounds(157, 28, 186, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblVotId = new JLabel("Vot ID");
		lblVotId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVotId.setBounds(52, 28, 80, 13);
		contentPane.add(lblVotId);
		
	}

	
}
