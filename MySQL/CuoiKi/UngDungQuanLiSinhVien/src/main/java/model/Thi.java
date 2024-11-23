package model;

public class Thi {
private String MaMT;
private String MaCN;
public Thi(String maMT, String maCN) {
	super();
	MaMT = maMT;
	MaCN = maCN;
}

public Thi() {
	super();
}

public String getMaMT() {
	return MaMT;
}
public void setMaMT(String maMT) {
	MaMT = maMT;
}
public String getMaCN() {
	return MaCN;
}
public void setMaCN(String maCN) {
	MaCN = maCN;
}

@Override
public String toString() {
	return "Thi [MaMT=" + MaMT + ", MaCN=" + MaCN + "]";
}


}
