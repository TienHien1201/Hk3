package Conntroller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Thi;

public class InputThi {
	public static Thi showInputDialog() {
        Thi thi = new Thi();
      
        JTextField txtMaMT = new JTextField();
        JTextField txtMaCN = new JTextField();
        Object[] message = {
                "Mã Môn Thi:", txtMaMT, 
                "Mã Chuyên Ngành:", txtMaCN
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Nhập thông tin Thi", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            thi.setMaMT(txtMaMT.getText());
            thi.setMaCN (txtMaCN.getText());
            return thi;
        } else {
            return null;
        }
    }
}
