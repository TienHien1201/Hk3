package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Myconnector.JDBCUnitl;
import model.Lop;

public class lopDataAccessObject implements DataAccessObjectInterface<Lop> {

	 public static lopDataAccessObject getInstance() {
			return new lopDataAccessObject();
		}
	
	@Override
	public int Delete(Lop t) {
		int ketqua = 0;
		try {

			Connection c = JDBCUnitl.getConnection();

			String sql = "DELETE from Lop " 
					   + "WHERE MAL =?";
			PreparedStatement lop =  c.prepareStatement(sql);
			lop.setString(1, t.getMAL());
		
			ketqua = lop.executeUpdate();
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
	public int Insert(Lop t) {
		int ketqua = 0;

		try {
			
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "INSERT INTO Lop (MAL, SISO, MACN)" 
				       + " VALUES (?,?,?)";
			PreparedStatement lop =  c.prepareStatement(sql);
			lop.setString(1, t.getMAL());
			lop.setInt(2, t.getSISO());
			lop.setString(3, t.getMACN());
			
		    ketqua = lop.executeUpdate();
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
	public int Uppdate(Lop t) {
		int ketqua = 0;
		try {

			Connection c = JDBCUnitl.getConnection();
			
			String sql = "UPDATE Lop " 
				       + " SET " 
					   + " MAL =?,"
					   + "SISO =?,"
					   + "MACN =?"
					   + "WHERE MAL = ?";
			PreparedStatement lop =  c.prepareStatement(sql);
			lop.setString(1, t.getMAL());
			lop.setInt(2, t.getSISO());
			lop.setString(3, t.getMACN());
			lop.setString(4, t.getMAL());
		
		ketqua = lop.executeUpdate();
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
	public ArrayList<Lop> selecALL() {
		ArrayList<Lop> ketqua = new ArrayList<Lop>();
		try {
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM Lop " ;
			PreparedStatement lop =  c.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = lop.executeQuery();
			while (rs.next()) {
				String MAL = rs.getString("MAL");
				Integer SISO = rs.getInt("SISO");
				String MACn = rs.getString("MACN");
				
			
				Lop Lop = new Lop(MAL, SISO, MACn);
				ketqua.add(Lop);
			}
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<Lop> selecByCondition(String condition) {
		ArrayList<Lop> ketqua = new ArrayList<Lop>();
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM Lop where "+ condition ;
			PreparedStatement lop =  c.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = lop.executeQuery();
			while (rs.next()) {
				String MAL = rs.getString("MAL");
				Integer SISO = rs.getInt("SISO");
				String MACn = rs.getString("MACN");
			
			
				Lop Lop = new Lop(MAL, SISO, MACn);
				ketqua.add(Lop);
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public Lop selectById(Lop t) {
		Lop ketqua = null;
		try {
	
			
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM Lop where MAL =?";
			PreparedStatement lop =  c.prepareStatement(sql);
			lop.setString(1, t.getMAL());
			
			System.out.println(sql);
			ResultSet rs = lop.executeQuery();
			while (rs.next()) {
				String MAL = rs.getString("MAL");
				Integer SISO = rs.getInt("SISO");
				String MACn = rs.getString("MACN");
			
				ketqua = new Lop(MAL, SISO, MACn);
				
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

}
