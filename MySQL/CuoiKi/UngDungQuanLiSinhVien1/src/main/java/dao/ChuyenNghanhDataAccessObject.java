package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Myconnector.JDBCUnitl;
import model.ChuyenNganh;

public class ChuyenNghanhDataAccessObject implements DataAccessObjectInterface<ChuyenNganh> {

	 public static ChuyenNghanhDataAccessObject getInstance() {
			return new ChuyenNghanhDataAccessObject();
		}
	
	@Override
	public int Delete(ChuyenNganh t) {
		int ketqua = 0;
		try {
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "DELETE from ChuyenNganh " 
					   + "WHERE MACN =?" ;
			PreparedStatement chuyennganh =  c.prepareStatement(sql);
			chuyennganh.setString(1, t.getMACN());
			
			ketqua = chuyennganh.executeUpdate();
			
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
	public int Insert(ChuyenNganh t) {
		int ketqua = 0;

		try {
		
			Connection c = JDBCUnitl.getConnection();
		
			String sql = "INSERT INTO ChuyenNganh (MACN, TENCN, MAGVQL, MAKHOA)" 
				       + " VALUES (? ,? ,? , ?)";
			PreparedStatement chuyennghanh =  c.prepareStatement(sql);
			chuyennghanh.setString(1, t.getMACN());
			chuyennghanh.setString(2, t.getTENCN());
			chuyennghanh.setString(3, t.getMAGVQL());
			chuyennghanh.setString(4, t.getMAKHOA());
			  
			ketqua = chuyennghanh.executeUpdate();
			
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println("Co "+ ketqua+ " Dong bi thay doi!");
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return ketqua;
	}

	@Override
	public int Uppdate(ChuyenNganh t) {
		int ketqua = 0;
		try {
	
			Connection c = JDBCUnitl.getConnection();
		
			String sql = "UPDATE ChuyenNganh " 
				       + " SET " 
					   + " MACN = ?,"
					   + "TENCN = ?,"
					   + "MAGVQL = ?,"
					   + "MAKHOA = ?"
					   + "WHERE MACN = ?";
			PreparedStatement chuyennghanh =  c.prepareStatement(sql);
			chuyennghanh.setString(1, t.getMACN());
			chuyennghanh.setString(2, t.getTENCN());
			chuyennghanh.setString(3, t.getMAGVQL());
			chuyennghanh.setString(4, t.getMAKHOA());
			chuyennghanh.setString(5, t.getMACN());
		
			ketqua = chuyennghanh.executeUpdate();
			
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
	public ArrayList<ChuyenNganh> selecALL() {
		ArrayList<ChuyenNganh> ketqua = new ArrayList<ChuyenNganh>();
		try {
	
			
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM ChuyenNganh " ;
			PreparedStatement chuyenNghah =  c.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = chuyenNghah.executeQuery();
			while (rs.next()) {
				String MACN = rs.getString("MACN");
				String TENCN = rs.getString("TENCN");
				String MAGVQL = rs.getString("MAGVQL");
				String MAKHOA = rs.getString("MAKHOA");
			
				ChuyenNganh chuyeNganh = new ChuyenNganh(MACN, TENCN, MAGVQL, MAKHOA);//Tạo ra 1 đối tượng khoa
				ketqua.add(chuyeNganh);
			}
			
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<ChuyenNganh> selecByCondition(String condition) {
		ArrayList<ChuyenNganh> ketqua = new ArrayList<ChuyenNganh>();
		try {

			Connection c = JDBCUnitl.getConnection();
		
			String sql = "SELECT * FROM ChuyenNganh where "+ condition ;
			PreparedStatement chuyenNgahanh =  c.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = chuyenNgahanh.executeQuery();
			
			
			while (rs.next()) {
				String MACN = rs.getString("MACN");
				String TENCN = rs.getString("TENCN");
				String MAGVQL = rs.getString("MAGVQL");
				String MAKHOA = rs.getString("MAKHOA");
			
			
				ChuyenNganh chuyenNganh = new ChuyenNganh(MACN, TENCN, MAGVQL, MAKHOA);
				ketqua.add(chuyenNganh);
			}
			
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ChuyenNganh selectById(ChuyenNganh t) {
		ChuyenNganh ketqua = null;
		try {

			Connection c = JDBCUnitl.getConnection();
			
			
			String sql = "SELECT * FROM ChuyenNganh where MACN =?";
			PreparedStatement chuyenNghanh =  c.prepareStatement(sql);
			chuyenNghanh.setString(1, t.getMACN());
		
			System.out.println(sql);
			ResultSet rs = chuyenNghanh.executeQuery();
			 
			while (rs.next()) {
				String MACN = rs.getString("MACN");
				String TENCN = rs.getString("TENCN");
				String MAGVQL = rs.getString("MAGVQL");
				String MAKHOA = rs.getString("MAKHOA");
			
				ketqua = new ChuyenNganh(MACN, TENCN, MAGVQL, MAKHOA);
				
			}
		
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return ketqua;
	}

}
