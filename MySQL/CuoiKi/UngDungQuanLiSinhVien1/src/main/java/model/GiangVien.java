package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class GiangVien {
	@Id
	@Column(name = "mAGV")
private String MAGV;
private String TENGV;
private String SODT;
private String MAKHOA;

@OneToOne
@JoinColumn(name = "MAKHOA")
private Khoa khoa;

//Tạo 1 constructor rỗng để tạo ra 1 dối tượng chưa có thông tin gì 
public GiangVien() {
	super();
}


public GiangVien(String mAGV, String tENGV, String sODT, String mAKHOA) {
	super();

	MAGV = mAGV;
	TENGV = tENGV;
	SODT = sODT;
	MAKHOA = mAKHOA;
}

//Cần get and set để dễ dàng tương tác với dữ liệu
public String getMAGV() {
	return MAGV;
}

public void setMAGV(String mAGV) {
	MAGV = mAGV;
}

public String getTENGV() {
	return TENGV;
}

public void setTENGV(String tENGV) {
	TENGV = tENGV;
}

public String getSODT() {
	return SODT;
}

public void setSODT(String sODT) {
	SODT = sODT;
}

public String getMAKHOA() {
	return MAKHOA;
}

public void setMAKHOA(String mAKHOA) {
	MAKHOA = mAKHOA;
}

@Override
public String toString() {
	return "GiangVien [MAGV=" + MAGV + ", TENGV=" + TENGV + ", SODT=" + SODT + ", MAKHOA=" + MAKHOA + "]";
}



}
