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

public class viewres extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewres frame = new viewres();
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
	public viewres() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 863, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClickHereFor = new JButton("Click here for results");
		btnClickHereFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/polling","root", "karthik");
			CallableStatement stmt=con.prepareCall("{call result()}");
			Boolean b=stmt.execute();
			ResultSet rs;
			if(b) {
             rs=stmt.getResultSet();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            String ch=table.getValueAt(0,3).toString();
            String ch1=table.getValueAt(1,3).toString();
            String nam=table.getValueAt(0,2).toString();
            String nam1=table.getValueAt(1,2).toString();
            int check=Integer.parseInt(ch);
            int check1=Integer.parseInt(ch1);
            int max1=Math.max(check,check1);
            if(check==check1)
            {
            	JOptionPane.showMessageDialog(null,"It is a tie");
            	close();
            }
            else if(check==max1)
            {
            	JOptionPane.showMessageDialog(null,"The winner of the election is "+nam +"");
            	close();
            }
            else
            {
            	JOptionPane.showMessageDialog(null,"The winner of the election is "+nam1 +"");
            	close();
            }
            }
			}catch(Exception e) {
            	e.printStackTrace();
            }
			}
		});
		btnClickHereFor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClickHereFor.setBounds(337, 123, 171, 21);
		contentPane.add(btnClickHereFor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 190, 738, 297);
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
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(418, 530, 85, 21);
		contentPane.add(btnBack);
	}
}
