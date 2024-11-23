package model;

public class ChuyenNganh {
private String MACN;
private String TENCN;
private String MAGVQL;
private String MAKHOA;

public ChuyenNganh() {
	super();
}

public ChuyenNganh(String mACN, String tENCN, String mAGVQL, String mAKHOA) {
	super();
	MACN = mACN;
	TENCN = tENCN;
	MAGVQL = mAGVQL;
	MAKHOA = mAKHOA;
}

public String getMACN() {
	return MACN;
}

public void setMACN(String mACN) {
	MACN = mACN;
}

public String getTENCN() {
	return TENCN;
}

public void setTENCN(String tENCN) {
	TENCN = tENCN;
}

public String getMAGVQL() {
	return MAGVQL;
}

public void setMAGVQL(String mAGVQL) {
	MAGVQL = mAGVQL;
}

public String getMAKHOA() {
	return MAKHOA;
}

public void setMAKHOA(String mAKHOA) {
	MAKHOA = mAKHOA;
}

@Override
public String toString() {
	return "ChuyenNganh [MACN=" + MACN + ", TENCN=" + TENCN + ", MAGVQL=" + MAGVQL + ", MAKHOA=" + MAKHOA + "]";
}






}
