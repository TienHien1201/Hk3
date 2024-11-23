package model;

public class Lop {
private String MAL;
private int SISO;
private String MACN;

public Lop() {
	super();
}

public Lop(String mAL, int sISO, String mACN) {
	super();
	MAL = mAL;
	SISO = sISO;
	MACN = mACN;
}

public String getMAL() {
	return MAL;
}

public void setMAL(String mAL) {
	MAL = mAL;
}

public int getSISO() {
	return SISO;
}

public void setSISO(int sISO) {
	SISO = sISO;
}

public String getMACN() {
	return MACN;
}

public void setMACN(String mACN) {
	MACN = mACN;
}

@Override
public String toString() {
	return "Lop [MAL=" + MAL + ", SISO=" + SISO + ", MACN=" + MACN + "]";
}


}
