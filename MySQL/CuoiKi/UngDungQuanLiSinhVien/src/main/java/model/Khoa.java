package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;





@Entity/*Đây là từ khóa để khai báo 1 đối tượng sẽ đc ánh xạ xuống cơ sở dữ liệu*/
public class Khoa {
@Id//id là khóa chính id để trên thuộc tính nào thì thuộc tính đó là khóa chính
private String MAKHOA;
private String TENKHOA;
private String NAMTL;
private String PHONGLV;
private String TEL;
private String MATRGKHOA;


@OneToMany(mappedBy = "Khoa", cascade = CascadeType.ALL)
private List<ChuyenNganh> chuyenNganh = new ArrayList<ChuyenNganh>();

@OneToMany(mappedBy = "Khoa", cascade = CascadeType.ALL)
private List<GiangVien> giangVien = new ArrayList<GiangVien>();




//Tạo 1 constructor rỗng để tạo ra 1 dối tượng chưa có thông tin gì 
public Khoa() {
	super();
}


public Khoa(String string, String tENKHOA, String nAMTL, String pHONGLV, String tEL, String mATRGKHOA) {
	super();
	
    
	MAKHOA = string;
	TENKHOA = tENKHOA;
	NAMTL = nAMTL;
	PHONGLV = pHONGLV;
	TEL = tEL;
	MATRGKHOA = mATRGKHOA;
}



public String getMAKHOA() {
	return MAKHOA;
}

public void setMAKHOA(String mAKHOA) {
	MAKHOA = mAKHOA;
}



public String getTENKHOA() {
	return TENKHOA;
}



public void setTENKHOA(String tENKHOA) {
	TENKHOA = tENKHOA;
}



public String getNAMTL() {
	return NAMTL;
}



public void setNAMTL(String nAMTL) {
	NAMTL = nAMTL;
}



public String getPHONGLV() {
	return PHONGLV;
}



public void setPHONGLV(String pHONGLV) {
	PHONGLV = pHONGLV;
}



public String getTEL() {
	return TEL;
}



public void setTEL(String tEL) {
	TEL = tEL;
}



public String getMATRGKHOA() {
	return MATRGKHOA;
}



public void setMATRGKHOA(String mATRGKHOA) {
	MATRGKHOA = mATRGKHOA;
}


@Override
public String toString() {
	return "Khoa [MAKHOA=" + MAKHOA + ", TENKHOA=" + TENKHOA + ", NAMTL=" + NAMTL + ", PHONGLV=" + PHONGLV + ", TEL="
			+ TEL + ", MATRGKHOA=" + MATRGKHOA + "]";
}

}
