package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Zyx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTable table;
	private JTextField textField_11;
	private JTable table_1;
	private JTextField textField_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zyx frame = new Zyx();
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
	public Zyx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1127, 875);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Phân loại");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Hàng thực phẩm");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Hàng điện máy");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Hàng sành sứ");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_2);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(235, 26, 563, 160);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Mã hàng:");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(77, 10, 114, 21);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Tên hàng:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel.setBounds(77, 41, 77, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Số lượng tồn:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(77, 75, 99, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Đơn giá:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(77, 106, 65, 21);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField.setBounds(217, 10, 254, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(217, 45, 254, 19);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(217, 79, 254, 19);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(217, 110, 254, 19);
		panel.add(textField_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tìm kiếm theo tên:");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(77, 137, 133, 21);
		panel.add(lblNewLabel_2_1);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField_11.setColumns(10);
		textField_11.setBounds(217, 141, 254, 19);
		panel.add(textField_11);
		
		table = new JTable();
		table.setBounds(10, 570, 1093, 231);
		getContentPane().add(table);
		
		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setBounds(226, 522, 85, 38);
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Xóa");
		btnNewButton_2_1.setBounds(417, 522, 85, 38);
		btnNewButton_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Sửa");
		btnNewButton_2_1_1.setBounds(321, 522, 85, 38);
		btnNewButton_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		getContentPane().add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("Tìm kiếm");
		btnNewButton_2_1_1_1.setBounds(512, 522, 93, 38);
		btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		getContentPane().add(btnNewButton_2_1_1_1);
		
		JButton btnNewButton_2_1_1_1_1 = new JButton("Tính tổng số lượng");
		btnNewButton_2_1_1_1_1.setBounds(725, 522, 165, 38);
		btnNewButton_2_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		getContentPane().add(btnNewButton_2_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Thuế VAT");
		btnNewButton_1.setBounds(615, 522, 100, 37);
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		getContentPane().add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(235, 189, 563, 111);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(218, 10, 253, 19);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ngày hết hạn:");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(78, 42, 97, 19);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nhà cung cấp:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(78, 71, 97, 21);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày sản xuất:");
		lblNewLabel_3.setBounds(78, 11, 107, 21);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(218, 42, 253, 19);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(218, 75, 253, 19);
		panel_1.add(textField_6);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(235, 296, 563, 71);
		getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(300, 10, 171, 19);
		panel_1_1.add(textField_7);
		
		JLabel lblNewLabel_5_1 = new JLabel("Công suất (kW):");
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_5_1.setBounds(78, 42, 133, 19);
		panel_1_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Thời gian bảo hành (tháng):");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(78, 11, 187, 21);
		panel_1_1.add(lblNewLabel_3_1);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField_8.setColumns(10);
		textField_8.setBounds(300, 42, 171, 19);
		panel_1_1.add(textField_8);
		
		table_1 = new JTable();
		table_1.setBounds(10, 570, 1042, 231);
		getContentPane().add(table_1);
		
		JLabel lblNewLabel_7 = new JLabel("Tổng số lượng");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(295, 442, 100, 38);
		getContentPane().add(lblNewLabel_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(417, 453, 197, 27);
		getContentPane().add(comboBox);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBounds(235, 363, 563, 71);
		getContentPane().add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField_9.setColumns(10);
		textField_9.setBounds(194, 10, 277, 19);
		panel_1_1_1.add(textField_9);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Ngày nhập kho:");
		lblNewLabel_5_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_5_1_1.setBounds(78, 42, 106, 19);
		panel_1_1_1.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Nhà sản xuất:");
		lblNewLabel_3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3_1_1.setBounds(78, 9, 106, 21);
		panel_1_1_1.add(lblNewLabel_3_1_1);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textField_10.setColumns(10);
		textField_10.setBounds(194, 42, 277, 19);
		panel_1_1_1.add(textField_10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(619, 454, 85, 27);
		getContentPane().add(textField_12);
		textField_12.setColumns(10);
	}
}
