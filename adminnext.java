package miniproj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class adminnext extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminnext frame = new adminnext();
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
	public adminnext() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1077, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOnlinePollingSystemadmin = new JLabel("ONLINE POLLING SYSTEM-ADMIN ENTRY");
		lblOnlinePollingSystemadmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOnlinePollingSystemadmin.setBounds(253, 20, 441, 36);
		contentPane.add(lblOnlinePollingSystemadmin);
		
		JButton btnNewButton = new JButton("New election");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			newelection nl=new newelection();
			nl.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(57, 172, 170, 21);
		contentPane.add(btnNewButton);
		
		JButton btnViewElection = new JButton("View Election");
		btnViewElection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				close();
				viewelection vi=new viewelection();
				vi.Fillcombo();
				vi.setVisible(true);
			}
		});
		btnViewElection.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnViewElection.setBounds(266, 172, 170, 21);
		contentPane.add(btnViewElection);
		
		JButton btnViewscheduleResults = new JButton("View Results");
		btnViewscheduleResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				viewres vr=new viewres();
				vr.setVisible(true);
			}
			
		});
		btnViewscheduleResults.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnViewscheduleResults.setBounds(494, 172, 214, 21);
		contentPane.add(btnViewscheduleResults);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				firstpage fp=new firstpage();
				fp.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogout.setBounds(431, 275, 170, 36);
		contentPane.add(btnLogout);
		
		JButton btnEndElection = new JButton("End election");
		btnEndElection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				endelection e=new endelection();
				e.Fillcombo();
				e.setVisible(true);
				
			}
		});
		btnEndElection.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEndElection.setBounds(774, 172, 137, 21);
		contentPane.add(btnEndElection);
	}
}
