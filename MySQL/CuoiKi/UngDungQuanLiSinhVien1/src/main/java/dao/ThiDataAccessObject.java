package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Myconnector.JDBCUnitl;
import model.Thi;

public class ThiDataAccessObject implements DataAccessObjectInterface<Thi> {

	 public static ThiDataAccessObject getInstance() {
			return new ThiDataAccessObject();
		}
	
	@Override
	public int Insert(Thi t) {
		int ketqua = 0;

		try {
			
		
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "INSERT INTO Thi (MAMT, MACN )" 
				       + " VALUES (?,?)";
			PreparedStatement thi =  c.prepareStatement(sql);
			thi.setString(1,t.getMaMT());
			thi.setString(2, t.getMaCN());
		
		    ketqua = thi.executeUpdate();
			
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println("Co "+ ketqua+ " Dong bi thay doi!");
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return ketqua;
	}

	@Override
	public int Uppdate(Thi t) {
		int ketqua = 0;
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "UPDATE Thi " 
			           + " SET " 
			           + "MAMT =?,"
			           + "MACN =?"
			           + "WHERE MAMT = ?";
			PreparedStatement thi =  c.prepareStatement(sql);
			thi.setString(1,t.getMaMT());
			thi.setString(2, t.getMaCN());
			thi.setString(3, t.getMaMT());
			
			ketqua = thi.executeUpdate();
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
	public int Delete(Thi t) {
		int ketqua = 0;
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "DELETE from Thi " 
					   + "WHERE MAMT = ?";
			PreparedStatement thi =  c.prepareStatement(sql);
			thi.setString(1,t.getMaMT());
			
		    ketqua = thi.executeUpdate();
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
	public ArrayList<Thi> selecALL() {
		ArrayList<Thi> ketqua = new ArrayList<Thi>();
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM Thi " ;
			PreparedStatement thi =  c.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = thi.executeQuery();
			while (rs.next()) {
				String MaMT = rs.getString("MaMT");
				String MaCN = rs.getString("MaCN");
				
			
				Thi Thi = new Thi(MaMT, MaCN);
				ketqua.add(Thi);
			}
			
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public Thi selectById(Thi t) {
		Thi ketqua = null;
		try {
			Connection c = JDBCUnitl.getConnection();

			String sql = "SELECT * FROM Thi where MaMT = ?";
			PreparedStatement thi =  c.prepareStatement(sql);
			thi.setString(1,t.getMaMT());
			
			System.out.println(sql);
			ResultSet rs = thi.executeQuery();
			while (rs.next()) {
				String MaMT = rs.getString("MaMT");
				String MaCN = rs.getString("MaCN");
			
				ketqua = new Thi(MaMT, MaCN);
				
			}
		
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<Thi> selecByCondition(String condition) {
		ArrayList<Thi> ketqua = new ArrayList<Thi>();
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM Thi where "+ condition ;
			PreparedStatement thi =  c.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = thi.executeQuery();
			
		
			while (rs.next()) {
				String MaMT = rs.getString("MaMT");
				String MaCN = rs.getString("MaCN");
				
			
				Thi Thi = new Thi(MaMT, MaCN);
				ketqua.add(Thi);
				
			}
			
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

}
