package model;

public class SinhVien {
private String MASV;
private String HOTEN;
private String NGSINH;
private String PHAI;
private String MAL ;

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
