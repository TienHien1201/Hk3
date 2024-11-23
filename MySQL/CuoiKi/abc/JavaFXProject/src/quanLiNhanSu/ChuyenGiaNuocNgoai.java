package quanLiNhanSu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ChuyenGiaNuocNgoai extends ConNguoi {
	private String chuyenNghanh; 
    private int thamNien;
	private String quocTich;
	private String hanViSa;

	public ChuyenGiaNuocNgoai(String maNhanVien, String hoVaTen, LocalDate namSinh, String goiTinh, String soDienThoai,
			String daThoiViec, float soGioLamViec, String chuyenNghanh, int thamNien, String quocTich, String hanViSa) {
		super(maNhanVien, hoVaTen, namSinh, goiTinh, soDienThoai, daThoiViec, soGioLamViec);
		this.chuyenNghanh = chuyenNghanh;
		this.thamNien = thamNien;
		this.quocTich = quocTich;
		this.hanViSa = hanViSa;
	}
	public String getQuocTich() {
		return quocTich;
	}
	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}
	public String getHanViSa() {
		return hanViSa;
	}
	public void setHanViSa(String hanViSa) {
		this.hanViSa = hanViSa;
	}
	public int getThamNien() {
		return thamNien;
	}
	public void setThamNien(int thamNien) {
		this.thamNien = thamNien;
	}
	public String getChuyenNghanh() {
		return chuyenNghanh;
	}
	public void setChuyenNghanh(String chuyenNghanh) {
		this.chuyenNghanh = chuyenNghanh;
	}

	public double tinhLuong() {
		int motGio = 110000;
		return motGio * soGioLamViec;
	}

	public double tinhTongLuongThang() {
		Scanner sc = new Scanner(System.in);
		System.out.println("So ngay lam duoc trong thang nay: ");
		int soNgay = sc.nextInt();
		sc.nextLine();
		float heSoLuong = 1.0f;
if (thamNien <= 1) {
	heSoLuong = 1.2f;
}
else if (thamNien >1 && thamNien <= 3) {
	heSoLuong = 1.3f;
}
else if (thamNien > 3 && thamNien <= 5) {
	heSoLuong = 1.5f;
}
else {
	heSoLuong = 2.0f;
}
double tongLuong = soNgay * tinhLuong() * heSoLuong;

String formattedLuong = String.format("%.20f", tongLuong);
return Double.parseDouble(formattedLuong);
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String Formatted = namSinh.format(formatter);
		return "|"+maNhanVien+"|" + hoVaTen +"|" + Formatted + "|" + goiTinh + "|"+ soDienThoai + "|" + quocTich+ "|"+hanViSa +"|"+chuyenNghanh +"|"+soGioLamViec+"|"+daThoiViec +"|";
	}


}
