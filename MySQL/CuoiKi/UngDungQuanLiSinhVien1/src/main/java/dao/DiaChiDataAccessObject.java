package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Myconnector.JDBCUnitl;
import model.DiaChi;

public class DiaChiDataAccessObject implements DataAccessObjectInterface<DiaChi> {

	 public static DiaChiDataAccessObject getInstance() {
			return new DiaChiDataAccessObject();
		}
	
	@Override
	public int Delete(DiaChi t) {
		int ketqua = 0;
		try {
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "DELETE from DiaChi " 
					   + "WHERE MASV = ?";
			PreparedStatement diachi =  c.prepareStatement(sql);
			diachi.setString(1, t.getMASV());
			
			ketqua = diachi.executeUpdate();
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
	public int Insert(DiaChi t) {
		int ketqua = 0;

		try {
			
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "INSERT INTO DiaChi (MASV, SONhA, DUONG, QUAN, THANHPHO )" 
				       + " VALUES (?,?,?,?,?)";
	        PreparedStatement diachi =  c.prepareStatement(sql);
	        diachi.setString(1,t.getMASV());
	        diachi.setString(2,t.getSONhA());
	        diachi.setString(3,t.getDUONG());
	        diachi.setString(4,t.getQUAN());
	        diachi.setString(5,t.getTHANHPHO());
	        
	       
		    ketqua = diachi.executeUpdate();
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
	public int Uppdate(DiaChi t) {
		int ketqua = 0;
		try {
	
			
			Connection c = JDBCUnitl.getConnection();
		
			String sql = "UPDATE DiaChi " 
			           + " SET " 
			           + "MASV =?,"
			           + "SONhA =?,"
			           + "DUONG =?,"
			           + "QUAN =?,"
			           + "THANHPHO =?"
			           + "WHERE MASV =?";
		    PreparedStatement diachi =  c.prepareStatement(sql);
	        diachi.setString(1,t.getMASV());
	        diachi.setString(2,t.getSONhA());
	        diachi.setString(3,t.getDUONG());
	        diachi.setString(4,t.getQUAN());
	        diachi.setString(5,t.getTHANHPHO());
	        diachi.setString(6,t.getMASV());
			
			ketqua = diachi.executeUpdate(); 
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
	public ArrayList<DiaChi> selecALL() {
		ArrayList<DiaChi> ketqua = new ArrayList<DiaChi>();
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM DiaChi " ;
			PreparedStatement diachi =  c.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = diachi.executeQuery();
			while (rs.next()) {
				String MASV = rs.getString("MASV");
				String SONhA = rs.getString("SONhA");
				String DUONG = rs.getString("DUONG");
				String QUAN = rs.getString("QUAN");
			    String THANHPHO = rs.getString("THANHPHO");
			
				DiaChi diaChi = new DiaChi(MASV, SONhA, DUONG, QUAN, THANHPHO);
				ketqua.add(diaChi);
				
			}
			
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<DiaChi> selecByCondition(String condition) {
		ArrayList<DiaChi> ketqua = new ArrayList<DiaChi>();
		try {
			Connection c = JDBCUnitl.getConnection();
			String sql = "SELECT * FROM DiaChi where "+ condition ;
			PreparedStatement diachi =  c.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = diachi.executeQuery();
			 
			while (rs.next()) {
				String MASV = rs.getString("MASV");
				String SONhA = rs.getString("SONhA");
				String DUONG = rs.getString("DUONG");
				String QUAN = rs.getString("QUAN");
			    String THANHPHO = rs.getString("THANHPHO");
			
				DiaChi diaChi = new DiaChi(MASV, SONhA, DUONG, QUAN, THANHPHO);
				ketqua.add(diaChi);
			}
			
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public DiaChi selectById(DiaChi t) {
		DiaChi ketqua = null;
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM DiaChi where MASV =?" ;
			PreparedStatement diachi =  c.prepareStatement(sql);
			diachi.setString(1,t.getMASV());
			
			System.out.println(sql);
			ResultSet rs = diachi.executeQuery();
			
			while (rs.next()) {
				String MASV = rs.getString("MASV");
				String SONhA = rs.getString("SONhA");
				String DUONG = rs.getString("DUONG");
				String QUAN = rs.getString("QUAN");
			    String THANHPHO = rs.getString("THANHPHO");
			
				ketqua = new DiaChi(MASV, SONhA, DUONG, QUAN, THANHPHO);;
			}
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

}
