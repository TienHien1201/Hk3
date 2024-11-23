package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MonThi {
	@Id
	@Column(name = "MaMT")
private String MaMT;
private String TENMT;

@OneToMany(mappedBy = "MonThi", cascade = CascadeType.ALL)
private List<ChuyenNganh> chuyenganh = new ArrayList<ChuyenNganh>()	;


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
