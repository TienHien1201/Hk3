package model;

public class DiemThi {
	private String MASV ;
	private String MAMT;
	private int DIEM;
	private String GHICHU;
	
	public DiemThi() {
		super();
	}

    public DiemThi(String mASV, String mAMT, int dIEM, String gHICHU) {
		super();
		MASV = mASV;
		MAMT = mAMT;
		DIEM = dIEM;
		GHICHU = gHICHU;
	}

	public String getMASV() {
		return MASV;
	}

	public void setMASV(String mASV) {
		MASV = mASV;
	}

	public String getMAMT() {
		return MAMT;
	}

	public void setMAMT(String mAMT) {
		MAMT = mAMT;
	}

	public int getDIEM() {
		return DIEM;
	}

	public void setDIEM(int dIEM) {
		DIEM = dIEM;
	}

	public String getGHICHU() {
		return GHICHU;
	}

	public void setGHICHU(String gHICHU) {
		GHICHU = gHICHU;
	}

	@Override
	public String toString() {
		return "DiemThi [MASV=" + MASV + ", MAMT=" + MAMT + ", DIEM=" + DIEM + ", GHICHU=" + GHICHU + "]";
	}
	
    
	
    
	
}
