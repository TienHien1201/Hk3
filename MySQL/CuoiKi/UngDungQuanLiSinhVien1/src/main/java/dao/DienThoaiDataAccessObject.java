package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Myconnector.JDBCUnitl;
import model.DienThoai;

public class DienThoaiDataAccessObject implements DataAccessObjectInterface<DienThoai>{

	 public static DienThoaiDataAccessObject getInstance() {
			return new DienThoaiDataAccessObject();
		}
	
	@Override
	public int Delete(DienThoai t) {
		int ketqua = 0;
		try {

			Connection c = JDBCUnitl.getConnection();
				
			//Update
			String sql = "DELETE from DienThoai " 
					   + "WHERE MASV = ? and SODT = ?";
			PreparedStatement dienthoai = c.prepareStatement(sql);
			dienthoai.setString(1,t.getMASV());
			dienthoai.setString(2,t.getSODT());
		
		     ketqua = dienthoai.executeUpdate(); 
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
	public int Insert(DienThoai t) {
		int ketqua = 0;

		try {
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "INSERT INTO DienThoai (MASV, SODT )" 
				       + " VALUES(? ,?)";
	       PreparedStatement dienthoai =  c.prepareStatement(sql);
			dienthoai.setString(1,t.getMASV());
			dienthoai.setString(2,t.getSODT());
			
		   ketqua = dienthoai.executeUpdate();
			
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
	public int Uppdate(DienThoai t) {
		int ketqua = 0;
		try {

			Connection c = JDBCUnitl.getConnection();
			
			String sql = "UPDATE DienThoai " 
			           + " SET " 
			           + "MASV =?," 
			           + "SODT =?"
			           + "WHERE MASV = ?";
			PreparedStatement dienthoai =  c.prepareStatement(sql);
			dienthoai.setString(1,t.getMASV());
			dienthoai.setString(2,t.getSODT());
			dienthoai.setString(3,t.getMASV());
			
		    ketqua = dienthoai.executeUpdate();
			
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
	public ArrayList<DienThoai> selecALL() {
		ArrayList<DienThoai> ketqua = new ArrayList<DienThoai>();
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM DienThoai " ;
			PreparedStatement dienthoai =  c.prepareStatement(sql);
		
			System.out.println(sql);
			ResultSet rs = dienthoai.executeQuery();
			while (rs.next()) {
				String MASV = rs.getString("MASV");
				String SODT = rs.getString("SODT");
				
			
				DienThoai dienThoai = new DienThoai(MASV, SODT);
				ketqua.add(dienThoai); 
				
			}
		
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<DienThoai> selecByCondition(String condition) {
		ArrayList<DienThoai> ketqua = new ArrayList<DienThoai>();
		try {

			Connection c = JDBCUnitl.getConnection();
	
			String sql = "SELECT * FROM DienThoai where "+ condition ;
			PreparedStatement dienthoai =  c.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = dienthoai.executeQuery();
			
			while (rs.next()) {
				String MASV = rs.getString("MASV");
				String SODT = rs.getString("SODT");
				
			
				DienThoai dienThoai = new DienThoai(MASV, SODT);//Tạo ra 1 đối tượng khoa
				ketqua.add(dienThoai);
				
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public DienThoai selectById(DienThoai t) {
		DienThoai ketqua = null;
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM DienThoai where MASV =?";
			PreparedStatement dienthoai =  c.prepareStatement(sql);
			dienthoai.setString(1, t.getMASV());
			
			System.out.println(sql);
			ResultSet rs = dienthoai.executeQuery();
			while (rs.next()) {
			    String MASV = rs.getString("MASV");
				String SODT = rs.getString("SODT");
				
				ketqua = new DienThoai(MASV, SODT);
				
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}


}
