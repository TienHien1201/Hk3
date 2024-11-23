package quanLiNhanSu;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DocTapTin {
	private String tenTapTin;

	public DocTapTin(String tenTapTin) {
		super();
		this.tenTapTin = tenTapTin;
	}

	public ArrayList<ConNguoi> docDsConNguoi() {
		ArrayList<ConNguoi> danhSachConNguoi = null;

		try {
			FileInputStream f = new FileInputStream(tenTapTin);
			ObjectInputStream o = new ObjectInputStream(f);
			danhSachConNguoi = (ArrayList<ConNguoi>)o.readObject();

			o.close();
			f.close();

			return danhSachConNguoi;
		} catch (Exception e) {
			return null;
		}
	}
}
