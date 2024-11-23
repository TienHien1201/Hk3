package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import dao.DataAccessObjectInterface;
import model.ChuyenNganh;
import model.DiaChi;
import model.DiemThi;
import model.DienThoai;
import model.GiangVien;
import model.Khoa;
import model.Lop;
import model.MonThi;
import model.SinhVien;
import model.Thi;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conntroller.EventQLSV;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;


public class TableView extends JFrame {
	private static final long serialVersionUID = 1L;

DataAccessObjectInterface<ChuyenNganh> chuyennganh ;	
DataAccessObjectInterface<DiaChi> diachi  ;
DataAccessObjectInterface<DiemThi> diemthi ;
DataAccessObjectInterface<DienThoai>dienthoai ;	
DataAccessObjectInterface<GiangVien> giangvien  ;
DataAccessObjectInterface<Khoa> khoa  ;	
DataAccessObjectInterface<Lop> lop ;
DataAccessObjectInterface<MonThi> monthi ;		
DataAccessObjectInterface<SinhVien> sinhvien ;	
DataAccessObjectInterface<Thi> thi ;	
private JTable table;
private JTextField textFieldInputSQL;





	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableView frame = new TableView();
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
	public TableView() {
		setBackground(new Color(255, 255, 255));
		setType(Type.POPUP);
		setTitle("AppStudent");
		getContentPane().setBackground(new Color(0, 128, 192));
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 596);
		
		ActionListener action = new EventQLSV(this, textFieldInputSQL, table);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(192, 192, 192));
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setForeground(new Color(0, 0, 0));
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuFile.add(menuOpen);
		
		JMenuItem menuClose = new JMenuItem("Close");
		menuFile.add(menuClose);
		
		JMenuItem exitMenu = new JMenuItem("Exit");
		menuFile.add(exitMenu);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.setForeground(new Color(0, 0, 0));
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(menuAbout);
		
		JMenuItem aboutMeMenu = new JMenuItem("About Me");
		menuAbout.add(aboutMeMenu);
		getContentPane().setLayout(null);
		
		JLabel TruyVanLabel = new JLabel("Hiển thị câu truy vấn");
		TruyVanLabel.setForeground(new Color(128, 0, 0));
		TruyVanLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		TruyVanLabel.setBounds(10, 23, 168, 32);
		getContentPane().add(TruyVanLabel);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox_1.setBounds(10, 23, 168, 34);
		getContentPane().add(verticalBox_1);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		
		
		
		JScrollPane scrollPane =  new JScrollPane(table);
		scrollPane.setBounds(10, 54, 620, 300);
		getContentPane().add(scrollPane);
		
		JButton InsertButton = new JButton("Insert");
		InsertButton.setBackground(new Color(128, 128, 128));
		InsertButton.setForeground(new Color(128, 0, 0));
		InsertButton.addActionListener(action);
		InsertButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		InsertButton.setBounds(10, 376, 156, 39);
		getContentPane().add(InsertButton);
		
		JButton UpdateButton = new JButton("Update");
		UpdateButton.setBackground(new Color(128, 128, 128));
		UpdateButton.setForeground(new Color(128, 0, 0));
		UpdateButton.addActionListener(action);
		UpdateButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		UpdateButton.setBounds(251, 376, 156, 39);
		getContentPane().add(UpdateButton);
		
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.setBackground(new Color(128, 128, 128));
		DeleteButton.setForeground(new Color(128, 0, 0));
		DeleteButton.addActionListener(action);
		DeleteButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		DeleteButton.setBounds(474, 376, 156, 39);
		getContentPane().add(DeleteButton);
		
		JLabel InputSqlLable = new JLabel("InputQuery");
		InputSqlLable.setForeground(new Color(128, 0, 0));
		InputSqlLable.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		InputSqlLable.setBounds(10, 459, 80, 25);
		getContentPane().add(InputSqlLable);
		
		JButton QueryButton = new JButton("Query");
		
		QueryButton.setForeground(new Color(128, 0, 0));
		QueryButton.addActionListener(action);
		QueryButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		QueryButton.setBounds(316, 486, 80, 32);
		getContentPane().add(QueryButton);
	
		
		textFieldInputSQL = new JTextField();
		textFieldInputSQL.setBounds(10, 486, 308, 32);
		getContentPane().add(textFieldInputSQL);
		textFieldInputSQL.setColumns(10);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		verticalBox.setBounds(10, 459, 80, 25);
		getContentPane().add(verticalBox);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(10, 364, 620, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(192, 192, 192));
		separator_1.setBounds(10, 447, 620, 2);
		getContentPane().add(separator_1);
		
		
		this.setVisible(true);
	}

	 // Thêm phương thức getTable
    public JTable getTable() {
        return table;
    }

    // Thêm phương thức getTextFieldInputSQL
    public JTextField getTextFieldInputSQL() {
        return textFieldInputSQL;
    }
	}


