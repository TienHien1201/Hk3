package Conntroller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.DiemThi;

public class InputDiemThi {
	public static DiemThi showInputDialog() {
        DiemThi diemthi = new DiemThi();
      
        JTextField txtMASV = new JTextField();
        JTextField txtMAMT = new JTextField();
        JTextField txtDIEM = new JTextField();
        JTextField txtGHICHU = new JTextField();
        
        
        Object[] message = {
                "Mã Sinh Viên:", txtMASV,
                "Mã Môn Thi:", txtMAMT,
                "Điểm:", txtDIEM,
                "Ghi Chú:", txtGHICHU
               
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Nhập thông tin Điểm Thi", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            diemthi.setMASV(txtMASV.getText());
            diemthi.setMAMT(txtMAMT.getText());
            String diemString = txtDIEM.getText();
            int diem = Integer.parseInt(diemString);
            diemthi.setDIEM(diem);
            diemthi.setGHICHU(txtGHICHU.getText());
            return diemthi;
        } else {
            return null;
        }
    }
}
