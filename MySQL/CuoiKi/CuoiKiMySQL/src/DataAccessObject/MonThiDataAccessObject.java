package DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import database.JDBCUnitl;
import model.MonThi;

public class MonThiDataAccessObject implements DataAccessObjectInterface<MonThi>{

	 public static MonThiDataAccessObject getInstance() {
			return new MonThiDataAccessObject();
		}
	
	@Override
	public int Insert(MonThi t) {
		int ketqua = 0;

		try {
			//Đây các bước để java thao tác với databse
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "INSERT INTO MonThi (MAMT, TENMT )" 
				       + " VALUES (?,?)";
			PreparedStatement monthi =  c.prepareStatement(sql);
			monthi.setString(1,t.getMaMT());
			monthi.setString(2, t.getTENMT());
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
		    ketqua = monthi.executeUpdate();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta 1 con
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
	public int Uppdate(MonThi t) {
		int ketqua = 0;
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "UPDATE MonThi " 
			           + " SET " 
			           + "MAMT =?,"
			           + "TENMT =?"
			           + "WHERE MAMT = ?";/*Cập nhật 1 khoa mới dựa trên MAKHOA tức 
			           khoa nào có MAKHOA mà ta truyền vào đối tượng khoa muốn update như bên class 
			           TestKhoaDataAccessObject 
			           ví dụ: ta tạo ra 1 đối tượng là: 
			           Khoa khoa1 = new Khoa("KT","Kế Toán", "2015-6-13", "F305","89898989", "GV01");
			           thì khi gọi KhoaDataAccessObject.getInstance().Uppdate(khoa1); thì
			           trong đây nó sẽ xử lý Column của khoa nào có MAKHOA là KT thì column của khoa đó được
			           update */
			PreparedStatement monthi =  c.prepareStatement(sql);
			monthi.setString(1,t.getMaMT());
			monthi.setString(2, t.getTENMT());
			monthi.setString(3,t.getMaMT());
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			
			ketqua = monthi.executeUpdate();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta 1 con
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
	public int Delete(MonThi t) {
		int ketqua = 0;
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			//Update
			String sql = "DELETE from MonThi " 
					   + "WHERE MAMT = ?" ;/*Xóa 1 khoa dựa trên MAKHOA tức 
	           khoa nào có MAKHOA mà ta truyền vào đối tượng khoa muốn Xóa như bên class 
	           TestKhoaDataAccessObject 
	           ví dụ: ta tạo ra 1 đối tượng là: 
			   Khoa khoa1 = new Khoa("KT","Kế Toán", "2015-6-13", "F305","89898989", "GV01");
			   thì khi gọi KhoaDataAccessObject.getInstance().Uppdate(khoa1); thì
			   trong đây nó sẽ xử lý Column của khoa nào có MAKHOA là KT thì column của khoa đó bị delete*/
			PreparedStatement monthi =  c.prepareStatement(sql);
			monthi.setString(1, t.getMaMT());
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			ketqua = monthi.executeUpdate();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta 1 con
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
	public ArrayList<MonThi> selecALL() {
		ArrayList<MonThi> ketqua = new ArrayList<MonThi>();
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "SELECT * FROM MonThi " ;
			PreparedStatement monthi =  c.prepareStatement(sql);
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			System.out.println(sql);
			ResultSet rs = monthi.executeQuery();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta các 
			dữ liệu từ cơ sở dữ liệu mà ta truy vấn ra vì Query là truy vấn, Còn ResultSet giống như 1 cái 
			table bên sql nó trả về cho ta từng dữ liệu trong table
			 */
			
			//Bước 4: Xử lý 
			while (rs.next()) {/*Next là 1 phương thức đi tới ở trong một đối tượng ResultSet tức nếu cần
			dự liệu thì nó sẽ next tới lấy dữ liệu ra*/
				String MaMT = rs.getString("MaMT");
				String TENMT = rs.getString("TENMT");
				
			
				MonThi monThi = new MonThi(MaMT, TENMT);//Tạo ra 1 đối tượng khoa
				ketqua.add(monThi);//Vì là select * nên dòng này để đưa tất cả dữ liệu vào arraylist 
				
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
	public MonThi selectById(MonThi t) {
		MonThi ketqua = null;
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "SELECT * FROM MonThi where MaMT = ?";
			PreparedStatement monthi =  c.prepareStatement(sql);
			monthi.setString(1, t.getMaMT());
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			System.out.println(sql);
			ResultSet rs = monthi.executeQuery();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta các 
			dữ liệu từ cơ sở dữ liệu mà ta truy vấn ra vì Query là truy vấn, Còn ResultSet giống như 1 cái 
			table bên sql nó trả về cho ta từng dữ liệu trong table
			 */
			
			//Bước 4: Xử lý 
			while (rs.next()) {/*Next là 1 phương thức đi tới ở trong một đối tượng ResultSet tức nếu cần
			dự liệu thì nó sẽ next tới lấy dữ liệu ra*/
				String MaMT = rs.getString("MaMT");
				String TENMT = rs.getString("TENMT");
			
				ketqua = new MonThi(MaMT, TENMT);
				
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
	public ArrayList<MonThi> selecByCondition(String condition) {
		ArrayList<MonThi> ketqua = new ArrayList<MonThi>();
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "SELECT * FROM MonThi where "+ condition ;
			PreparedStatement monthi =  c.prepareStatement(sql);
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			System.out.println(sql);
			ResultSet rs = monthi.executeQuery();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta các 
			dữ liệu từ cơ sở dữ liệu mà ta truy vấn ra vì Query là truy vấn, Còn ResultSet giống như 1 cái 
			table bên sql nó trả về cho ta từng dữ liệu trong table
			 */
			
			//Bước 4: Xử lý 
			while (rs.next()) {/*Next là 1 phương thức đi tới ở trong một đối tượng ResultSet tức nếu cần
			dự liệu thì nó sẽ next tới lấy dữ liệu ra*/
				String MaMT = rs.getString("MaMT");
				String TENMT = rs.getString("TENMT");
				
			
				MonThi monThi = new MonThi(MaMT, TENMT);//Tạo ra 1 đối tượng khoa
				ketqua.add(monThi);//Vì là select * nên dòng này để đưa tất cả dữ liệu vào arraylist 
				
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
