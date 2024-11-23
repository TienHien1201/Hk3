package model;

public class MonThi {
private String MaMT;
private String TENMT;

public MonThi() {
	super();
}

public MonThi(String maMT, String tENMT) {
	super();
	MaMT = maMT;
	TENMT = tENMT;
}

public String getMaMT() {
	return MaMT;
}

public void setMaMT(String maMT) {
	MaMT = maMT;
}

public String getTENMT() {
	return TENMT;
}

public void setMaCN(String tENMT) {
	TENMT = tENMT;
}

@Override
public String toString() {
	return "MonThi [MaMT=" + MaMT + ", TENMT=" + TENMT + "]";
}



}
