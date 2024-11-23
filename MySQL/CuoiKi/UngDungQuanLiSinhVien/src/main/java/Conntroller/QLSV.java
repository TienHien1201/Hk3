package Conntroller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Myconnector.JDBCUnitl;


public class QLSV extends javax.swing.JPanel {

	public QLSV() {
		try {
			getComponents();
			
			//lấy dữ liệu từ bảng khoa trong MySql
			String selectKhoa =  "SELECT * FROM quanlythongtinsinhvien.khoa";
			
			//Gọi hàm thực thi câu lệnh select
			ResultSet rs = JDBCUnitl.executeQuery(selectKhoa);
			
			//Dùng vòng lặp để lấy dữ liệu từ Resultset
			while (rs.next()) {/*Next là 1 phương thức đi tới ở trong một đối tượng ResultSet tức nếu cần
				dự liệu thì nó sẽ next tới lấy dữ liệu ra*/
					String MAKHOA = rs.getString("MAKHOA");
					String TENKHOA = rs.getString("TENKHOA");
					String NAMTL = rs.getString("NAMTL");
					String PHONGLV = rs.getString("PHONGLV");
					String TEL = rs.getString("TEL");
					String MATRGKHOA = rs.getString("MATRGKHOA");
}
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(new JFrame(), "Lỗi lấy dữ liệu");
		}
	}
	
}
