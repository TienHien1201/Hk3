package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Myconnector.JDBCUnitl;
import model.DiemThi;

public class DiemThiDataAccessObject implements DataAccessObjectInterface<DiemThi>{

	 public static DiemThiDataAccessObject getInstance() {
			return new DiemThiDataAccessObject();
		}
	
	@Override
	public int Insert(DiemThi t) {
		int ketqua = 0;

		try {
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "INSERT INTO DiemThi (MASV, MAMT, DIEM, GHICHU )" 
				       + " VALUES (?,?,?,?)";
	        PreparedStatement diemthi =  c.prepareStatement(sql);
			diemthi.setString(1,t.getMASV());
			diemthi.setString(2,t.getMAMT());
			diemthi.setInt(3,t.getDIEM());
			diemthi.setString(4,t.getGHICHU());
			
			ketqua = diemthi.executeUpdate();
			
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
	public int Uppdate(DiemThi t) {
		int ketqua = 0;
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "UPDATE DiemThi " 
			           + " SET " 
			           + "MASV =?,"
			           + "MAMT =?,"
			           + "DIEM =?,"
			           + "GHICHU =?"
			           + "WHERE MASV = ? and MAMT = ?";
			PreparedStatement diemthi =  c.prepareStatement(sql);
			diemthi.setString(1,t.getMASV());
			diemthi.setString(2,t.getMAMT());
			diemthi.setInt(3,t.getDIEM());
			diemthi.setString(4,t.getGHICHU());
			diemthi.setString(5,t.getMASV());
			diemthi.setString(6,t.getMAMT());
			
			
		    ketqua = diemthi.executeUpdate();
			
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println("Co "+ ketqua+ " Dong bi thay doi!");
		
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return ketqua;
	}

	@Override
	public int Delete(DiemThi t) {
		int ketqua = 0;
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "DELETE from DiemThi " 
					   + "WHERE MASV = ? and MAMT = ?";
		    PreparedStatement diemthi =  c.prepareStatement(sql);
			diemthi.setString(1,t.getMASV());
			diemthi.setString(2, t.getMAMT());
		    
			ketqua = diemthi.executeUpdate();
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
	public ArrayList<DiemThi> selecALL() {
		ArrayList<DiemThi> ketqua = new ArrayList<DiemThi>();
		try {

			Connection c = JDBCUnitl.getConnection();
			
		
			String sql = "SELECT * FROM DiemThi " ;
			PreparedStatement diemthi =  c.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = diemthi.executeQuery();
			 
			while (rs.next()) { 
				String MASV = rs.getString("MASV");
				String MAMT = rs.getString("MAMT");
				Integer DIEM = rs.getInt("DIEM");
				String GHICHU = rs.getString("GHICHU");
			
				DiemThi diemThi = new DiemThi(MASV, MAMT, DIEM, GHICHU);
				ketqua.add(diemThi);
				
			}
			
		
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public DiemThi selectById(DiemThi t) {
		DiemThi ketqua = null;
		try {
	
			Connection c = JDBCUnitl.getConnection();
		
			String sql = "SELECT * FROM DiemThi where MASV = ?" ;
			PreparedStatement diemthi =  c.prepareStatement(sql);
			diemthi.setString(1,t.getMASV());
			
			
		    System.out.println(sql);
			ResultSet rs = diemthi.executeQuery();
			while (rs.next()) {
				String MASV = rs.getString("MASV");
				String MAMT = rs.getString("MAMT");
				Integer DIEM = rs.getInt("DIEM");
				String GHICHU = rs.getString("GHICHU");
			
				ketqua = new DiemThi(MASV, MAMT, DIEM, GHICHU);
				
			}
			
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<DiemThi> selecByCondition(String condition) {
		ArrayList<DiemThi> ketqua = new ArrayList<DiemThi>();
		try {
	
			Connection c = JDBCUnitl.getConnection();
		
			String sql = "SELECT * FROM DiemThi where "+ condition ;
			PreparedStatement diemthi =  c.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = diemthi.executeQuery();
			
			while (rs.next()) {
				String MASV = rs.getString("MASV");
				String MAMT = rs.getString("MAMT");
				Integer DIEM = rs.getInt("DIEM");
				String GHICHU = rs.getString("GHICHU");
			
			
				DiemThi diemThi = new DiemThi(MASV, MAMT, DIEM, GHICHU);
				ketqua.add(diemThi);
				
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

}
