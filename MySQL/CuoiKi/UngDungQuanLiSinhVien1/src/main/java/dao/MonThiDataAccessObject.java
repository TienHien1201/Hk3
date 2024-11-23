package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Myconnector.JDBCUnitl;
import model.MonThi;

public class MonThiDataAccessObject implements DataAccessObjectInterface<MonThi>{

	 public static MonThiDataAccessObject getInstance() {
			return new MonThiDataAccessObject();
		}
	
	@Override
	public int Insert(MonThi t) {
		int ketqua = 0;

		try {
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "INSERT INTO MonThi (MAMT, TENMT )" 
				       + " VALUES (?,?)";
			PreparedStatement monthi =  c.prepareStatement(sql);
			monthi.setString(1,t.getMaMT());
			monthi.setString(2, t.getTENMT());
			
			
		    ketqua = monthi.executeUpdate();
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
	public int Uppdate(MonThi t) {
		int ketqua = 0;
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "UPDATE MonThi " 
			           + " SET " 
			           + "MAMT =?,"
			           + "TENMT =?"
			           + "WHERE MAMT = ?";
			PreparedStatement monthi =  c.prepareStatement(sql);
			monthi.setString(1,t.getMaMT());
			monthi.setString(2, t.getTENMT());
			monthi.setString(3,t.getMaMT());
			
			ketqua = monthi.executeUpdate();
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
	public int Delete(MonThi t) {
		int ketqua = 0;
		try {
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "DELETE from MonThi " 
					   + "WHERE MAMT = ?" ;
			PreparedStatement monthi =  c.prepareStatement(sql);
			monthi.setString(1, t.getMaMT());
			
			
			ketqua = monthi.executeUpdate();
			 
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
	public ArrayList<MonThi> selecALL() {
		ArrayList<MonThi> ketqua = new ArrayList<MonThi>();
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM MonThi " ;
			PreparedStatement monthi =  c.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = monthi.executeQuery();
			 
			while (rs.next()) {
				String MaMT = rs.getString("MaMT");
				String TENMT = rs.getString("TENMT");
				
			
				MonThi monThi = new MonThi(MaMT, TENMT);
				ketqua.add(monThi);
				
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public MonThi selectById(MonThi t) {
		MonThi ketqua = null;
		try {
	
			Connection c = JDBCUnitl.getConnection();
			
			String sql = "SELECT * FROM MonThi where MaMT = ?";
			PreparedStatement monthi =  c.prepareStatement(sql);
			monthi.setString(1, t.getMaMT());
			
			System.out.println(sql);
			ResultSet rs = monthi.executeQuery();
			while (rs.next()) {
				String MaMT = rs.getString("MaMT");
				String TENMT = rs.getString("TENMT");
			
				ketqua = new MonThi(MaMT, TENMT);
				
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<MonThi> selecByCondition(String condition) {
		ArrayList<MonThi> ketqua = new ArrayList<MonThi>();
		try {
	
			Connection c = JDBCUnitl.getConnection();
		
			String sql = "SELECT * FROM MonThi where "+ condition ;
			PreparedStatement monthi =  c.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = monthi.executeQuery(); 
			while (rs.next()) {
				String MaMT = rs.getString("MaMT");
				String TENMT = rs.getString("TENMT");
				
			
				MonThi monThi = new MonThi(MaMT, TENMT);//Tạo ra 1 đối tượng khoa
				ketqua.add(monThi);
				
			}
			
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

}
