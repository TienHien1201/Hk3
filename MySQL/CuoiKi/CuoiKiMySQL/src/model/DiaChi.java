package model;

public class DiaChi {
private String MASV;
private String SONhA;
private String DUONG;
private String QUAN;
private String THANHPHO;

public DiaChi() {
	super();
}

public DiaChi(String mASV, String sONhA, String dUONG, String qUAN, String tHANHPHO) {
	super();
	MASV = mASV;
	SONhA = sONhA;
	DUONG = dUONG;
	QUAN = qUAN;
	THANHPHO = tHANHPHO;
}

public String getMASV() {
	return MASV;
}

public void setMASV(String mASV) {
	MASV = mASV;
}

public String getSONhA() {
	return SONhA;
}

public void setSONhA(String sONhA) {
	SONhA = sONhA;
}

public String getDUONG() {
	return DUONG;
}

public void setDUONG(String dUONG) {
	DUONG = dUONG;
}

public String getQUAN() {
	return QUAN;
}

public void setQUAN(String qUAN) {
	QUAN = qUAN;
}

public String getTHANHPHO() {
	return THANHPHO;
}

public void setTHANHPHO(String tHANHPHO) {
	THANHPHO = tHANHPHO;
}

@Override
public String toString() {
	return "DiaChi [MASV=" + MASV + ", SONhA=" + SONhA + ", DUONG=" + DUONG + ", QUAN=" + QUAN + ", THANHPHO="
			+ THANHPHO + "]";
}




}
