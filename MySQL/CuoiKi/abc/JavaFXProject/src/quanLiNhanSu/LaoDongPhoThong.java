package quanLiNhanSu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LaoDongPhoThong extends ConNguoi{
	private String bangCap;

	public LaoDongPhoThong(String maNhanVien, String hoVaTen, LocalDate namSinh, String goiTinh, String soDienThoai,
			String daThoiViec, float soGioLamViec, String bangCap) {
		super(maNhanVien, hoVaTen, namSinh, goiTinh, soDienThoai, daThoiViec, soGioLamViec);
		this.bangCap = bangCap;
	}

	public String getBangCap() {
		return bangCap;
	}

	public void setBangCap(String bangCap) {
		this.bangCap = bangCap;
	}

	public double tinhLuong() {
		float motGio = 35000;
		return motGio*soGioLamViec;	
	}

	public double tinhTongLuongThang() {
		Scanner sc = new Scanner(System.in);
		System.out.println("So ngay lam duoc trong thang nay: ");
		int soNgay = sc.nextInt();
		sc.nextLine();
		float heSoLuong = 1.0f;

		if (bangCap.equalsIgnoreCase("Cap 0")) {
			heSoLuong = 1.0f;
		}
		else if (bangCap.equalsIgnoreCase("Cap 2")) {
			heSoLuong = 1.1f;
		}
		else if (bangCap.equalsIgnoreCase("Cap 3")) {
			heSoLuong = 1.3f;
		}
		else if (bangCap.equalsIgnoreCase("Dai hoc")) {
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
		return "|"+maNhanVien+"|" + hoVaTen +"|" + Formatted + "|" + goiTinh + "|"+ soDienThoai + "|" + bangCap + "|"+soGioLamViec+"|"+ daThoiViec+"|";
	}


}
