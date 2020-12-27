package library_management_system;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.EmptyStackException;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JCalendar;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class staff_page extends JFrame {
	private JPanel contentPane;
	private JTextField user_name;
	private JTextField user_surname;
	private JTextField user_mail;
	private JTextField user_phone_number;
	private JPasswordField user_password;
	private String user_b_day;
	private JTextField user_student_id;
	private JTable table;
	private JTextField delete_user_id;
	public static int current_id;
	private JTextField staff_name;
	private JTextField staff_surname;
	private JTextField staff_mail;
	private JPasswordField staff_password;
	private JTextField staff_phone;
	private JTextField staff_b_day;
	private JTextField delete_staff_id;
	private JTextField book_name;
	private JTextField book_author;
	private JTextField book_edition;
	private JTextField book_genre;
	private JTextField book_isbn;
	private JTextField delete_book_id;
	private JTextField issue_student_id;
	private JTextField issue_isbn;
	private JTextField delete_issue_id;
	private JTable users_table;
	private static JTable book_table;
	private JTable user_table;
	private JTable staff_table;
	private JTable issues_table;
	private JTable expired_table;
	
	/**	
	 * Launch the application.
	 */
	public void get_id(int id) {
		current_id = id;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					staff_page frame = new staff_page();
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
				    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
				    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
				    frame.setLocation(x, y);
					frame.setVisible(true);
					frame.setUndecorated(true);
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
	public staff_page() {
		Connection con;
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 584);
		contentPane = new JPanel();
		getRootPane().setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, new Color(18, 151, 248)));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setPreferredSize(new Dimension(700, 30));
		panel.setBackground(new Color(18, 151, 248));
		panel.setBackground(new Color(18, 151, 248));
		
		JLabel lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setPreferredSize(new Dimension(660, 20));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		
		JLabel close = new JLabel("X");
		close.setPreferredSize(new Dimension(21,21));
		close.setVerticalAlignment(SwingConstants.TOP);
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.setForeground(Color.WHITE);
		close.setBackground(Color.red);
		close.setOpaque(true);
		close.setFont(new Font("Arial", Font.BOLD, 20));
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		panel.add(close);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		//tab head here
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setPreferredSize(new Dimension(700, 560));
		
		//users tab starts here
		JPanel users = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) users.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		JPanel show_users = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) show_users.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		show_users.setPreferredSize(new Dimension(490,600));
		users.add(show_users);
		
		

		ResultSet user_rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
			java.sql.Statement stmt=con.createStatement();
			String user_sql="SELECT `name`, `surname`, `student_id`, `department`, `b_day`,`phone` FROM `user`";
			user_rs=stmt.executeQuery(user_sql);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		show_users.add(scrollPane_1);
		
		JTable user_table = new JTable();
		user_table.setPreferredSize(new Dimension(500,600));
		scrollPane_1.setViewportView(user_table);
		scrollPane_1.setViewportBorder(null);
		user_table.setModel(DbUtils.resultSetToTableModel(user_rs));
		user_table.getColumnModel().getColumn(0).setHeaderValue("Name");
		user_table.getColumnModel().getColumn(1).setHeaderValue("Surname");
		user_table.getColumnModel().getColumn(2).setHeaderValue("Student ID");
		user_table.getColumnModel().getColumn(3).setHeaderValue("Department");
		user_table.getColumnModel().getColumn(4).setHeaderValue("Birthdate");
		user_table.getColumnModel().getColumn(5).setHeaderValue("Phone");
		
		
		
			
		
		
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setPreferredSize(new Dimension(5,600));
		lblNewLabel_8.setBackground(new Color(18, 151, 248));
		lblNewLabel_8.setOpaque(true);
		users.add(lblNewLabel_8);
		
		
		
		
		JPanel add_users = new JPanel();
		add_users.setPreferredSize(new Dimension(180,600));
		users.add(add_users);
		FlowLayout fl_add_users = new FlowLayout(FlowLayout.LEFT, 5, 5);
		add_users.setLayout(fl_add_users);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setPreferredSize(new Dimension(180,20));
		add_users.add(lblNewLabel_1);
		
		user_name = new JTextField();
		user_name.setPreferredSize(new Dimension(160,20));
		add_users.add(user_name);
		
		JLabel lblNewLabel_2 = new JLabel("Surname");
		lblNewLabel_2.setPreferredSize(new Dimension(160,20));
		add_users.add(lblNewLabel_2);
		
		user_surname = new JTextField();
		user_surname.setPreferredSize(new Dimension(160,20));
		add_users.add(user_surname);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail");
		add_users.add(lblNewLabel_3);
		
		user_mail = new JTextField();
		user_mail.setPreferredSize(new Dimension(160,20));
		add_users.add(user_mail);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		add_users.add(lblNewLabel_5);
		
		user_password = new JPasswordField();
		user_password.setPreferredSize(new Dimension(160,20));
		add_users.add(user_password);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		add_users.add(lblNewLabel_4);
		
		user_phone_number = new JTextField();
		user_phone_number.setPreferredSize(new Dimension(160,20));
		add_users.add(user_phone_number);
		
		String[] departments = { "Computer Eng.", "eee", "aes", "bio", "Phy" };
		
		JLabel lblNewLabel_6 = new JLabel("Date of Birth");
		add_users.add(lblNewLabel_6);
		
		JFormattedTextField user_b_day = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		user_b_day.setPreferredSize(new Dimension(160,20));
		add_users.add(user_b_day);
		
		JLabel lblNewLabel_7 = new JLabel("Student ID");
		add_users.add(lblNewLabel_7);
		
		user_student_id = new JTextField();
		user_student_id.setPreferredSize(new Dimension(160,20));
		add_users.add(user_student_id);
		JComboBox department = new JComboBox(departments);
		department.setPreferredSize(new Dimension(160,20));
		department.setSelectedIndex(0);
		add_users.add(department);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(160,40));
		add_users.add(panel_2);
		
		JLabel add_user_btn = new JLabel("ADD");
		add_user_btn.setFont(new Font("monospace", Font.BOLD, 16));
		add_user_btn.setHorizontalAlignment(SwingConstants.CENTER);
		add_user_btn.setPreferredSize(new Dimension(110,24));
		add_user_btn.setForeground(Color.WHITE);
		add_user_btn.setBackground(new Color(18, 151, 248));
		add_user_btn.setOpaque(true);
		add_user_btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try{
					Connection con;
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
					if(user_name.getText().isEmpty() || user_surname.getText().isEmpty() || user_mail.getText().isEmpty() || user_password.getText().isEmpty() || user_phone_number.getText().isEmpty() || user_b_day.getText().isEmpty() || user_student_id.getText().isEmpty() || department.getSelectedItem().toString().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please fill all fields!");
						return;
					}else{
						java.sql.Statement stmt=con.createStatement(); 
						String student_id_check="Select * from `user` where `student_id`='"+Integer.parseInt(user_student_id.getText())+"'";
						ResultSet student_id_rs=stmt.executeQuery(student_id_check);
						if(student_id_rs.next()){
							JOptionPane.showMessageDialog(null, "This user already registered in system!");
							return;
						}else{
							String student_mail_check="Select * from `auth` where `email`='"+user_mail.getText()+"'";
							ResultSet student_mail_rs=stmt.executeQuery(student_mail_check);
							if(student_mail_rs.next()) {
								JOptionPane.showMessageDialog(null, "This user already registered in system!");
								return;
							}else{
								if(user_phone_number.getText().length() < 12){
									if(user_name.getText().length() <20) {
										if(user_surname.getText().length() < 20) {
											if(user_mail.getText().length() < 20) {
												if(user_password.getText().toString().length() < 20) {
													//inserting user to auth table 
													String user_status = "user";
													String auth_user = "INSERT INTO `auth`(`password`, `email`, `status`) VALUES (?,?,?)";
													PreparedStatement pst_auth = con.prepareStatement(auth_user);
													pst_auth.setString(1, user_password.getText());
													pst_auth.setString(2, user_mail.getText().toString());
													pst_auth.setString(3, user_status);
													pst_auth.execute();
													//collecting the given id from auth table
													con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
													java.sql.Statement collect_id_stmt=con.createStatement(); 
													String collect_id = "SELECT * FROM `auth` WHERE `email`='"+user_mail.getText()+"'";
													ResultSet collect_id_rs=collect_id_stmt.executeQuery(collect_id);
													collect_id_rs.next();
													//inserting user to user table
													java.util.Date theDate = (java.util.Date)user_b_day.getValue();
													String insert_user = "INSERT INTO `user`(`id`, `name`, `surname`, `email`, `password`, `b_day`, `student_id`, `department`, `phone`) VALUES (?,?,?,?,?,?,?,?,?)";
													PreparedStatement pst_insert = con.prepareStatement(insert_user);
													pst_insert.setInt(1, collect_id_rs.getInt("id"));
													pst_insert.setString(2, user_name.getText());
													pst_insert.setString(3, user_surname.getText());
													pst_insert.setString(4, user_mail.getText());
													pst_insert.setString(5, user_password.getText().toString());
													pst_insert.setDate(6, new java.sql.Date(theDate.getTime()));
													pst_insert.setInt(7, Integer.parseInt(user_student_id.getText()));
													pst_insert.setString(8, department.getSelectedItem().toString());
													pst_insert.setString(9, user_phone_number.getText());
													pst_insert.executeUpdate();
													//update the user table 
													con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
													java.sql.Statement user_update_stmt=con.createStatement();
													String user_update_sql="SELECT `name`, `surname`, `student_id`, `department`, `b_day`,`phone` FROM `user`";
													ResultSet user_update_rs=user_update_stmt.executeQuery(user_update_sql);
													scrollPane_1.setViewportView(user_table);
													scrollPane_1.setViewportBorder(null);
													user_table.setModel(DbUtils.resultSetToTableModel(user_update_rs));
													user_table.getColumnModel().getColumn(0).setHeaderValue("Name");
													user_table.getColumnModel().getColumn(1).setHeaderValue("Surname");
													user_table.getColumnModel().getColumn(2).setHeaderValue("Student ID");
													user_table.getColumnModel().getColumn(3).setHeaderValue("Department");
													user_table.getColumnModel().getColumn(4).setHeaderValue("Birthdate");
													user_table.getColumnModel().getColumn(5).setHeaderValue("Phone");
													
												}else {
													JOptionPane.showMessageDialog(null, "Password needs to be smaller than 20 characters");
												}
											}else {
												JOptionPane.showMessageDialog(null, "Mail needs to smaller than 20 characters");
											}
										}else {
											JOptionPane.showMessageDialog(null, "Surname needs to be smaller than 20 characters");
										}
									}else {
										JOptionPane.showMessageDialog(null, "Name needs to be smaller than 20 characters");
									}
								}else {
									JOptionPane.showMessageDialog(null, "Phone number can not longer than 11 digits!");
								}
							}
							JOptionPane.showMessageDialog(null, "Added Successfully");
						}
					}
				}catch(Exception e){
					JOptionPane.showInternalMessageDialog(null, e);
				}
			}
		});
		panel_2.add(add_user_btn);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(160,4));
		add_users.add(separator);
		
		JLabel lblNewLabel_9 = new JLabel("Delete User");
		lblNewLabel_9.setPreferredSize(new Dimension(110,24));
		add_users.add(lblNewLabel_9);
		
		delete_user_id = new JTextField();
		delete_user_id.setPreferredSize(new Dimension(160,24));
		add_users.add(delete_user_id);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setPreferredSize(new Dimension(160, 40));
		add_users.add(panel_2_1);
		
		JLabel add_delete_btn = new JLabel("DELETE");
		add_delete_btn.setPreferredSize(new Dimension(110, 24));
		add_delete_btn.setOpaque(true);
		add_delete_btn.setHorizontalAlignment(SwingConstants.CENTER);
		add_delete_btn.setForeground(Color.WHITE);
		add_delete_btn.setFont(new Font("Dialog", Font.BOLD, 16));
		add_delete_btn.setBackground(Color.red);
		add_delete_btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					if(delete_user_id.getText().isEmpty()) {
						JOptionPane.showInternalMessageDialog(null, "Fill enter the field with student ID that you want to remove from system!");
						return;
					}else {
							//check given student id 
							Connection con;
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
							java.sql.Statement delete_user_stmt=con.createStatement(); 
							String delete_user_sql="Select * from `user` where `student_id`='"+Integer.parseInt(delete_user_id.getText())+"'";
							ResultSet student_id_delete=delete_user_stmt.executeQuery(delete_user_sql);
							if(student_id_delete.next()) {
								//delete user with given student id 
								String delete_user="DELETE FROM `user` WHERE `student_id`='"+Integer.parseInt(delete_user_id.getText())+"'"; 
								java.sql.Statement delete_now_stmt = con.createStatement();
								delete_now_stmt.executeLargeUpdate(delete_user);
								//update user table
								con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
								java.sql.Statement user_update_stmt=con.createStatement();
								String user_update_sql="SELECT `name`, `surname`, `student_id`, `department`, `b_day`,`phone` FROM `user`";
								ResultSet user_update_rs=user_update_stmt.executeQuery(user_update_sql);
								scrollPane_1.setViewportView(user_table);
								scrollPane_1.setViewportBorder(null);
								user_table.setModel(DbUtils.resultSetToTableModel(user_update_rs));
								user_table.getColumnModel().getColumn(0).setHeaderValue("Name");
								user_table.getColumnModel().getColumn(1).setHeaderValue("Surname");
								user_table.getColumnModel().getColumn(2).setHeaderValue("Student ID");
								user_table.getColumnModel().getColumn(3).setHeaderValue("Department");
								user_table.getColumnModel().getColumn(4).setHeaderValue("Birthdate");
								user_table.getColumnModel().getColumn(5).setHeaderValue("Phone");
								JOptionPane.showMessageDialog(null, "User removed from system successfully!");
							}else {
								JOptionPane.showMessageDialog(null, "There is no user with that student id!");
								return;
							}
						}
				}catch(Exception e) {
					JOptionPane.showInternalMessageDialog(null, e);
				}
			}
		});
		
		
		
		panel_2_1.add(add_delete_btn);
		
		
		//staff tab starts here 
		JPanel staffs = new JPanel();

		JPanel show_staffs = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) show_staffs.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		show_staffs.setPreferredSize(new Dimension(490,600));
		staffs.add(show_staffs);
		
		ResultSet staff_rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
			java.sql.Statement stmt=con.createStatement();
			String staff_sql="SELECT `id`, `name`, `surname`, `email`,`b_day`, `phone` FROM `staff`";
			staff_rs=stmt.executeQuery(staff_sql);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		}
		
		JScrollPane scrollPane_2 = new JScrollPane();
		show_staffs.add(scrollPane_2);
		
		JTable staff_table = new JTable();
		staff_table.setPreferredSize(new Dimension(500,600));
		scrollPane_2.setViewportView(staff_table);
		scrollPane_2.setViewportBorder(null);
		staff_table.setModel(DbUtils.resultSetToTableModel(staff_rs));
		staff_table.getColumnModel().getColumn(0).setHeaderValue("ID");
		staff_table.getColumnModel().getColumn(0).setPreferredWidth(30);
		staff_table.getColumnModel().getColumn(1).setHeaderValue("Name");
		staff_table.getColumnModel().getColumn(1).setPreferredWidth(100);
		staff_table.getColumnModel().getColumn(2).setHeaderValue("Surname");
		staff_table.getColumnModel().getColumn(2).setPreferredWidth(100);
		staff_table.getColumnModel().getColumn(3).setHeaderValue("Email");
		staff_table.getColumnModel().getColumn(4).setHeaderValue("Birthdate");
		staff_table.getColumnModel().getColumn(5).setHeaderValue("Phone");
		
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setPreferredSize(new Dimension(5, 600));
		lblNewLabel_8_1.setOpaque(true);
		lblNewLabel_8_1.setBackground(new Color(18, 151, 248));
		staffs.add(lblNewLabel_8_1);
		
		JPanel add_staffs = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) add_staffs.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		add_staffs.setPreferredSize(new Dimension(180,600));
		staffs.add(add_staffs);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setPreferredSize(new Dimension(180, 20));
		add_staffs.add(lblNewLabel_1_1);
		
		staff_name = new JTextField();
		staff_name.setPreferredSize(new Dimension(160, 20));
		add_staffs.add(staff_name);
		
		JLabel lblNewLabel_2_1 = new JLabel("Surname");
		lblNewLabel_2_1.setPreferredSize(new Dimension(160, 20));
		add_staffs.add(lblNewLabel_2_1);
		
		staff_surname = new JTextField();
		staff_surname.setPreferredSize(new Dimension(160, 20));
		add_staffs.add(staff_surname);
		
		JLabel lblNewLabel_3_1 = new JLabel("E-mail");
		add_staffs.add(lblNewLabel_3_1);
		
		staff_mail = new JTextField();
		staff_mail.setPreferredSize(new Dimension(160, 20));
		add_staffs.add(staff_mail);
		
		JLabel lblNewLabel_5_1 = new JLabel("Password");
		add_staffs.add(lblNewLabel_5_1);
		
		staff_password = new JPasswordField();
		staff_password.setPreferredSize(new Dimension(160, 20));
		add_staffs.add(staff_password);
		
		JLabel lblNewLabel_4_1 = new JLabel("Phone Number");
		add_staffs.add(lblNewLabel_4_1);
		
		staff_phone = new JTextField();
		staff_phone.setPreferredSize(new Dimension(160, 20));
		add_staffs.add(staff_phone);
		
		JLabel lblNewLabel_6_1 = new JLabel("Date of Birth");
		add_staffs.add(lblNewLabel_6_1);
		
		JFormattedTextField staff_b_day = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		staff_b_day.setPreferredSize(new Dimension(160, 20));
		add_staffs.add(staff_b_day);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setPreferredSize(new Dimension(160, 40));
		add_staffs.add(panel_2_2);
		
		JLabel add_staff_btn = new JLabel("ADD");
		add_staff_btn.setPreferredSize(new Dimension(110, 24));
		add_staff_btn.setOpaque(true);
		add_staff_btn.setHorizontalAlignment(SwingConstants.CENTER);
		add_staff_btn.setForeground(Color.WHITE);
		add_staff_btn.setFont(new Font("Dialog", Font.BOLD, 16));
		add_staff_btn.setBackground(new Color(18, 151, 248));
		add_staff_btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					if(staff_name.getText().isEmpty() || staff_surname.getText().isEmpty() || staff_mail.getText().isEmpty() || staff_password.getText().isEmpty() || staff_phone.getText().isEmpty() || staff_b_day.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Please fill all fields!");
						return;
					}else {
						Connection con;
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
						java.sql.Statement staff_stmt=con.createStatement(); 
						String staff_mail_check="Select * from `auth` where `email`='"+staff_mail.getText()+"'";
						ResultSet staff_mail_rs=staff_stmt.executeQuery(staff_mail_check);
						if(staff_mail_rs.next()) {
							JOptionPane.showMessageDialog(null, "This staff already registered in system!");
							return;
						}else {
							if(staff_name.getText().length() < 20){
								if(staff_surname.getText().length() < 20) {
									if(staff_mail.getText().length() < 20) {
										if(staff_password.getText().toString().length() < 20) {
											if(staff_phone.getText().length()<12) {
												con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
												//inserting user to auth table 
												String staff_status = "staff";
												String auth_user = "INSERT INTO `auth`(`password`, `email`, `status`) VALUES (?,?,?)";
												PreparedStatement pst_auth = con.prepareStatement(auth_user);
												pst_auth.setString(1, staff_password.getText());
												pst_auth.setString(2, staff_mail.getText().toString());
												pst_auth.setString(3, staff_status);
												pst_auth.execute();
												//collecting the given id from auth table
												java.sql.Statement collect_id_stmt=con.createStatement(); 
												String collect_id = "SELECT * FROM `auth` WHERE `email`='"+staff_mail.getText()+"'";
												ResultSet collect_id_rs=collect_id_stmt.executeQuery(collect_id);
												collect_id_rs.next();
												//inserting user to user table
												java.util.Date theDate = (java.util.Date)staff_b_day.getValue();
												String insert_user = "INSERT INTO `staff`(`id`, `name`, `surname`, `email`, `password`, `b_day`, `phone`) VALUES (?,?,?,?,?,?,?)";
												PreparedStatement pst_insert = con.prepareStatement(insert_user);
												pst_insert.setInt(1, collect_id_rs.getInt("id"));
												pst_insert.setString(2, staff_name.getText());
												pst_insert.setString(3, staff_surname.getText());
												pst_insert.setString(4, staff_mail.getText());
												pst_insert.setString(5, staff_password.getText().toString());
												pst_insert.setDate(6, new java.sql.Date(theDate.getTime()));
												pst_insert.setString(7, staff_phone.getText());
												pst_insert.executeUpdate();
												//update database
												con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
												java.sql.Statement stmt=con.createStatement();
												String staff_sql="SELECT `id`, `name`, `surname`, `email`,`b_day`, `phone` FROM `staff`";
												ResultSet staff_rs=stmt.executeQuery(staff_sql);
												staff_table.setPreferredSize(new Dimension(500,600));
												scrollPane_2.setViewportView(staff_table);
												staff_table.setModel(DbUtils.resultSetToTableModel(staff_rs));
												staff_table.getColumnModel().getColumn(0).setHeaderValue("ID");
												staff_table.getColumnModel().getColumn(0).setPreferredWidth(30);
												staff_table.getColumnModel().getColumn(1).setHeaderValue("Name");
												staff_table.getColumnModel().getColumn(1).setPreferredWidth(100);
												staff_table.getColumnModel().getColumn(2).setHeaderValue("Surname");
												staff_table.getColumnModel().getColumn(2).setPreferredWidth(100);
												staff_table.getColumnModel().getColumn(3).setHeaderValue("Email");
												staff_table.getColumnModel().getColumn(4).setHeaderValue("Birthdate");
												staff_table.getColumnModel().getColumn(5).setHeaderValue("Phone");
												
											}else{
												JOptionPane.showInternalMessageDialog(null, "Phone must be 11 digits!");
												return;
											}
										}else{
											JOptionPane.showInternalMessageDialog(null, "Password must be less than 20 letters!");
											return;
										}
									}else{
										JOptionPane.showInternalMessageDialog(null, "Mail must be less than 20 letters!");
										return;
									}
								}else{
									JOptionPane.showInternalMessageDialog(null, "Surname must be less than 20 letters!");
									return;
								}
							}else{
								JOptionPane.showInternalMessageDialog(null, "Name must be less than 20 letters!");
								return;
							}
						}
						}
						
				}catch(Exception e) {
					JOptionPane.showInternalMessageDialog(null, e);
					return;
				}
			}
		});
		panel_2_2.add(add_staff_btn);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(160, 4));
		add_staffs.add(separator_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("Delete Staff");
		lblNewLabel_9_1.setPreferredSize(new Dimension(110, 24));
		add_staffs.add(lblNewLabel_9_1);
		
		delete_staff_id = new JTextField();
		delete_staff_id.setPreferredSize(new Dimension(160, 24));
		add_staffs.add(delete_staff_id);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setPreferredSize(new Dimension(160, 40));
		add_staffs.add(panel_2_1_1);
		
		JLabel add_delete_btn_1 = new JLabel("DELETE");
		add_delete_btn_1.setPreferredSize(new Dimension(110, 24));
		add_delete_btn_1.setOpaque(true);
		add_delete_btn_1.setHorizontalAlignment(SwingConstants.CENTER);
		add_delete_btn_1.setForeground(Color.WHITE);
		add_delete_btn_1.setFont(new Font("Dialog", Font.BOLD, 16));
		add_delete_btn_1.setBackground(Color.RED);
		add_delete_btn_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					Connection con;
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
					java.sql.Statement staff_stmt=con.createStatement(); 
					String staff_mail_check="Select * from `staff` where `id`='"+Integer.parseInt(delete_staff_id.getText())+"'";
					ResultSet staff_mail_rs=staff_stmt.executeQuery(staff_mail_check);
					if(staff_mail_rs.next()) {
						//delete user from staff
						String delete_user="DELETE FROM `staff` WHERE `id`='"+Integer.parseInt(delete_staff_id.getText())+"'"; 
						java.sql.Statement delete_now_stmt = con.createStatement();
						delete_now_stmt.executeLargeUpdate(delete_user);
						//update staff table
						String staff_sql="SELECT `id`, `name`, `surname`, `email`,`b_day`, `phone` FROM `staff`";
						ResultSet staff_rs=staff_stmt.executeQuery(staff_sql);
						staff_table.setPreferredSize(new Dimension(500,600));
						scrollPane_2.setViewportView(staff_table);
						scrollPane_2.setViewportBorder(null);
						staff_table.setModel(DbUtils.resultSetToTableModel(staff_rs));
						staff_table.getColumnModel().getColumn(0).setHeaderValue("ID");
						staff_table.getColumnModel().getColumn(0).setPreferredWidth(30);
						staff_table.getColumnModel().getColumn(1).setHeaderValue("Name");
						staff_table.getColumnModel().getColumn(1).setPreferredWidth(100);
						staff_table.getColumnModel().getColumn(2).setHeaderValue("Surname");
						staff_table.getColumnModel().getColumn(2).setPreferredWidth(100);
						staff_table.getColumnModel().getColumn(3).setHeaderValue("Email");
						staff_table.getColumnModel().getColumn(4).setHeaderValue("Birthdate");
						staff_table.getColumnModel().getColumn(5).setHeaderValue("Phone");
					}else {
						JOptionPane.showMessageDialog(null, "There is no staff with taht id!");
						return;
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		panel_2_1_1.add(add_delete_btn_1);
		
		//book starts here
		JPanel book = new JPanel();
		
		JPanel book_display = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) book_display.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		book_display.setPreferredSize(new Dimension(490,600));
		
		ResultSet book_rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
			java.sql.Statement stmt=con.createStatement();
			String book_sql="SELECT `book_ID`, `name`, `author_name`, `genre`, `edition`, `ISBN` FROM `book`";
			book_rs=stmt.executeQuery(book_sql);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		}
		
		JScrollPane scrollPane = new JScrollPane();
		book_display.add(scrollPane);
		JTable book_table_1 = new JTable();
		book_table_1.setPreferredSize(new Dimension(500,600));
		scrollPane.setViewportView(book_table_1);
		scrollPane.setViewportBorder(null);
		book_table_1.setModel(DbUtils.resultSetToTableModel(book_rs));
		book_table_1.getColumnModel().getColumn(0).setPreferredWidth(30);
		book_table_1.getColumnModel().getColumn(0).setHeaderValue("ID");
		book_table_1.getColumnModel().getColumn(1).setPreferredWidth(250);
		book_table_1.getColumnModel().getColumn(1).setHeaderValue("Book Name");
		book_table_1.getColumnModel().getColumn(2).setPreferredWidth(130);
		book_table_1.getColumnModel().getColumn(2).setHeaderValue("Author Name");
		book_table_1.getColumnModel().getColumn(3).setPreferredWidth(100);
		book_table_1.getColumnModel().getColumn(3).setHeaderValue("Genre");
		book_table_1.getColumnModel().getColumn(4).setPreferredWidth(60);
		book_table_1.getColumnModel().getColumn(4).setHeaderValue("Edition");
		book_table_1.getColumnModel().getColumn(5).setPreferredWidth(60);
		book_table_1.getColumnModel().getColumn(5).setHeaderValue("ISBN");
		book.add(book_display);
		
		
		
		
		JLabel lblNewLabel_8_2 = new JLabel("");
		lblNewLabel_8_2.setPreferredSize(new Dimension(5, 600));
		lblNewLabel_8_2.setOpaque(true);
		lblNewLabel_8_2.setBackground(new Color(18, 151, 248));
		book.add(lblNewLabel_8_2);
		JPanel add_book = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) add_book.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		add_book.setPreferredSize(new Dimension(180,600));
		book.add(add_book);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Name");
		lblNewLabel_1_1_1.setPreferredSize(new Dimension(180, 20));
		add_book.add(lblNewLabel_1_1_1);
		
		book_name = new JTextField();
		book_name.setPreferredSize(new Dimension(160, 20));
		add_book.add(book_name);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Author Name");
		lblNewLabel_2_1_1.setPreferredSize(new Dimension(160, 20));
		add_book.add(lblNewLabel_2_1_1);
		
		book_author = new JTextField();
		book_author.setPreferredSize(new Dimension(160, 20));
		add_book.add(book_author);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Edition");
		add_book.add(lblNewLabel_3_1_1);
		
		book_edition = new JTextField();
		book_edition.setPreferredSize(new Dimension(160, 20));
		add_book.add(book_edition);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Genre of Book");
		add_book.add(lblNewLabel_5_1_1);
		
		book_genre = new JTextField();
		book_genre.setPreferredSize(new Dimension(160, 20));
		add_book.add(book_genre);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("ISBN");
		add_book.add(lblNewLabel_5_1_1_1);
		
		book_isbn = new JTextField();
		book_isbn.setPreferredSize(new Dimension(160, 20));
		add_book.add(book_isbn);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setPreferredSize(new Dimension(160, 40));
		add_book.add(panel_2_2_1);
		
		JLabel add_book_btn = new JLabel("ADD");
		add_book_btn.setPreferredSize(new Dimension(110, 24));
		add_book_btn.setOpaque(true);
		add_book_btn.setHorizontalAlignment(SwingConstants.CENTER);
		add_book_btn.setForeground(Color.WHITE);
		add_book_btn.setFont(new Font("Dialog", Font.BOLD, 16));
		add_book_btn.setBackground(new Color(18, 151, 248));
		add_book_btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					Connection con;
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
					
					if(book_name.getText().isEmpty() || book_author.getText().isEmpty() || book_genre.getText().isEmpty() || book_edition.getText().isEmpty() || book_isbn.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please fill all fields!");
						return;
					}else {
						java.sql.Statement stmt=con.createStatement(); 
						String isbn_check="Select * from book where `ISBN`='"+Integer.parseInt(book_isbn.getText())+"'";
						ResultSet isbn_rs=stmt.executeQuery(isbn_check);
						if(isbn_rs.next()){
							JOptionPane.showMessageDialog(null, "This book already in library!");
							return;
						}else {
							String insert_book = "INSERT INTO `book`(`name`, `author_name`, `genre`, `edition`, `ISBN`, `edited_by`) VALUES (?,?,?,?,?,?)";
							PreparedStatement pst = con.prepareStatement(insert_book);
							pst.setString(1, book_name.getText());
							pst.setString(2, book_author.getText());
							pst.setString(3, book_genre.getText());
							pst.setInt(4, Integer.parseInt(book_edition.getText()));
							pst.setInt(5, Integer.parseInt(book_isbn.getText()));
							pst.setInt(6, current_id);
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Added Successfully");
							java.sql.Statement book_stmt=con.createStatement();
							String book_sql="SELECT `book_ID`, `name`, `author_name`, `genre`, `edition`, `ISBN` FROM `book`";
							ResultSet book_rs=book_stmt.executeQuery(book_sql);
							scrollPane.setViewportView(book_table_1);
							scrollPane.setViewportBorder(null);
							book_table_1.setModel(DbUtils.resultSetToTableModel(book_rs));
							book_table_1.getColumnModel().getColumn(0).setPreferredWidth(30);
							book_table_1.getColumnModel().getColumn(0).setHeaderValue("ID");
							book_table_1.getColumnModel().getColumn(1).setPreferredWidth(250);
							book_table_1.getColumnModel().getColumn(1).setHeaderValue("Book Name");
							book_table_1.getColumnModel().getColumn(2).setPreferredWidth(130);
							book_table_1.getColumnModel().getColumn(2).setHeaderValue("Author Name");
							book_table_1.getColumnModel().getColumn(3).setPreferredWidth(100);
							book_table_1.getColumnModel().getColumn(3).setHeaderValue("Genre");
							book_table_1.getColumnModel().getColumn(4).setPreferredWidth(60);
							book_table_1.getColumnModel().getColumn(4).setHeaderValue("Edition");
							book_table_1.getColumnModel().getColumn(5).setPreferredWidth(60);
							book_table_1.getColumnModel().getColumn(5).setHeaderValue("ISBN");
						}
						
					}	
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		panel_2_2_1.add(add_book_btn);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setPreferredSize(new Dimension(160, 4));
		add_book.add(separator_1_1);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Delete Book");
		lblNewLabel_9_1_1.setPreferredSize(new Dimension(110, 24));
		add_book.add(lblNewLabel_9_1_1);
		
		delete_book_id = new JTextField();
		delete_book_id.setPreferredSize(new Dimension(160, 24));
		add_book.add(delete_book_id);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setPreferredSize(new Dimension(160, 40));
		add_book.add(panel_2_1_1_1);
		
		JLabel delete_book = new JLabel("DELETE");
		delete_book.setPreferredSize(new Dimension(110, 24));
		delete_book.setOpaque(true);
		delete_book.setHorizontalAlignment(SwingConstants.CENTER);
		delete_book.setForeground(Color.WHITE);
		delete_book.setFont(new Font("Dialog", Font.BOLD, 16));
		delete_book.setBackground(Color.RED);
		delete_book.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					Connection con;
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
					if(delete_book_id.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Fill the field for remove a book from library!");		
					}else{
						java.sql.Statement stmt=con.createStatement(); 
						String book_id_check="Select * from book where `book_ID`='"+Integer.parseInt(delete_book_id.getText())+"'";
						ResultSet book_id_rs=stmt.executeQuery(book_id_check);
						if(!book_id_rs.next()){
							JOptionPane.showMessageDialog(null, "Library does not have a book with given ID!");
							return;
						}else {
							String insert_book = "DELETE FROM `book` WHERE `book_ID`='"+Integer.parseInt(delete_book_id.getText())+"'";
							PreparedStatement pst = con.prepareStatement(insert_book);
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Book deleted succsessfully");
							java.sql.Statement book_stmt=con.createStatement();
							String book_sql="SELECT `book_ID`, `name`, `author_name`, `genre`, `edition`, `ISBN` FROM `book`";
							ResultSet book_rs=book_stmt.executeQuery(book_sql);
							scrollPane.setViewportView(book_table_1);
							scrollPane.setViewportBorder(null);
							book_table_1.setModel(DbUtils.resultSetToTableModel(book_rs));
							book_table_1.getColumnModel().getColumn(0).setPreferredWidth(30);
							book_table_1.getColumnModel().getColumn(0).setHeaderValue("ID");
							book_table_1.getColumnModel().getColumn(1).setPreferredWidth(250);
							book_table_1.getColumnModel().getColumn(1).setHeaderValue("Book Name");
							book_table_1.getColumnModel().getColumn(2).setPreferredWidth(130);
							book_table_1.getColumnModel().getColumn(2).setHeaderValue("Author Name");
							book_table_1.getColumnModel().getColumn(3).setPreferredWidth(100);
							book_table_1.getColumnModel().getColumn(3).setHeaderValue("Genre");
							book_table_1.getColumnModel().getColumn(4).setPreferredWidth(60);
							book_table_1.getColumnModel().getColumn(4).setHeaderValue("Edition");
							book_table_1.getColumnModel().getColumn(5).setPreferredWidth(60);
							book_table_1.getColumnModel().getColumn(5).setHeaderValue("ISBN");
						}
						
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		panel_2_1_1_1.add(delete_book);
		
		
		tabbedPane.addTab("BOOKS", book);
		
		
		JPanel summary_page= new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) summary_page.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		JPanel show_issues = new JPanel();
		show_issues.setPreferredSize(new Dimension(450,600));
		summary_page.add(show_issues);
		
		ResultSet issue_rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
			java.sql.Statement stmt=con.createStatement();
			String issue_sql="SELECT `id`, `student_ID`, `staff_ID`, `ISBN`, `reserveDate`,`returnDate` FROM `issue`";
			issue_rs=stmt.executeQuery(issue_sql);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		}
		
		JScrollPane scrollPane_3 = new JScrollPane();
		show_issues.add(scrollPane_3);
		
		JTable issues_table = new JTable();
		scrollPane_3.setViewportView(issues_table);
		scrollPane_3.setViewportBorder(null);
		issues_table.setModel(DbUtils.resultSetToTableModel(issue_rs));
		scrollPane_3.getViewport().setBackground(Color.WHITE);
		
		JLabel lblNewLabel_8_3 = new JLabel("");
		lblNewLabel_8_3.setPreferredSize(new Dimension(5, 600));
		lblNewLabel_8_3.setOpaque(true);
		lblNewLabel_8_3.setBackground(new Color(18, 151, 248));
		summary_page.add(lblNewLabel_8_3);
		
		JPanel add_issues = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) add_issues.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		add_issues.setPreferredSize(new Dimension(220,600));
		summary_page.add(add_issues);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Student ID");
		lblNewLabel_1_1_1_1.setPreferredSize(new Dimension(200, 20));
		add_issues.add(lblNewLabel_1_1_1_1);
		
		issue_student_id = new JTextField();
		issue_student_id.setPreferredSize(new Dimension(200, 20));
		add_issues.add(issue_student_id);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("ISBN of Book");
		lblNewLabel_2_1_1_1.setPreferredSize(new Dimension(160, 20));
		add_issues.add(lblNewLabel_2_1_1_1);
		
		issue_isbn = new JTextField();
		issue_isbn.setPreferredSize(new Dimension(200, 20));
		add_issues.add(issue_isbn);
		JCalendar due_date = new JCalendar();
		due_date.setPreferredSize(new Dimension(200, 150));
		add_issues.add(due_date);
		
		JPanel panel_2_2_1_1 = new JPanel();
		panel_2_2_1_1.setPreferredSize(new Dimension(200, 40));
		add_issues.add(panel_2_2_1_1);
		
		JLabel create_issues = new JLabel("CREATE ISSUE");
		create_issues.setPreferredSize(new Dimension(160, 24));
		create_issues.setOpaque(true);
		create_issues.setHorizontalAlignment(SwingConstants.CENTER);
		create_issues.setForeground(Color.WHITE);
		create_issues.setFont(new Font("Dialog", Font.BOLD, 16));
		create_issues.setBackground(new Color(18, 151, 248));
		java.util.Date theDate = (java.util.Date)user_b_day.getValue();
		create_issues.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Connection con;
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
					if(issue_student_id.getText().isEmpty() || issue_isbn.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please fill all fields!");
						return;
					}else {
						java.sql.Statement isbn_check_stmt=con.createStatement(); 
						String isbn_check="Select * from book where `ISBN`='"+Integer.parseInt(issue_isbn.getText())+"'";
						ResultSet isbn_rs=isbn_check_stmt.executeQuery(isbn_check);
						if(isbn_rs.next()) {
							java.sql.Statement student_stmt=con.createStatement(); 
							String student_id_check="Select * from user where `student_id`='"+Integer.parseInt(issue_student_id.getText())+"'";
							ResultSet student_rs=student_stmt.executeQuery(student_id_check);
							if(student_rs.next()) {
								long millis=System.currentTimeMillis();  
								java.sql.Date sqlDate = new java.sql.Date(millis);//current date
								java.util.Date d = due_date.getDate();
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
								String x = formatter.format(d);//selected date
								if(x.compareTo(sqlDate.toString())>0) {
									String auth_user = "INSERT INTO `issue`(`student_ID`, `staff_ID`, `ISBN`, `reserveDate`, `returnDate`) VALUES (?,?,?,?,?)";
									PreparedStatement pst_issue = con.prepareStatement(auth_user);
									pst_issue.setInt(1, Integer.parseInt(issue_student_id.getText()) );
									pst_issue.setInt(2, current_id);
									pst_issue.setInt(3, Integer.parseInt(issue_isbn.getText()));
									pst_issue.setDate(4, new java.sql.Date(sqlDate.getTime()));
									pst_issue.setString(5, x);
									pst_issue.execute();
								}else {
									JOptionPane.showMessageDialog(null, "Due date must be at least 1 day after today!");
									return;
								}
							}else {
								JOptionPane.showMessageDialog(null, "There is no user with given student ID!");
								return;
							}
						}else {
							JOptionPane.showMessageDialog(null, "There is no book with given ISBN!");
							return;
						}
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		panel_2_2_1_1.add(create_issues);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setPreferredSize(new Dimension(200, 4));
		add_issues.add(separator_1_1_1);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_3.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panel_3.setPreferredSize(new Dimension(220, 150));
		add_issues.add(panel_3);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("Delete Issue ID");
		lblNewLabel_9_1_1_1.setPreferredSize(new Dimension(110, 24));
		panel_3.add(lblNewLabel_9_1_1_1);
		
		delete_issue_id = new JTextField();
		delete_issue_id.setPreferredSize(new Dimension(200, 24));
		panel_3.add(delete_issue_id);
		
		JPanel panel_2_1_1_1_1 = new JPanel();
		panel_2_1_1_1_1.setPreferredSize(new Dimension(200, 40));
		panel_3.add(panel_2_1_1_1_1);
		
		JLabel delete_book_1 = new JLabel("DELETE");
		delete_book_1.setPreferredSize(new Dimension(110, 24));
		delete_book_1.setOpaque(true);
		delete_book_1.setHorizontalAlignment(SwingConstants.CENTER);
		delete_book_1.setForeground(Color.WHITE);
		delete_book_1.setFont(new Font("Dialog", Font.BOLD, 16));
		delete_book_1.setBackground(Color.RED);
		delete_book_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					if(delete_issue_id.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Enter the id of selected issue!");
						return;
					}else {
						Connection con;
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
						java.sql.Statement issue_stmt=con.createStatement(); 
						String issue_id_check="Select * from issue where `id`='"+Integer.parseInt(delete_issue_id.getText())+"'";
						ResultSet issue_rs=issue_stmt.executeQuery(issue_id_check);
						if(issue_rs.next()) {
							String delete_issue = "DELETE FROM `issue` WHERE `id`='"+Integer.parseInt(delete_issue_id.getText())+"'";
							PreparedStatement pst = con.prepareStatement(delete_issue);
							pst.executeUpdate();
							//update issue table
							String issue_sql="SELECT `id`, `student_ID`, `staff_ID`, `ISBN`, `reserveDate`,`returnDate` FROM `issue`";
							ResultSet issue_update=issue_stmt.executeQuery(issue_sql);
							scrollPane_3.setViewportView(issues_table);
							scrollPane_3.setViewportBorder(null);
							issues_table.setModel(DbUtils.resultSetToTableModel(issue_update));
						}else {
							JOptionPane.showMessageDialog(null, "There is no issue with given id!");
							return;
						}
						
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		
		
		panel_2_1_1_1_1.add(delete_book_1);
		tabbedPane.addTab("SUMMARY PAGE", summary_page);
		
		
		
		JPanel expired_issues = new JPanel();
		
		tabbedPane.addTab("EXPIRED ISSUES", expired_issues);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		expired_issues.add(scrollPane_4);
		//expired_result_query
		LocalDate today = java.time.LocalDate.now(); 
		ResultSet expired_rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceng_301","root","");
			java.sql.Statement expired_stmt=con.createStatement();
			String expired_sql="SELECT `id`, `student_ID`, `staff_ID`, `ISBN`, `reserveDate`, `returnDate` FROM `issue` WHERE `returnDate`< CURRENT_DATE";
			expired_rs=expired_stmt.executeQuery(expired_sql);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		}
		book.add(book_display);
		
		expired_table = new JTable();
		expired_table.setPreferredSize(new Dimension(500,600));
		scrollPane_4.setViewportView(expired_table);
		scrollPane_4.setViewportBorder(null);
		expired_table.setModel(DbUtils.resultSetToTableModel(expired_rs));
		expired_table.getColumnModel().getColumn(0).setPreferredWidth(30);
		expired_table.getColumnModel().getColumn(0).setHeaderValue("ID");
		expired_table.getColumnModel().getColumn(1).setPreferredWidth(150);
		expired_table.getColumnModel().getColumn(1).setHeaderValue("Student ID");
		expired_table.getColumnModel().getColumn(2).setPreferredWidth(100);
		expired_table.getColumnModel().getColumn(2).setHeaderValue("Staff ID");
		expired_table.getColumnModel().getColumn(3).setPreferredWidth(80);
		expired_table.getColumnModel().getColumn(3).setHeaderValue("ISBN");
		expired_table.getColumnModel().getColumn(4).setPreferredWidth(200);
		expired_table.getColumnModel().getColumn(4).setHeaderValue("Reserve Date");
		expired_table.getColumnModel().getColumn(5).setPreferredWidth(200);
		expired_table.getColumnModel().getColumn(5).setHeaderValue("Return Date");
		
		
		
		panel_1.add(tabbedPane);
		
	}
}