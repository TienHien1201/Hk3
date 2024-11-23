package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SinhVien {
	@Id
	@Column(name = "MASV")
private String MASV;
private String HOTEN;
private String NGSINH;
private String PHAI;
private String MAL ;

@OneToOne
@JoinColumn(name = "MAL")
private Lop lop;

@OneToMany(mappedBy = "SinhVien", cascade = CascadeType.ALL)
private List<MonThi> monthi = new ArrayList<MonThi>();

@ManyToMany
@JoinTable(
        name = "DiaChi",
        joinColumns = @JoinColumn(name = "MASV"),
        inverseJoinColumns = @JoinColumn(name = "MASV")
)
private List<DiaChi> diachi = new ArrayList<DiaChi>();

@ManyToMany()
@JoinTable(
        name = "DienThoai",
        joinColumns = @JoinColumn(name = "MASV"),
        inverseJoinColumns = @JoinColumn(name = "MASV")
)
private List<DienThoai> dienthoai = new ArrayList<DienThoai>();

public SinhVien() {
	super();
}

public SinhVien(String mASV, String hOTEN, String nGSINH, String pHAI, String mAL) {
	super();
	MASV = mASV;
	HOTEN = hOTEN;
	NGSINH = nGSINH;
	PHAI = pHAI;
	MAL = mAL;
}

public String getMASV() {
	return MASV;
}

public void setMASV(String mASV) {
	MASV = mASV;
}

public String getHOTEN() {
	return HOTEN;
}

public void setHOTEN(String hOTEN) {
	HOTEN = hOTEN;
}

public String getNGSINH() {
	return NGSINH;
}

public void setNGSINH(String nGSINH) {
	NGSINH = nGSINH;
}

public String getPHAI() {
	return PHAI;
}

public void setPHAI(String pHAI) {
	PHAI = pHAI;
}

public String getMAL() {
	return MAL;
}

public void setMAL(String mAL) {
	MAL = mAL;
}

@Override
public String toString() {
	return "SinhVien [MASV=" + MASV + ", HOTEN=" + HOTEN + ", NGSINH=" + NGSINH + ", PHAI=" + PHAI + ", MAL=" + MAL
			+ "]";
}


}
