package Conntroller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.DiaChi;

public class InputDiaChi {
	 public static DiaChi showInputDialog() {
	        DiaChi diachi = new DiaChi();
	      
	        JTextField txtMASV = new JTextField();
	        JTextField txtSONhA = new JTextField();
	        JTextField txtDUONG = new JTextField();
	        JTextField txtQUAN = new JTextField();
	        JTextField txtTHANHPHO = new JTextField();
	        
	        Object[] message = {
	                "Mã Sinh Viên:", txtMASV,
	                "Tên Số Nhà:", txtSONhA,
	                "Đường:", txtDUONG,
	                "Quận:", txtQUAN,
	                "Thành Phố:", txtTHANHPHO
	        };

	        int option = JOptionPane.showConfirmDialog(null, message, "Nhập thông tin Địa Chỉ", JOptionPane.OK_CANCEL_OPTION);

	        if (option == JOptionPane.OK_OPTION) {
	            diachi.setMASV(txtMASV.getText());
	            diachi.setSONhA(txtSONhA.getText());
	            diachi.setDUONG(txtDUONG.getText());
	            diachi.setQUAN(txtQUAN.getText());
	            diachi.setTHANHPHO(txtTHANHPHO.getText());
	            return diachi;
	        } else {
	            return null;
	        }
	    }
}
