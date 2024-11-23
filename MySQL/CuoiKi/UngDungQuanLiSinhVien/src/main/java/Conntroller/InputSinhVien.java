package Conntroller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.SinhVien;

public class InputSinhVien {
	public static SinhVien showInputDialog() {
        SinhVien sinhvien = new SinhVien();
      
        JTextField txtMASV = new JTextField();
        JTextField txtTENSV = new JTextField();
        JTextField txtNGSINH = new JTextField();
        JTextField txtPHAI = new JTextField();
        JTextField txtMAL = new JTextField();
        
        Object[] message = {
                "Mã Sinh Viên:", txtMASV, 
                "Tên Sinh Viên:", txtTENSV,
                "Ngày Sinh:", txtNGSINH,
                "Phái:", txtPHAI,
                "Mã Lớp:", txtMAL
                
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Nhập thông tin Sinh Viên", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            sinhvien.setMASV(txtMASV.getText());
            sinhvien.setHOTEN (txtTENSV.getText());
            sinhvien.setNGSINH(txtNGSINH.getText());
            sinhvien.setPHAI(txtPHAI.getText());
            sinhvien.setMAL(txtMAL.getText());
            return sinhvien;
        } else {
            return null;
        }
    }
}