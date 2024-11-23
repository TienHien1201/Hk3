package Conntroller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.ChuyenNganh;

public class InputChuyenNganh {
    public static ChuyenNganh showInputDialog() {
        // Tạo một đối tượng ChuyenNganh để lưu trữ dữ liệu đầu vào
        ChuyenNganh chuyenNganh = new ChuyenNganh();

        // Tạo các JTextField để người dùng nhập liệu
        JTextField txtMACN = new JTextField();
        JTextField txtTENCN = new JTextField();
        JTextField txtMAGVQL = new JTextField();
        JTextField txtMAKHOA = new JTextField();

        // Tạo một mảng các đối tượng cho thông điệp của JOptionPane
        Object[] message = {
            "Mã Chuyên Ngành:", txtMACN,
            "Tên Chuyên Ngành:", txtTENCN,
            "Mã Giảng Viên Quản Lý:", txtMAGVQL,
            "Mã Khoa:", txtMAKHOA
        };

        // Hiển thị một hộp thoại nhập liệu với các ô văn bản cho người dùng nhập liệu
        // OK_OPTION được trả về nếu người dùng nhấp vào OK, CANCEL_OPTION nếu họ nhấp vào Cancel
        int option = JOptionPane.showConfirmDialog(null, message, "Nhập thông tin Chuyên Ngành", JOptionPane.OK_CANCEL_OPTION);

        // Kiểm tra xem người dùng có nhấp vào OK không
        if (option == JOptionPane.OK_OPTION) {
            // Thiết lập các thuộc tính của ChuyenNganh với dữ liệu đầu vào của người dùng
            chuyenNganh.setMACN(txtMACN.getText());
            chuyenNganh.setTENCN(txtTENCN.getText());
            chuyenNganh.setMAGVQL(txtMAGVQL.getText());
            chuyenNganh.setMAKHOA(txtMAKHOA.getText());

            // Trả về đối tượng ChuyenNganh với dữ liệu đầu vào của người dùng
            return chuyenNganh;
        } else {
            // Trả về null nếu người dùng nhấp vào Cancel hoặc đóng hộp thoại
            return null;
        }
    }
}
