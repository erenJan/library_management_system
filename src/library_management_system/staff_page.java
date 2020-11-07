package library_management_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
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
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.JTable;

public class staff_page extends JFrame {
	private JPanel contentPane;
	private JTextField name;
	private JTextField surname;
	private JTextField email;
	private JTextField phone_number;
	private JPasswordField password;
	private JTextField b_day;
	private JTextField student_id;
	private JTable table;
	private JTable table_1;
	private JTextField delete_id;
	public static int staff_id;
	private JTextField book_name;
	private JTextField book_author;
	private JTextField book_edition;
	private JTextField book_genre;
	private JTextField book_isbn;
	private JTextField delete_book_id;
	/**
	 * Launch the application.
	 */
	public void get_id(int id) {
		staff_id = id;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setPreferredSize(new Dimension(700, 560));
		
JPanel book = new JPanel();
		
		JPanel book_display = new JPanel();
		book_display.setPreferredSize(new Dimension(490,600));
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
		panel_2_1_1_1.add(delete_book);
		
		
		tabbedPane.addTab("BOOKS", book);
		
		
		JPanel summary_page= new JPanel();
		
		tabbedPane.addTab("SUMMARY PAGE", summary_page);
		
		JPanel expired_issues = new JPanel();
		
		tabbedPane.addTab("EXPIRED ISSUES", expired_issues);
		
		
		
		panel_1.add(tabbedPane);
		
	}

	
}
