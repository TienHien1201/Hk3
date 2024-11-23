package quanLiNhanSu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KySu extends ConNguoi{
private String chuyenNhanhDaoTao;

public KySu(String maNhanVien, String hoVaTen, LocalDate namSinh, String goiTinh, String soDienThoai, String daThoiViec,
		float soGioLamViec, String chuyenNhanhDaoTao) {
	super(maNhanVien, hoVaTen, namSinh, goiTinh, soDienThoai, daThoiViec, soGioLamViec);
	this.chuyenNhanhDaoTao = chuyenNhanhDaoTao;
}

public String getChuyenNhanhDaoTao() {
	return chuyenNhanhDaoTao;
}

public void setChuyenNhanhDaoTao(String chuyenNhanhDaoTao) {
	this.chuyenNhanhDaoTao = chuyenNhanhDaoTao;
}

//Phương thức tính lương KySu
public double tinhLuong() {
	float motGio = 70000;
	return soGioLamViec * motGio;
}

public double tinhTongLuongThang() {
	float heSoLuong = 1.5f;
	Scanner sc = new Scanner(System.in);
	System.out.println("So ngay lam duoc trong thang nay: ");
	int soNgay = sc.nextInt();
	sc.nextLine();
	
	double tongLuong = soNgay * tinhLuong() * heSoLuong;

	String formattedLuong = String.format("%.20f", tongLuong);
	return Double.parseDouble(formattedLuong);
}

@Override
public String toString() {
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String Formatted = namSinh.format(formatter);
	return "|"+maNhanVien+"|" + hoVaTen +"|" + Formatted + "|" + goiTinh + "|"+ soDienThoai + "|" + chuyenNhanhDaoTao + "|"+soGioLamViec+"|"+ daThoiViec+"|";
}
	

}
