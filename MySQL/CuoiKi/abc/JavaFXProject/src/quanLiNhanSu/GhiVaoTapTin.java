package quanLiNhanSu;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GhiVaoTapTin {
	private String tenTapTin;
	private ArrayList<ConNguoi> danhSachConNguoi;
	public GhiVaoTapTin(String tenTapTin, ArrayList<ConNguoi> danhSachConNguoi) {
		super();
		this.tenTapTin = tenTapTin;
		this.danhSachConNguoi = danhSachConNguoi;
	}


	public String ghiDsConNguoi() {
		try {
			FileOutputStream f = new FileOutputStream(tenTapTin,true);
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(danhSachConNguoi);

			f.close();
			o.close();
			return "Da luu thanh cong";
		} catch (Exception e) {
			return "Co loi xay ra [01]: " +e.getStackTrace();
		}
	}
}
