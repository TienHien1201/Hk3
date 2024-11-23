package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class ChuyenNganh {
	@Id
	@Column(name = "MACN")
private String MACN;
private String TENCN;
private String MAGVQL;
private String MAKHOA;

@OneToOne 
@JoinColumn(name = "MAKHOA")
private Khoa khoa;

@OneToOne 
@JoinColumn(name = "MAGVQL")
private GiangVien giangVien;

@OneToMany(mappedBy = "ChuyenNganh", cascade = CascadeType.ALL)
private List<Lop> lop = new ArrayList<Lop>();

@OneToMany(mappedBy = "ChuyenNganh", cascade = CascadeType.ALL)
private List<MonThi> monthi = new ArrayList<MonThi>();


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
