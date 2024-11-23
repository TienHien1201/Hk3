package quanLiNhanSu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NhanVien extends ConNguoi{
private String conViecChinh;






public NhanVien(String maNhanVien, String hoVaTen, LocalDate namSinh, String goiTinh, String soDienThoai, String daThoiViec,
		float soGioLamViec, String conViecChinh) {
	super(maNhanVien, hoVaTen, namSinh, goiTinh, soDienThoai, daThoiViec, soGioLamViec);
	this.conViecChinh = conViecChinh;
}

public String getConViecChinh() {
	return conViecChinh;
}

public void setConViecChinh(String conViecChinh) {
	this.conViecChinh = conViecChinh;
}


public double tinhLuong() {
	float motGio = 33000;
	return motGio*soGioLamViec;	
}

public double tinhTongLuongThang() {
	Scanner sc = new Scanner(System.in);
	System.out.println("So ngay lam duoc trong thang nay: ");
	int soNgay = sc.nextInt();
	sc.nextLine();
	float heSoLuong = 1.0f;
	
	if (conViecChinh.equalsIgnoreCase("Lao dong chan tay")) {
		heSoLuong = 1.2f;
	}
	else if (conViecChinh.equalsIgnoreCase("Lao dong tri oc")) {
		heSoLuong = 1.5f;
	}
	
	double tongLuong = soNgay * tinhLuong() * heSoLuong;

	String formattedLuong = String.format("%.20f", tongLuong);
	return Double.parseDouble(formattedLuong);
	
}

@Override
public String toString() {
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String Formatted = namSinh.format(formatter);
	 return "|"+maNhanVien+"|" + hoVaTen +"|" + Formatted + "|" + goiTinh + "|"+ soDienThoai + "|" + conViecChinh + "|"+soGioLamViec+"|"+daThoiViec +"|";
}


}
