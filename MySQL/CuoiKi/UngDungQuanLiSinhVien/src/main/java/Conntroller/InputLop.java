package Conntroller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Lop;
public class InputLop {
	public static Lop showInputDialog() {
        Lop lop = new Lop();
      
        JTextField txtMAL = new JTextField();
        JTextField txtSISO = new JTextField();
        JTextField txtMACN = new JTextField();
        
        Object[] message = {
                "Mã Lớp:", txtMAL, 
                "Sỉ Số:", txtSISO,
                "Mã Chuyên Nghành:", txtMACN
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Nhập thông tin Lớp", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            lop.setMAL(txtMAL.getText());
            String sisostring = txtSISO.getText();
            int SISO = Integer.parseInt(sisostring);
            lop.setSISO(SISO);
            lop.setMACN(txtMACN.getText());
            return lop;
        } else {
            return null;
        }
    }
}
