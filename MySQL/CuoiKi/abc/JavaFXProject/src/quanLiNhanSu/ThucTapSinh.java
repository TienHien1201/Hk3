package quanLiNhanSu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ThucTapSinh extends ConNguoi {
private String daiHoc;
private String chuyenNghanh;



public ThucTapSinh(String maNhanVien, String hoVaTen, LocalDate namSinh, String goiTinh, String soDienThoai,
		String daThoiViec, float soGioLamViec, String daiHoc, String chuyenNghanh) {
	super(maNhanVien, hoVaTen, namSinh, goiTinh, soDienThoai, daThoiViec, soGioLamViec);
	this.daiHoc = daiHoc;
	this.chuyenNghanh = chuyenNghanh;
}
public String getDaiHoc() {
	return daiHoc;
}
public void setDaiHoc(String daiHoc) {
	this.daiHoc = daiHoc;
}
public String getChuyenNghanh() {
	return chuyenNghanh;
}
public void setChuyenNghanh(String chuyenNghanh) {
	this.chuyenNghanh = chuyenNghanh;
}
//Phương thức tính lương KySu
public double tinhLuong() {
	float motGio = 30000;
	return soGioLamViec * motGio;
}

public double tinhTongLuongThang() {
	float heSoLuong = 1.0f;
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
	return  "|"+maNhanVien+"|" + hoVaTen +"|" + Formatted + "|" + goiTinh + "|"+ soDienThoai + "|" + daiHoc + "|" + chuyenNghanh + "|"+soGioLamViec+"|"+daThoiViec +"|";
}


}
