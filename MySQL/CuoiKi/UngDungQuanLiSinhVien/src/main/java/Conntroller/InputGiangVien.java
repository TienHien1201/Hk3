package Conntroller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.GiangVien;

public class InputGiangVien {
	public static GiangVien showInputDialog() {
        GiangVien giangvien = new GiangVien();
      
        JTextField txtMAGV = new JTextField();
        JTextField txtTENGV = new JTextField();
        JTextField txtSODT = new JTextField();
        JTextField txtMAKHOA = new JTextField();
        
        
        Object[] message = {
                "Mã Giáo Viên:", txtMAGV, 
                "Tên Giáo Viên:", txtTENGV,
                "Số điện thoại:", txtSODT,
                "Mã Khoa:", txtMAKHOA
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Nhập thông tin Giáo Viên", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            giangvien.setMAGV(txtMAGV.getText());
            giangvien.setTENGV(txtTENGV.getText());
            giangvien.setSODT(txtSODT.getText());
            giangvien.setMAKHOA(txtMAKHOA.getText());
            return giangvien;
        } else {
            return null;
        }
    }
}
