package Conntroller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.DienThoai;

public class InputDienThoai {
	public static DienThoai showInputDialog() {
        DienThoai dienthoai = new DienThoai();
      
        JTextField txtMASV = new JTextField();
        JTextField txtSODT = new JTextField();
        
        
        Object[] message = {
                "Mã Sinh Viên:", txtMASV,
                "Số điện thoại:", txtSODT
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Nhập thông tin Điện Thọai", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            dienthoai.setMASV(txtMASV.getText());
            dienthoai.setSODT(txtSODT.getText());
            return dienthoai;
        } else {
            return null;
        }
    }
}
