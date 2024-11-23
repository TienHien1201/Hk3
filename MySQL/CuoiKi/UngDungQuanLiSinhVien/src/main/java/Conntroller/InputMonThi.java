package Conntroller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.MonThi;

public class InputMonThi {
	public static MonThi showInputDialog() {
        MonThi monthi = new MonThi();
      
        JTextField txtMaMT = new JTextField();
        JTextField txtTENMT = new JTextField();
        
        Object[] message = {
                "Mã Mô Thi:", txtMaMT, 
                "Tên Môn Thi:", txtTENMT
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Nhập thông tin Môn Thi", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            monthi.setMaMT(txtMaMT.getText());
            monthi.setTENMT(txtTENMT.getText());
            return monthi;
        } else {
            return null;
        }
    }
}
