package miniproj;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;

public class candsel extends JFrame {

	private JPanel contentPane;
	private JTextField cid;
	private JTextField vid;
	private JTextField cname;
	private JTextField party;
	JLabel lblNewLabel_2;
	private JTextField age;
	private JTextField eid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					candsel frame = new candsel();
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
	 public ImageIcon ResizeImage(String ImagePath)
	    {
	        ImageIcon MyImage = new ImageIcon(ImagePath);
	        Image img = MyImage.getImage();
	        Image newImg = img.getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(newImg);
	        return image;
	    }
	 

	/**
	 * Create the frame.
	 */
	public candsel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 874, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Candidate details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(213, 21, 247, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblCandidateId = new JLabel("Candidate ID");
		lblCandidateId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCandidateId.setBounds(52, 133, 134, 25);
		contentPane.add(lblCandidateId);
		
		cid = new JTextField();
		cid.setBounds(230, 139, 163, 19);
		contentPane.add(cid);
		cid.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(52, 120, 45, 13);
		contentPane.add(label);
		
		JLabel lblVoterId = new JLabel("Voter ID");
		lblVoterId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVoterId.setBounds(53, 175, 134, 25);
		contentPane.add(lblVoterId);
		
		vid = new JTextField();
		vid.setBounds(230, 181, 163, 19);
		contentPane.add(vid);
		vid.setColumns(10);
		
		JLabel lblCandidateName = new JLabel("Candidate name");
		lblCandidateName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCandidateName.setBounds(53, 218, 134, 25);
		contentPane.add(lblCandidateName);
		
		cname = new JTextField();
		cname.setBounds(230, 224, 163, 19);
		contentPane.add(cname);
		cname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Party");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(53, 259, 120, 31);
		contentPane.add(lblNewLabel_1);
		
		party = new JTextField();
		party.setBounds(230, 268, 163, 19);
		contentPane.add(party);
		party.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Photo");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblNewLabel_2.setBounds(580, 190, 122, 139);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Browse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser ch=new JFileChooser();
				ch.showOpenDialog(null);
				File f=ch.getSelectedFile();
				String filname=f.getAbsolutePath();
				ImageIcon ii=new ImageIcon((filname));
				candsel cl=new candsel();
				ImageIcon i1=cl.ResizeImage(filname);
				lblNewLabel_2.setIcon((i1));
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(584, 345, 103, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAge.setBounds(53, 314, 120, 31);
		contentPane.add(lblAge);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(230, 323, 163, 19);
		contentPane.add(age);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGender.setBounds(53, 366, 120, 31);
		contentPane.add(lblGender);
		
		JComboBox gender = new JComboBox();
		gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		gender.setModel(new DefaultComboBoxModel(new String[] {"m", "f"}));
		gender.setBounds(230, 371, 134, 21);
		contentPane.add(gender);
		newelection nl=new newelection();
		
		JLabel lblEleId = new JLabel("Ele ID");
		lblEleId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEleId.setBounds(465, 31, 56, 13);
		contentPane.add(lblEleId);
		
		eid = new JTextField();
		eid.setBounds(523, 28, 179, 19);
		contentPane.add(eid);
		eid.setColumns(10);
		
		JButton btnAddMoreCandidates = new JButton("Add more candidates");
		btnAddMoreCandidates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/polling","root", "karthik");
				String sql= "INSERT INTO candidate " +
		                   "VALUES ('"+eid.getText()+"','"+cid.getText()+"','"+vid.getText()+"','"+cname.getText()+"','"+party.getText()+"','"+age.getText()+"','"+gender.getSelectedItem()+"')";
				PreparedStatement stmt=con.prepareStatement(sql);
				 String s1=eid.getText();
				 String s2=cid.getText();
				 String s3=vid.getText();
				 String s4=cname.getText();
				 String s5=party.getText();
				 String s6=age.getText();
				 String s7=gender.getSelectedItem().toString();
				 if(s1.isEmpty()==false && s2.isEmpty()==false&&s3.isEmpty()==false&&s4.isEmpty()==false&&s5.isEmpty()==false&&s6.isEmpty()==false&&s7.isEmpty()==false)
				 { close();
				  stmt.executeUpdate(sql);
				  candsel c1=new candsel();
				  c1.setVisible(true);
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
		btnAddMoreCandidates.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddMoreCandidates.setBounds(499, 466, 203, 21);
		contentPane.add(btnAddMoreCandidates);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/polling","root", "karthik");
				String sql= "INSERT INTO candidate " +
		                   "VALUES ('"+eid.getText()+"','"+cid.getText()+"','"+vid.getText()+"','"+cname.getText()+"','"+party.getText()+"','"+age.getText()+"','"+gender.getSelectedItem()+"')";
				PreparedStatement stmt=con.prepareStatement(sql);
				 String s1=eid.getText();
				 String s2=cid.getText();
				 String s3=vid.getText();
				 String s4=cname.getText();
				 String s5=party.getText();
				 String s6=age.getText();
				 String s7=gender.getSelectedItem().toString();
				 if(s1.isEmpty()==false && s2.isEmpty()==false&&s3.isEmpty()==false&&s4.isEmpty()==false&&s5.isEmpty()==false&&s6.isEmpty()==false&&s7.isEmpty()==false)
				 { 
				  stmt.executeUpdate(sql);
				  JOptionPane.showMessageDialog(null, "You have sucessfully entered the details");
				  close();
					adminnext ad=new adminnext();
					ad.setVisible(true);
		
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
		btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFinish.setBounds(720, 466, 103, 21);
		contentPane.add(btnFinish);
		
		JLabel lblNewLabel_3 = new JLabel("Please Enter the Candidate details");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(52, 71, 650, 39);
		contentPane.add(lblNewLabel_3);
		
		
	}
}
