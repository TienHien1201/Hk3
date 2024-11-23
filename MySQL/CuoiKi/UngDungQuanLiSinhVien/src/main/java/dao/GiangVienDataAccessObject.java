package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Myconnector.JDBCUnitl;
import model.GiangVien;

public class GiangVienDataAccessObject implements DataAccessObjectInterface<GiangVien> {

	 public static GiangVienDataAccessObject getInstance() {
			return new GiangVienDataAccessObject();
		}
	
	@Override
	public int Delete(GiangVien t) {
		int ketqua = 0;
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			//Update
			String sql = "DELETE from GiangVien " 
					   + "WHERE MAGV = ?";/*Xóa 1 khoa dựa trên MAKHOA tức 
	           khoa nào có MAKHOA mà ta truyền vào đối tượng khoa muốn Xóa như bên class 
	           TestKhoaDataAccessObject 
	           ví dụ: ta tạo ra 1 đối tượng là: 
			   Khoa khoa1 = new Khoa("KT","Kế Toán", "2015-6-13", "F305","89898989", "GV01");
			   thì khi gọi KhoaDataAccessObject.getInstance().Uppdate(khoa1); thì
			   trong đây nó sẽ xử lý Column của khoa nào có MAKHOA là KT thì column của khoa đó bị delete*/
		
			
		   	PreparedStatement giangvien =  c.prepareStatement(sql);
			giangvien.setString(1, t.getMAGV());
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			ketqua = giangvien.executeUpdate();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta 1 con
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
	public int Insert(GiangVien t) {
		int ketqua = 0;

		try {
			//Đây các bước để java thao tác với databse
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "INSERT INTO GiangVien (MAGV, TENGV, SODT, MAKHOA)" 
				       + " VALUES (?,?,?,?)";
			PreparedStatement giangvien =  c.prepareStatement(sql);
			giangvien.setString(1, t.getMAGV());
			giangvien.setString(2, t.getTENGV());
			giangvien.setString(3, t.getSODT());
			giangvien.setString(4, t.getMAKHOA());
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
		   ketqua = giangvien.executeUpdate();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta 1 con
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
	public int Uppdate(GiangVien t) {
		int ketqua = 0;
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			//Update
			String sql = "UPDATE GiangVien " 
				       + " SET " 
					   + " MAGV =?,"
					   + "TENGV =?,"
					   + "SODT =?,"
					   + "MAKHOA =?"
					   + "WHERE MAGV = ?";/*Cập nhật 1 khoa mới dựa trên MAKHOA tức 
			           khoa nào có MAKHOA mà ta truyền vào đối tượng khoa muốn update như bên class 
			           TestKhoaDataAccessObject 
			           ví dụ: ta tạo ra 1 đối tượng là: 
			           Khoa khoa1 = new Khoa("KT","Kế Toán", "2015-6-13", "F305","89898989", "GV01");
			           thì khi gọi KhoaDataAccessObject.getInstance().Uppdate(khoa1); thì
			           trong đây nó sẽ xử lý Column của khoa nào có MAKHOA là KT thì column của khoa đó được
			            update */
			PreparedStatement giangvien =  c.prepareStatement(sql);
			giangvien.setString(1, t.getMAGV());
			giangvien.setString(2, t.getTENGV());
			giangvien.setString(3, t.getSODT());
			giangvien.setString(4, t.getMAKHOA());
			giangvien.setString(5, t.getMAGV());
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			ketqua = giangvien.executeUpdate();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta 1 con
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

	
	// Lấy ra all khách hàng ở bảng khách hàng
	@Override
	public ArrayList<GiangVien> selecALL() {
		ArrayList<GiangVien> ketqua = new ArrayList<GiangVien>();
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "SELECT * FROM GiangVien " ;
			PreparedStatement GiangVien =  c.prepareStatement(sql);
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
            System.out.println(sql);
			ResultSet rs = GiangVien.executeQuery();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta các 
			dữ liệu từ cơ sở dữ liệu mà ta truy vấn ra vì Query là truy vấn, Còn ResultSet giống như 1 cái 
			table bên sql nó trả về cho ta từng dữ liệu trong table
			 */
			
			//Bước 4: Xử lý 
			while (rs.next()) {/*Next là 1 phương thức đi tới ở trong một đối tượng ResultSet tức nếu cần
			dự liệu thì nó sẽ next tới lấy dữ liệu ra*/
				String MAGV = rs.getString("MAGV");
				String TENGV = rs.getString("TENGV");
				String SODT = rs.getString("SODT");
				String MAKHOA = rs.getString("MAKHOA");
			
				GiangVien giangvien = new GiangVien(MAGV, TENGV, SODT, MAKHOA);//Tạo ra 1 đối tượng khoa
				ketqua.add(giangvien);//Vì là select * nên dòng này để đưa tất cả dữ liệu vào arraylist 
				
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
	public ArrayList<GiangVien> selecByCondition(String condition) {
		ArrayList<GiangVien> ketqua = new ArrayList<GiangVien>();
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "SELECT * FROM GiangVien where "+ condition ;
			PreparedStatement GiangVien =  c.prepareStatement(sql);
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			System.out.println(sql);
			ResultSet rs = GiangVien.executeQuery();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta các 
			dữ liệu từ cơ sở dữ liệu mà ta truy vấn ra vì Query là truy vấn, Còn ResultSet giống như 1 cái 
			table bên sql nó trả về cho ta từng dữ liệu trong table
			 */
			
			//Bước 4: Xử lý 
			while (rs.next()) {/*Next là 1 phương thức đi tới ở trong một đối tượng ResultSet tức nếu cần
			dự liệu thì nó sẽ next tới lấy dữ liệu ra*/
				String MAGV = rs.getString("MAGV");
				String TENGV = rs.getString("TENGV");
				String SODT = rs.getString("SODT");
				String MAKHOA = rs.getString("MAKHOA");
			
			
				GiangVien giangvien = new GiangVien(MAGV, TENGV, SODT, MAKHOA);//Tạo ra 1 đối tượng khoa
				ketqua.add(giangvien);//Vì là select * nên dòng này để đưa tất cả dữ liệu vào arraylist 
				
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
	public GiangVien selectById(GiangVien t) {
		GiangVien ketqua = null;
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "SELECT * FROM GiangVien where MAGV =?";
			PreparedStatement GiangVien =  c.prepareStatement(sql);
			GiangVien.setString(1, t.getMAGV());
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			System.out.println(sql);
			ResultSet rs = GiangVien.executeQuery();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta các 
			dữ liệu từ cơ sở dữ liệu mà ta truy vấn ra vì Query là truy vấn, Còn ResultSet giống như 1 cái 
			table bên sql nó trả về cho ta từng dữ liệu trong table
			 */
			
			//Bước 4: Xử lý 
			while (rs.next()) {/*Next là 1 phương thức đi tới ở trong một đối tượng ResultSet tức nếu cần
			dự liệu thì nó sẽ next tới lấy dữ liệu ra*/
				String MAGV = rs.getString("MAGV");
				String TENGV = rs.getString("TENGV");
				String SODT = rs.getString("SODT");
				String MAKHOA = rs.getString("MAKHOA");
			
				ketqua = new GiangVien(MAGV, TENGV, SODT, MAKHOA);
				
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
