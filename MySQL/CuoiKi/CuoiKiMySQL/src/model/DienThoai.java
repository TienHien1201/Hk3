package model;

public class DienThoai {
private String MASV;
private String SODT;

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
