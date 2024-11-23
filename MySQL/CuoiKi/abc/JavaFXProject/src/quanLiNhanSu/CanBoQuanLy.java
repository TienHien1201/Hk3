package quanLiNhanSu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CanBoQuanLy extends ConNguoi{
	private int namKinhNghiem;

	public CanBoQuanLy(String maNhanVien, String hoVaTen, LocalDate namSinh, String goiTinh, String soDienThoai,
			String daThoiViec, float soGioLamViec, int namKinhNghiem) {
		super(maNhanVien, hoVaTen, namSinh, goiTinh, soDienThoai, daThoiViec, soGioLamViec);
		this.namKinhNghiem = namKinhNghiem;
	}

	public int getNamKinhNghiem() {
		return namKinhNghiem;
	}

	public void setNamKinhNghiem(int namKinhNghiem) {
		this.namKinhNghiem = namKinhNghiem;
	}


	public double tinhLuong() {
		int motGio = 90000;
		return motGio * soGioLamViec;
	}

	public double tinhTongLuongThang() {
		Scanner sc = new Scanner(System.in);
		System.out.println("So ngay lam duoc trong thang nay: ");
		int soNgay = sc.nextInt();
		sc.nextLine();
		
		float heSoLuong = 1.0f;
		if (namKinhNghiem <= 1) {
			heSoLuong = 1.2f;
		}
		else if (namKinhNghiem > 1 && namKinhNghiem <= 3) {
			heSoLuong = 1.3f;
		}
		else if (namKinhNghiem > 3 && namKinhNghiem <= 5) {
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
		return "|"+maNhanVien+"|" + hoVaTen +"|" + Formatted + "|" + goiTinh + "|"+ soDienThoai + "|" + namKinhNghiem + "|"+soGioLamViec+"|"+ daThoiViec+"|";
	}

}
