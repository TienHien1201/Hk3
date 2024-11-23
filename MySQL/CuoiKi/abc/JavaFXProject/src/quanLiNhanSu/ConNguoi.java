package quanLiNhanSu;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ConNguoi implements Serializable {

	private static final long serialVersionUID = 2L;
	protected String maNhanVien;
    protected String hoVaTen;
    protected LocalDate namSinh;
    protected String goiTinh;
    protected String soDienThoai;
    protected String daThoiViec;
    protected float soGioLamViec;

	public ConNguoi(String maNhanVien, String hoVaTen, LocalDate namSinh, String goiTinh, String soDienThoai,
			String daThoiViec, float soGioLamViec) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoVaTen = hoVaTen;
		this.namSinh = namSinh;
		this.goiTinh = goiTinh;
		this.soDienThoai = soDienThoai;
		this.daThoiViec = daThoiViec;
		this.soGioLamViec = soGioLamViec;
	}

	public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public LocalDate getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(LocalDate namSinh) {
        this.namSinh = namSinh;
    }

    public String getGoiTinh() {
        return goiTinh;
    }

    public void setGoiTinh(String goiTinh) {
        this.goiTinh = goiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }


    public String getDaThoiViec() {
		return daThoiViec;
	}

	public void setDaThoiViec(String daThoiViec) {
		this.daThoiViec = daThoiViec;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	
	
	public float getSoGioLamViec() {
		return soGioLamViec;
	}

	public void setSoGioLamViec(float soGioLamViec) {
		this.soGioLamViec = soGioLamViec;
	}

	@Override
    public String toString() {
        return "|" + hoVaTen + "|" + namSinh + "|" + goiTinh + "|"
                + soDienThoai + "|" + daThoiViec + "|";
    }
	
	public double tinhTongLuongThang() {
		return 0;
	}
	
}