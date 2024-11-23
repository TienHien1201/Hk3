package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class DienThoai {
private String MASV;
private String SODT;

@JoinTable(name = "MASV")
private SinhVien sinvien;

@ManyToMany(mappedBy = "DienThoai")
private List<SinhVien> sinhVien = new ArrayList<SinhVien>();

public DienThoai() {
	super();
}

public DienThoai(String mASV, String sODT) {
	super();
	MASV = mASV;
	SODT = sODT;
}

public String getMASV() {
	return MASV;
}

public void setMASV(String mASV) {
	MASV = mASV;
}

public String getSODT() {
	return SODT;
}

public void setSODT(String sODT) {
	SODT = sODT;
}

@Override
public String toString() {
	return "DienThoai [MASV=" + MASV + ", SODT=" + SODT + "]";
}





}
