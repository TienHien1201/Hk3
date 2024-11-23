package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Myconnector.JDBCUnitl;
import model.SinhVien;

public class SinhVienDataAccessObject implements DataAccessObjectInterface<SinhVien>{

	 public static SinhVienDataAccessObject getInstance() {
			return new SinhVienDataAccessObject();
		}
	
	@Override
	public int Delete(SinhVien t) {
		int ketqua = 0;
		try {
			Connection c = JDBCUnitl.getConnection();
		
			String sql = "DELETE from SinhVien " 
					   + "WHERE MASV =?";
			PreparedStatement sinhvien =  c.prepareStatement(sql);
			sinhvien.setString(1, t.getMASV());
			
			ketqua = sinhvien.executeUpdate();
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
	public int Insert(SinhVien t) {
		int ketqua = 0;

		try {
			
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "INSERT INTO SINHVIEN (MASV, HOTEN, NGSINH, PHAI, MAL )" 
				       + " VALUES (?,?,?,?,?)";
			PreparedStatement sinhvien =  c.prepareStatement(sql);
			sinhvien.setString(1,t.getMASV());
			sinhvien.setString(2,t.getHOTEN());
			sinhvien.setString(3,t.getNGSINH());
			sinhvien.setString(4,t.getPHAI());
			sinhvien.setString(5,t.getMAL());
			
		    ketqua = sinhvien.executeUpdate();
			
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
	public int Uppdate(SinhVien t) {
		int ketqua = 0;
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "UPDATE SinhVien " 
			           + " SET " 
			           + "MASV =?,"
			           + "HOTEN =?,"
			           + "NGSINH =?,"
			           + "PHAI =?,"
			           + "MAL =?"
			           + "WHERE MASV = ?";
			PreparedStatement sinhvien =  c.prepareStatement(sql);
			sinhvien.setString(1,t.getMASV());
			sinhvien.setString(2,t.getHOTEN());
			sinhvien.setString(3,t.getNGSINH());
			sinhvien.setString(4,t.getPHAI());
			sinhvien.setString(5,t.getMAL());
			sinhvien.setString(6,t.getMASV());
			
			
			ketqua = sinhvien.executeUpdate();
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
	public ArrayList<SinhVien> selecALL() {
		ArrayList<SinhVien> ketqua = new ArrayList<SinhVien>();
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM SinhVien " ;
			PreparedStatement sinhVien =  c.prepareStatement(sql);
			
		System.out.println(sql);
			ResultSet rs = sinhVien.executeQuery();
			while (rs.next()) {
				String MASV = rs.getString("MASV");
				String HOTEN = rs.getString("HOTEN");
				String NGSINH = rs.getString("NGSINH");
				String PHAI = rs.getString("PHAI");
			    String MAL = rs.getString("MAL");
			
				SinhVien sinhvien = new SinhVien(MASV, HOTEN, NGSINH, PHAI, MAL);
				ketqua.add(sinhvien);
				
			}
			
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<SinhVien> selecByCondition(String condition) {
		ArrayList<SinhVien> ketqua = new ArrayList<SinhVien>();
		try {
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM SinhVien where "+ condition ;
			PreparedStatement sinhVien =  c.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = sinhVien.executeQuery();
			while (rs.next()) {
				String MASV = rs.getString("MASV");
				String HOTEN = rs.getString("HOTEN");
				String NGSINH = rs.getString("NGSINH");
				String PHAI = rs.getString("PHAI");
			    String MAL = rs.getString("MAL");
			
			
				SinhVien sinhvien = new SinhVien(MASV, HOTEN, NGSINH, PHAI, MAL);
				ketqua.add(sinhvien);
				
			}
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public SinhVien selectById(SinhVien t) {
		SinhVien ketqua = null;
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM SinhVien where MASV =?" ;
			PreparedStatement sinhVien =  c.prepareStatement(sql);
			sinhVien.setString(1, t.getMASV());
			
			System.out.println(sql);
			ResultSet rs = sinhVien.executeQuery();
			while (rs.next()) {
				String MASV = rs.getString("MASV");
				String HOTEN = rs.getString("HOTEN");
				String NGSINH = rs.getString("NGSINH");
				String PHAI = rs.getString("PHAI");
			    String MAL = rs.getString("MAL");
			
				ketqua = new SinhVien(MASV, HOTEN, NGSINH, PHAI, MAL);
				
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

}
