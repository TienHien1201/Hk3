package Conntroller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Khoa;

public class InputKhoa {
	public static Khoa showInputDialog() {
        Khoa khoa = new Khoa();
      
        JTextField txtMAKHOA = new JTextField();
        JTextField txtTENKHOA = new JTextField();
        JTextField txtNAMTL = new JTextField();
        JTextField txtPHONGLV = new JTextField();
        JTextField txtTEL = new JTextField();
        JTextField txtMATRGKHOA = new JTextField();
        
        Object[] message = {
                "Mã Khoa:", txtMAKHOA, 
                "Tên Khoa:", txtTENKHOA,
                "Năm Thành Lập:", txtNAMTL,
                "Phong Lv:", txtPHONGLV,
                "TEl:", txtTEL,
                "Mã Trưởng Khoa:", txtMATRGKHOA
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Nhập thông tin Khoa", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            khoa.setMAKHOA(txtMAKHOA.getText());
            khoa.setTENKHOA(txtTENKHOA.getText());
            khoa.setNAMTL(txtNAMTL.getText());
            khoa.setPHONGLV(txtPHONGLV.getText());
            khoa.setTEL(txtTEL.getText());
            khoa.setMATRGKHOA(txtMATRGKHOA.getText());
            return khoa;
        } else {
            return null;
        }
    }
}
