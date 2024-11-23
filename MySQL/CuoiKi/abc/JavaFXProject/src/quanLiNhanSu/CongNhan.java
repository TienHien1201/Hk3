package quanLiNhanSu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CongNhan extends ConNguoi {
private String capBac;

public CongNhan(String maNhanVien, String hoVaTen, LocalDate namSinh, String goiTinh, String soDienThoai, String daThoiViec,
		float soGioLamViec, String capBac) {
	super(maNhanVien, hoVaTen, namSinh, goiTinh, soDienThoai, daThoiViec, soGioLamViec);
	this.capBac = capBac;
}

public String getCapBac() {
	return capBac;
}

public void setCapBac(String capBac) {
	this.capBac = capBac;
}

//Phương thức tính lương KySu
public double tinhLuong() {
	float motGio = 30000;
	return soGioLamViec * motGio;
	
	
}

public double tinhTongLuongThang() {
	Scanner sc = new Scanner(System.in);
	System.out.println("So ngay lam duoc trong thang nay: ");
	int soNgay = sc.nextInt();
	sc.nextLine();
	float heSoLuong = 1.0f;
	
	if (capBac.equalsIgnoreCase("Bac 1")) {
		heSoLuong = 1.0f;
		
	}else if (capBac.equalsIgnoreCase("Bac 2")) {
		heSoLuong = 1.2f;
		
	}else if (capBac.equalsIgnoreCase("Bac 3")) {
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
	return "|"+maNhanVien+"|" + hoVaTen +"|" + Formatted + "|" + goiTinh + "|"+ soDienThoai + "|" + capBac + "|"+soGioLamViec+"|"+daThoiViec +"|";
}





}
