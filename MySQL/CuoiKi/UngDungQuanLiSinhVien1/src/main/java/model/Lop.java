package model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Lop {
	
	@Id
	@Column(name = "MAL")
private String MAL;
private int SISO;
private String MACN;

@OneToOne
@JoinColumn(name = "MACN")
private ChuyenNganh chuyennganh;
 
@OneToMany(mappedBy = "Lop", cascade = CascadeType.ALL)
private List<SinhVien> sinhvien = new ArrayList<SinhVien>();

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
