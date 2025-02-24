package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SSSS extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SSSS frame = new SSSS();
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
	public SSSS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1109, 833);
		
			JMenuBar bdsMenuBar = new JMenuBar();
			bdsMenuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			setJMenuBar(bdsMenuBar);
			
			JMenu chucNangMenu = new JMenu("Chức Năng");
			chucNangMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			bdsMenuBar.add(chucNangMenu);
			
			JMenuItem gdDatMenuItem = new JMenuItem("Xem Giao Dịch Đất");
			gdDatMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			chucNangMenu.add(gdDatMenuItem);
			
			JMenuItem gdNhaMenuItem = new JMenuItem("Xem Giao Dịch Nhà");
			gdNhaMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			chucNangMenu.add(gdNhaMenuItem);
			
			JMenu troGiupMenu = new JMenu("Trợ Giúp");
			troGiupMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			bdsMenuBar.add(troGiupMenu);
			
			JMenuItem troGiupMenuItem = new JMenuItem("Liên Hệ Admin");
			troGiupMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			troGiupMenu.add(troGiupMenuItem);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel mainPanel = new JPanel();
			mainPanel.setBackground(new Color(255, 255, 255));
			mainPanel.setForeground(new Color(0, 0, 0));
			mainPanel.setBounds(10, 0, 1106, 770);
			contentPane.add(mainPanel);
			mainPanel.setLayout(null);
			
			JPanel inputPanel = new JPanel();
			inputPanel.setLayout(null);
			inputPanel.setBounds(93, 10, 395, 320);
			mainPanel.add(inputPanel);
			
			JLabel dateLabel_1_1 = new JLabel("Ngày Giao Dịch");
			dateLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			dateLabel_1_1.setBounds(10, 55, 108, 24);
			inputPanel.add(dateLabel_1_1);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(133, 55, 145, 24);
			inputPanel.add(textField_3);
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(133, 99, 145, 24);
			inputPanel.add(textField_5);
			
			JLabel donGiaLabel_1_1 = new JLabel("Đơn Giá");
	donGiaLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			donGiaLabel_1_1.setBounds(10, 99, 108, 24);
			inputPanel.add(donGiaLabel_1_1);
			
			JLabel loaiDatLabel_1 = new JLabel("Loại Đất");
			loaiDatLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			loaiDatLabel_1.setBounds(10, 147, 108, 24);
			inputPanel.add(loaiDatLabel_1);
			
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(133, 276, 145, 24);
			inputPanel.add(textField_6);
			
			JLabel dienTichLabel_1 = new JLabel("Diện Tích");
			dienTichLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			dienTichLabel_1.setBounds(10, 276, 108, 24);
			inputPanel.add(dienTichLabel_1);
			
			JComboBox loaiDatcomboBox_1 = new JComboBox();
			loaiDatcomboBox_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			loaiDatcomboBox_1.setBounds(133, 146, 145, 24);
			inputPanel.add(loaiDatcomboBox_1);
			
			JLabel loaiGDLabel_1 = new JLabel("Loại Giao Dịch");
			loaiGDLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			loaiGDLabel_1.setBounds(10, 10, 108, 24);
			inputPanel.add(loaiGDLabel_1);
			
			JComboBox loaiGDcomboBox_1 = new JComboBox();
			loaiGDcomboBox_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			loaiGDcomboBox_1.setBounds(133, 9, 145, 24);
			inputPanel.add(loaiGDcomboBox_1);
			
			JLabel loaiNhaLabel_1 = new JLabel("Loại Nhà");
			loaiNhaLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			loaiNhaLabel_1.setBounds(10, 194, 108, 24);
			inputPanel.add(loaiNhaLabel_1);
			
			JComboBox loaiNhaBox_1 = new JComboBox();
			loaiNhaBox_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			loaiNhaBox_1.setBounds(133, 194, 145, 24);
			inputPanel.add(loaiNhaBox_1);
			
			JLabel diaChiLabel_1 = new JLabel("Địa Chỉ");
			diaChiLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			diaChiLabel_1.setBounds(10, 235, 108, 24);
			inputPanel.add(diaChiLabel_1);
			
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(133, 235, 145, 24);
			inputPanel.add(textField_7);
			
			JPanel tablePanel = new JPanel();
			tablePanel.setBounds(10, 340, 1086, 264);
			mainPanel.add(tablePanel);
			
			table = new JTable();
			tablePanel.add(table);
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
				}
			));
			table.setRowSelectionAllowed(false);
			table.setSurrendersFocusOnKeystroke(true);
			
			JButton btnNewButton = new JButton("Thêm ");
			btnNewButton.setBounds(302, 697, 85, 63);
			mainPanel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Xóa");
			btnNewButton_1.setBounds(492, 697, 85, 63);
			mainPanel.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Sửa");
			btnNewButton_2.setBounds(397, 697, 85, 63);
			mainPanel.add(btnNewButton_2);
			
			JButton btnNewButton_2_1 = new JButton("Tìm Kiếm");
			btnNewButton_2_1.setBounds(845, 79, 109, 53);
			mainPanel.add(btnNewButton_2_1);
			
			JButton btnNewButton_2_1_1 = new JButton("Xuất");
			btnNewButton_2_1_1.setBounds(587, 697, 103, 63);
			mainPanel.add(btnNewButton_2_1_1);
			
			JButton btnNewButton_2_1_1_1 = new JButton("Tính tổng");
			btnNewButton_2_1_1_1.setBounds(845, 227, 103, 53);
			mainPanel.add(btnNewButton_2_1_1_1);
			
			JButton btnNewButton_2_1_2 = new JButton("Tính trung bình");
			btnNewButton_2_1_2.setBounds(845, 154, 103, 52);
			mainPanel.add(btnNewButton_2_1_2);
			
			textField = new JTextField();
			textField.setBounds(559, 79, 239, 52);
			mainPanel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(559, 155, 239, 51);
			mainPanel.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(559, 227, 239, 52);
			mainPanel.add(textField_2);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(0, 0, 72, 132);
			mainPanel.add(lblNewLabel);
	}
}
