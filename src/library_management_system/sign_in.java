package library_management_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.image.Image;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPasswordField;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class sign_in extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sign_in frame = new sign_in();
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
				    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
				    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
				    frame.setLocation(x, y);
					frame.setVisible(true);
					frame.setUndecorated(true);
					
					
				    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public sign_in() {
		 
		
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 484);
		contentPane = new JPanel();
		getRootPane().setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, new Color(18, 151, 248)));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(18, 151, 248));
		panel_1.setBounds(0, 0, 390, 489);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel image = new JLabel("");
		image.setBounds(66, -52, 1109, 399);
		image.setIcon(new ImageIcon("./assets/logo.png"));
		panel_1.add(image);
		
		JLabel library = new JLabel("Library Management");
		library.setHorizontalAlignment(SwingConstants.CENTER);
		library.setForeground(Color.WHITE);
		library.setFont(new Font("Motion Picture Personal Use ", Font.BOLD, 50));
		library.setBounds(0, 266, 380, 81);
		panel_1.add(library);
		JLabel system = new JLabel("System");
		system.setHorizontalAlignment(SwingConstants.CENTER);
		system.setForeground(Color.WHITE);
		system.setFont(new Font("Motion Picture Personal Use ", Font.BOLD, 50));
		system.setBounds(0, 305, 380, 100);
		panel_1.add(system);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 0, 0, 0);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(398, 167, 234, 41);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel email = new JLabel("E-mail");
		email.setMaximumSize(new Dimension(100, 14));
		email.setPreferredSize(new Dimension(50, 14));
		email.setBounds(398, 142, 75, 14);
		panel_2.add(email);
		
		JLabel password = new JLabel("Password");
		password.setPreferredSize(new Dimension(100, 14));
		password.setMaximumSize(new Dimension(100, 14));
		password.setBounds(398, 231, 100, 14);
		panel_2.add(password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(398, 256, 234, 41);
		panel_2.add(passwordField);
		
		JLabel close = new JLabel("X");
		close.setForeground(Color.RED);
		close.setFont(new Font("arial", Font.BOLD, 20));
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.setBounds(643, 0, 75, 41);
		panel_2.add(close);
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		
		JButton signin = new JButton("Sign In");
		signin.setDoubleBuffered(true);
		signin.setSelected(true);
		signin.setFocusTraversalKeysEnabled(false);
		signin.setBorderPainted(false);
		signin.setAutoscrolls(true);
		signin.setBackground(new Color(18, 151, 248));
		signin.setForeground(Color.WHITE);
		signin.setBounds(452, 321, 121, 28);
		panel_2.add(signin);
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
					java.sql.Statement stmt=con.createStatement();
					String sql="Select * from auth where email='"+textField.getText()+"' and password='"+passwordField.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						String stp=rs.getString("status");
						int id = rs.getInt("id");
						if(stp.equals("admin")) {
							admin_page admin = new admin_page();
							admin.main(null);
							dispose();
							
						}
						if(stp.equals("staff")) {
							staff_page staff = new staff_page();
							staff.get_id(id);
							staff.main(null);
							dispose();
							
						}
						if(stp.equals("user")) {
							JOptionPane.showMessageDialog(null, "You do not have permission to get in the management system!");
						}	
					con.close();
					}
					else
						JOptionPane.showMessageDialog(null, "Login Failed...");
				}catch(Exception e){
					System.out.print(e);
				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
