package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Thi {
	@Id
	@Column(name = "MaMT")
private String MaMT;
	@Id
	@Column(name = "MaCN")
private String MaCN;
	
public Thi() {
	super();
}

public Thi(String maMT, String maCN) {
	super();
	MaMT = maMT;
	MaCN = maCN;
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
