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
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement	
			String sql = "DELETE from ChuyenNganh " 
					   + "WHERE MACN =?" ;/*Xóa 1 khoa dựa trên MAKHOA tức 
	           khoa nào có MAKHOA mà ta truyền vào đối tượng khoa muốn Xóa như bên class 
	           TestKhoaDataAccessObject 
	           ví dụ: ta tạo ra 1 đối tượng là: 
			   Khoa khoa1 = new Khoa("KT","Kế Toán", "2015-6-13", "F305","89898989", "GV01");
			   thì khi gọi KhoaDataAccessObject.getInstance().Uppdate(khoa1); thì
			   trong đây nó sẽ xử lý Column của khoa nào có MAKHOA là KT thì column của khoa đó bị delete*/
			PreparedStatement chuyennganh =  c.prepareStatement(sql);
			chuyennganh.setString(1, t.getMACN());
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
		
		
			ketqua = chuyennganh.executeUpdate();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta 1 con
			số nguyên số nguyên này là số dòng bị thay đổi
			 */
			
			//Bước 4: Xử lý 
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println("Co "+ ketqua+ " Dong bi thay doi!");
			
			/*Bước 5: Ngắt kết nối(Nhớ ngắt kết nối để nhường cái slot đó cho các đối tượng khác.
			 * Ví dụ: Trong mùa đăng ký môn học lý do hệ thống luôn luôn bị chậm là do quá đông người 
			 truy cập vào nó không phụ vụ đc do cái database k chịu nỗi lượng kết nối để xử lý)*/
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
			//Đây các bước để java thao tác với databse
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "INSERT INTO ChuyenNganh (MACN, TENCN, MAGVQL, MAKHOA)" 
				       + " VALUES (? ,? ,? , ?)";
			PreparedStatement chuyennghanh =  c.prepareStatement(sql);
			chuyennghanh.setString(1, t.getMACN());
			chuyennghanh.setString(2, t.getTENCN());
			chuyennghanh.setString(3, t.getMAGVQL());
			chuyennghanh.setString(4, t.getMAKHOA());
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
		  
	        
			ketqua = chuyennghanh.executeUpdate();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta 1 con
			số nguyên số nguyên này là số dòng bị thay đổi */
			
			//Bước 4: Xử lý 
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println("Co "+ ketqua+ " Dong bi thay doi!");
			
			/*Bước 5: Ngắt kết nối(Nhớ ngắt kết nối để nhường cái slot đó cho các đối tượng khác.
			 * Ví dụ: Trong mùa đăng ký môn học lý do hệ thống luôn luôn bị chậm là do quá đông người 
			 truy cập vào nó không phụ vụ đc do cái database k chịu nỗi lượng kết nối để xử lý)*/
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ketqua;
	}

	@Override
	public int Uppdate(ChuyenNganh t) {
		int ketqua = 0;
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "UPDATE ChuyenNganh " 
				       + " SET " 
					   + " MACN = ?,"
					   + "TENCN = ?,"
					   + "MAGVQL = ?,"
					   + "MAKHOA = ?"
					   + "WHERE MACN = ?";/*Cập nhật 1 khoa mới dựa trên MAKHOA tức 
			           khoa nào có MAKHOA mà ta truyền vào đối tượng khoa muốn update như bên class 
			           TestKhoaDataAccessObject 
			           ví dụ: ta tạo ra 1 đối tượng là: 
			           Khoa khoa1 = new Khoa("KT","Kế Toán", "2015-6-13", "F305","89898989", "GV01");
			           thì khi gọi KhoaDataAccessObject.getInstance().Uppdate(khoa1); thì
			           trong đây nó sẽ xử lý Column của khoa nào có MAKHOA là KT thì column của khoa đó được
			           update */
			PreparedStatement chuyennghanh =  c.prepareStatement(sql);
			chuyennghanh.setString(1, t.getMACN());
			chuyennghanh.setString(2, t.getTENCN());
			chuyennghanh.setString(3, t.getMAGVQL());
			chuyennghanh.setString(4, t.getMAKHOA());
			chuyennghanh.setString(5, t.getMACN());
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			ketqua = chuyennghanh.executeUpdate();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta 1 con
			số nguyên số nguyên này là số dòng bị thay đổi */
			
			//Bước 4: Xử lý 
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println("Co "+ ketqua+ " Dong bi thay doi!");
			
			/*Bước 5: Ngắt kết nối(Nhớ ngắt kết nối để nhường cái slot đó cho các đối tượng khác.
			 * Ví dụ: Trong mùa đăng ký môn học lý do hệ thống luôn luôn bị chậm là do quá đông người 
			 truy cập vào nó không phụ vụ đc do cái database k chịu nỗi lượng kết nối để xử lý)*/
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
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "SELECT * FROM ChuyenNganh " ;
			PreparedStatement chuyenNghah =  c.prepareStatement(sql);
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			System.out.println(sql);
			ResultSet rs = chuyenNghah.executeQuery();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta các 
			dữ liệu từ cơ sở dữ liệu mà ta truy vấn ra vì Query là truy vấn, Còn ResultSet giống như 1 cái 
			table bên sql nó trả về cho ta từng dữ liệu trong table
			 */
			
			//Bước 4: Xử lý 
			while (rs.next()) {/*Next là 1 phương thức đi tới ở trong một đối tượng ResultSet tức nếu cần
			dự liệu thì nó sẽ next tới lấy dữ liệu ra*/
				String MACN = rs.getString("MACN");
				String TENCN = rs.getString("TENCN");
				String MAGVQL = rs.getString("MAGVQL");
				String MAKHOA = rs.getString("MAKHOA");
			
				ChuyenNganh chuyeNganh = new ChuyenNganh(MACN, TENCN, MAGVQL, MAKHOA);//Tạo ra 1 đối tượng khoa
				ketqua.add(chuyeNganh);//Vì là select * nên dòng này để đưa tất cả dữ liệu vào arraylist 
				
			}
			
			/*Bước 5: Ngắt kết nối(Nhớ ngắt kết nối để nhường cái slot đó cho các đối tượng khác.
			 * Ví dụ: Trong mùa đăng ký môn học lý do hệ thống luôn luôn bị chậm là do quá đông người 
			 truy cập vào nó không phụ vụ đc do cái database k chịu nỗi lượng kết nối để xử lý)*/
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
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "SELECT * FROM ChuyenNganh where "+ condition ;
			PreparedStatement chuyenNganh =  c.prepareStatement(sql);
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			
			System.out.println(sql);
			ResultSet rs = chuyenNganh.executeQuery();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta các 
			dữ liệu từ cơ sở dữ liệu mà ta truy vấn ra vì Query là truy vấn, Còn ResultSet giống như 1 cái 
			table bên sql nó trả về cho ta từng dữ liệu trong table
			 */
			
			//Bước 4: Xử lý 
			while (rs.next()) {/*Next là 1 phương thức đi tới ở trong một đối tượng ResultSet tức nếu cần
			dự liệu thì nó sẽ next tới lấy dữ liệu ra*/
				String MACN = rs.getString("MACN");
				String TENCN = rs.getString("TENCN");
				String MAGVQL = rs.getString("MAGVQL");
				String MAKHOA = rs.getString("MAKHOA");
			
			
				ChuyenNganh chuyenNghanh = new ChuyenNganh(MACN, TENCN, MAGVQL, MAKHOA);//Tạo ra 1 đối tượng khoa
				ketqua.add(chuyenNghanh);//Vì là select * nên dòng này để đưa tất cả dữ liệu vào arraylist 
				
			}
			
			/*Bước 5: Ngắt kết nối(Nhớ ngắt kết nối để nhường cái slot đó cho các đối tượng khác.
			 * Ví dụ: Trong mùa đăng ký môn học lý do hệ thống luôn luôn bị chậm là do quá đông người 
			 truy cập vào nó không phụ vụ đc do cái database k chịu nỗi lượng kết nối để xử lý)*/
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
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "SELECT * FROM ChuyenNganh where MACN =?";
			PreparedStatement chuyenNghanh =  c.prepareStatement(sql);
			chuyenNghanh.setString(1, t.getMACN());
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			System.out.println(sql);
			ResultSet rs = chuyenNghanh.executeQuery();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta các 
			dữ liệu từ cơ sở dữ liệu mà ta truy vấn ra vì Query là truy vấn, Còn ResultSet giống như 1 cái 
			table bên sql nó trả về cho ta từng dữ liệu trong table
			 */
			
			//Bước 4: Xử lý 
			while (rs.next()) {/*Next là 1 phương thức đi tới ở trong một đối tượng ResultSet tức nếu cần
			dự liệu thì nó sẽ next tới lấy dữ liệu ra*/
				String MACN = rs.getString("MACN");
				String TENCN = rs.getString("TENCN");
				String MAGVQL = rs.getString("MAGVQL");
				String MAKHOA = rs.getString("MAKHOA");
			
				ketqua = new ChuyenNganh(MACN, TENCN, MAGVQL, MAKHOA);
				
			}
			
			/*Bước 5: Ngắt kết nối(Nhớ ngắt kết nối để nhường cái slot đó cho các đối tượng khác.
			 * Ví dụ: Trong mùa đăng ký môn học lý do hệ thống luôn luôn bị chậm là do quá đông người 
			 truy cập vào nó không phụ vụ đc do cái database k chịu nỗi lượng kết nối để xử lý)*/
			JDBCUnitl.closeConnection(c);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

}
