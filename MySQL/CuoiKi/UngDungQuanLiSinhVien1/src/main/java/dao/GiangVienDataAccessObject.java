package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Myconnector.JDBCUnitl;
import model.GiangVien;

public class GiangVienDataAccessObject implements DataAccessObjectInterface<GiangVien> {

	 public static GiangVienDataAccessObject getInstance() {
			return new GiangVienDataAccessObject();
		}
	
	@Override
	public int Delete(GiangVien t) {
		int ketqua = 0;
		try {
	
			Connection c = JDBCUnitl.getConnection();
		
			String sql = "DELETE from GiangVien " 
					   + "WHERE MAGV = ?";	
		   	PreparedStatement giangvien =  c.prepareStatement(sql);
			giangvien.setString(1, t.getMAGV());
			ketqua = giangvien.executeUpdate();
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println("Co "+ ketqua+ " Dong bi thay doi!");
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketqua;
	}

	@Override
	public int Insert(GiangVien t) {
		int ketqua = 0;

		try {
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "INSERT INTO GiangVien (MAGV, TENGV, SODT, MAKHOA)" 
				       + " VALUES (?,?,?,?)";
			PreparedStatement giangvien =  c.prepareStatement(sql);
			giangvien.setString(1, t.getMAGV());
			giangvien.setString(2, t.getTENGV());
			giangvien.setString(3, t.getSODT());
			giangvien.setString(4, t.getMAKHOA());
			
		   ketqua = giangvien.executeUpdate();
			 
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println("Co "+ ketqua+ " Dong bi thay doi!");
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ketqua;
	}

	@Override
	public int Uppdate(GiangVien t) {
		int ketqua = 0;
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "UPDATE GiangVien " 
				       + " SET " 
					   + " MAGV =?,"
					   + "TENGV =?,"
					   + "SODT =?,"
					   + "MAKHOA =?"
					   + "WHERE MAGV = ?";
			PreparedStatement giangvien =  c.prepareStatement(sql);
			giangvien.setString(1, t.getMAGV());
			giangvien.setString(2, t.getTENGV());
			giangvien.setString(3, t.getSODT());
			giangvien.setString(4, t.getMAKHOA());
			giangvien.setString(5, t.getMAGV());
			
			ketqua = giangvien.executeUpdate();
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println("Co "+ ketqua+ " Dong bi thay doi!");
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketqua;
	}

	@Override
	public ArrayList<GiangVien> selecALL() {
		ArrayList<GiangVien> ketqua = new ArrayList<GiangVien>();
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM GiangVien " ;
			PreparedStatement GiangVien =  c.prepareStatement(sql);
			
            System.out.println(sql);
			ResultSet rs = GiangVien.executeQuery();
			while (rs.next()) {
				String MAGV = rs.getString("MAGV");
				String TENGV = rs.getString("TENGV");
				String SODT = rs.getString("SODT");
				String MAKHOA = rs.getString("MAKHOA");
			
				GiangVien giangvien = new GiangVien(MAGV, TENGV, SODT, MAKHOA);//Tạo ra 1 đối tượng khoa
				ketqua.add(giangvien);
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<GiangVien> selecByCondition(String condition) {
		ArrayList<GiangVien> ketqua = new ArrayList<GiangVien>();
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM GiangVien where "+ condition ;
			PreparedStatement GiangVien =  c.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = GiangVien.executeQuery();
			while (rs.next()) {
				String MAGV = rs.getString("MAGV");
				String TENGV = rs.getString("TENGV");
				String SODT = rs.getString("SODT");
				String MAKHOA = rs.getString("MAKHOA");
			
			
				GiangVien giangvien = new GiangVien(MAGV, TENGV, SODT, MAKHOA);//Tạo ra 1 đối tượng khoa
				ketqua.add(giangvien);
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
		
	}

	@Override
	public GiangVien selectById(GiangVien t) {
		GiangVien ketqua = null;
		try {
	
			
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM GiangVien where MAGV =?";
			PreparedStatement GiangVien =  c.prepareStatement(sql);
			GiangVien.setString(1, t.getMAGV());
			
			System.out.println(sql);
			ResultSet rs = GiangVien.executeQuery();
			 
			while (rs.next()) {
				String MAGV = rs.getString("MAGV");
				String TENGV = rs.getString("TENGV");
				String SODT = rs.getString("SODT");
				String MAKHOA = rs.getString("MAKHOA");
			
				ketqua = new GiangVien(MAGV, TENGV, SODT, MAKHOA);
				
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}


}
