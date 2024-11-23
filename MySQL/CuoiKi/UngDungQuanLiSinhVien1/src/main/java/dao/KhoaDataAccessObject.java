package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Myconnector.JDBCUnitl;
import model.Khoa;

public class KhoaDataAccessObject implements DataAccessObjectInterface<Khoa> {

 public static KhoaDataAccessObject getInstance() {
	return new KhoaDataAccessObject();
}
	
	@Override
	public int Insert(Khoa t) {
		int ketqua = 0;

		try {
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "INSERT INTO Khoa (MAKHOA, TENKHOA, NAMTL, PHONGLV, TEL, MATRGKHOA)" 
				       + " VALUES (?,?,?,?,?,?)";
			
			PreparedStatement Khoa =  c.prepareStatement(sql);
			Khoa.setString(1, t.getMAKHOA());
			Khoa.setString(2, t.getTENKHOA());
			Khoa.setString(3, t.getNAMTL());
			Khoa.setString(4, t.getPHONGLV());
			Khoa.setString(5, t.getTEL());
			Khoa.setString(6, t.getMATRGKHOA());
			
		    ketqua = Khoa.executeUpdate();
			 
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
	public int Uppdate(Khoa t) {
		int ketqua = 0;
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "UPDATE Khoa " 
				       + " SET " 
					   + " MAKHOA =?," 
					   + "TENKHOA =?," 
					   + "NAMTL =?," 
					   + "PHONGLV =?,"
					   + "TEL =?,"
					   + "MATRGKHOA =?"
					   + "WHERE MAKHOA = ?";
			PreparedStatement Khoa =  c.prepareStatement(sql);
			 Khoa.setString(1, t.getMAKHOA());
			 Khoa.setString(2, t.getTENKHOA());
			 Khoa.setString(3, t.getNAMTL());
			 Khoa.setString(4, t.getPHONGLV());
			 Khoa.setString(5, t.getTEL());
			 Khoa.setString(6, t.getMATRGKHOA());
			 Khoa.setString(7, t.getMAKHOA());
			
			ketqua = Khoa.executeUpdate();
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
	public int Delete(Khoa t) {
		int ketqua = 0;
		try {

			Connection c = JDBCUnitl.getConnection();
			
			String sql = "DELETE from Khoa " 
					   + "WHERE MAKHOA =?";
			PreparedStatement Khoa =  c.prepareStatement(sql);
			Khoa.setString(1, t.getMAKHOA());
		    ketqua = Khoa.executeUpdate();
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
	public ArrayList<Khoa> selecALL() {
		ArrayList<Khoa> ketqua = new ArrayList<Khoa>();
		try {

			Connection c = JDBCUnitl.getConnection();
			
		
			String sql = "SELECT * FROM Khoa " ;
			PreparedStatement Khoa =  c.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = Khoa.executeQuery(sql);
			while (rs.next()) {
				String MAKHOA = rs.getString("MAKHOA");
				String TENKHOA = rs.getString("TENKHOA");
				String NAMTL = rs.getString("NAMTL");
				String PHONGLV = rs.getString("PHONGLV");
				String TEL = rs.getString("TEL");
				String MATRGKHOA = rs.getString("MATRGKHOA");
			
				Khoa khoa = new Khoa(MAKHOA, TENKHOA, NAMTL, PHONGLV, TEL, MATRGKHOA);
				ketqua.add(khoa);
				
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public Khoa selectById(Khoa t) {
		Khoa ketqua = null;
		try {

			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM Khoa where MAKHOA =?" ;
			PreparedStatement Khoa =  c.prepareStatement(sql);
			Khoa.setString(1, t.getMAKHOA());
			System.out.println(sql);
			ResultSet rs = Khoa.executeQuery();
			while (rs.next()) {
				String MAKHOA = rs.getString("MAKHOA");
				String TENKHOA = rs.getString("TENKHOA");
				String NAMTL = rs.getString("NAMTL");
				String PHONGLV = rs.getString("PHONGLV");
				String TEL = rs.getString("TEL");
				String MATRGKHOA = rs.getString("MATRGKHOA");
			
				ketqua = new Khoa(MAKHOA, TENKHOA, NAMTL, PHONGLV, TEL, MATRGKHOA);
				
			}
			
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<Khoa> selecByCondition(String condition) {
		ArrayList<Khoa> ketqua = new ArrayList<Khoa>();
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM Khoa where "+ condition ;
			 PreparedStatement  Khoa =  c.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = Khoa.executeQuery(); 
			while (rs.next()) {
				String MAKHOA = rs.getString("MAKHOA");
				String TENKHOA = rs.getString("TENKHOA");
				String NAMTL = rs.getString("NAMTL");
				String PHONGLV = rs.getString("PHONGLV");
				String TEL = rs.getString("TEL");
				String MATRGKHOA = rs.getString("MATRGKHOA");
			
				Khoa khoa = new Khoa(MAKHOA, TENKHOA, NAMTL, PHONGLV, TEL, MATRGKHOA);//Tạo ra 1 đối tượng khoa
				ketqua.add(khoa);
				
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

}
