package quanLiNhanSu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NhanVienPartTime extends ConNguoi{
private int nangSuat;

public NhanVienPartTime(String maNhanVien, String hoVaTen, LocalDate namSinh, String goiTinh, String soDienThoai,
		String daThoiViec, float soGioLamViec, int loaiCongViec) {
	super(maNhanVien, hoVaTen, namSinh, goiTinh, soDienThoai, daThoiViec, soGioLamViec);
	this.nangSuat = loaiCongViec;
}

public int getNangSuat() {
	return nangSuat;
}

public void setNangSuat(int loaiCongViec) {
	this.nangSuat = loaiCongViec;
}

public double tinhLuong() {
	float motGio = 25000;
	return soGioLamViec * motGio;
}

public double tinhTongLuongThang() {
	float heSoLuong = 1.0f;
	Scanner sc = new Scanner(System.in);
	System.out.println("So ngay lam duoc trong thang nay: ");
	int soNgay = sc.nextInt();
	sc.nextLine();
	
	if (nangSuat <= 5) {
		heSoLuong = 1.0f;
	}
	else {
		heSoLuong = 1.2f;
	}
	
	double tongLuong = soNgay * tinhLuong() * heSoLuong;

	String formattedLuong = String.format("%.20f", tongLuong);
	return Double.parseDouble(formattedLuong);
}

@Override
public String toString() {
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String Formatted = namSinh.format(formatter);
	return "|"+maNhanVien+"|" + hoVaTen +"|" + Formatted + "|" + goiTinh + "|"+ soDienThoai + "|" + nangSuat + "|"+soGioLamViec+"|"+ daThoiViec+"|";
}

	
	
}
