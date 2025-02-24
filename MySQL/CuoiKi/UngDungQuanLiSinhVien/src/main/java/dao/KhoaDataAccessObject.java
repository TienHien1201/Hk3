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
			//Đây các bước để java thao tác với databse
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "INSERT INTO Khoa (MAKHOA, TENKHOA, NAMTL, PHONGLV, TEL, MATRGKHOA)" 
				       + " VALUES (?,?,?,?,?,?)";
			
			PreparedStatement Khoa =  c.prepareStatement(sql);
			Khoa.setString(1, t.getMAKHOA());/*- Set có 2 tham số truyền vào: 
			+ thứ 1: là thứ tự. Thứ tự thứ bao nhiêu tương đương với nội dung thứ bao nhiêu đc truyền
			vào dấu ? và thứ tự của dấu ? theo thứ tự từ trái sang phải 
			+ thứ 2: là nội dung
			Ví dụ: table khoa có các column theo thứ tự MAKHOA, TENKHOA, NAMTL, PHONGLV, TEL, MATRGKHOA
			thì khi insert vào có 6 column thì ta đặt 6 dấu ? là ?,?,?,?,?,? 
			-> thì thứ tự 1 là dấu chấm hỏi nằm trái nhất tương ứng với nội dung là MAKHOA
			-> tương tự số 2 là dấu chấm hỏi kế dấu chấm hỏi trái nhất tương ứng với nội dung là TENKHOA
			-> Tương tự........ 
			Khi nội dung đc gắn vào dấu chấm hỏi tương ứng với số thứ tự của từng dấu ? thì trước khi gán 
			nội dung vào dấu ? thì nó sẽ có sự kiểm tra nếu số 1 tương đương với dấu chấm ? trái nhất với
			nội dung của MAKHOA là chuỗi câu lệnh sql gì đó thì nó sẽ bỏ qua và ngăn chặn không cho phép 
			chúng ta cộng thành chuỗi coi nhưng đây là 1 thằng statement sẵn sàng thực thi rồi và những gì 
			mà chúng ta truyền vào chỉ là 1 dữ liệu thôi chứ nó không đc cấu thành 1 câu lệnh sql */
			Khoa.setString(2, t.getTENKHOA());
			Khoa.setString(3, t.getNAMTL());
			Khoa.setString(4, t.getPHONGLV());
			Khoa.setString(5, t.getTEL());
			Khoa.setString(6, t.getMATRGKHOA());
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
		    ketqua = Khoa.executeUpdate();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta 1 con
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
	public int Uppdate(Khoa t) {
		int ketqua = 0;
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng PreparedStatement
			String sql = "UPDATE Khoa " 
				       + " SET " 
					   + " MAKHOA =?," 
					   + "TENKHOA =?," 
					   + "NAMTL =?," 
					   + "PHONGLV =?,"
					   + "TEL =?,"
					   + "MATRGKHOA =?"
					   + "WHERE MAKHOA = ?";/*Cập nhật 1 khoa mới dựa trên MAKHOA tức 
			           khoa nào có MAKHOA mà ta truyền vào đối tượng khoa muốn update như bên class 
			           TestKhoaDataAccessObject 
			           ví dụ: ta tạo ra 1 đối tượng là: 
			           Khoa khoa1 = new Khoa("KT","Kế Toán", "2015-6-13", "F305","89898989", "GV01");
			           thì khi gọi KhoaDataAccessObject.getInstance().Uppdate(khoa1); thì
			           trong đây nó sẽ xử lý Column của khoa nào có MAKHOA là KT thì column của khoa đó được
			           update */
			PreparedStatement Khoa =  c.prepareStatement(sql);
			 Khoa.setString(1, t.getMAKHOA());
			 Khoa.setString(2, t.getTENKHOA());
			 Khoa.setString(3, t.getNAMTL());
			 Khoa.setString(4, t.getPHONGLV());
			 Khoa.setString(5, t.getTEL());
			 Khoa.setString(6, t.getMATRGKHOA());
			 Khoa.setString(7, t.getMAKHOA());
			 
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			ketqua = Khoa.executeUpdate();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta 1 con
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
	public int Delete(Khoa t) {
		int ketqua = 0;
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng PreparedStatement
			String sql = "DELETE from Khoa " 
					   + "WHERE MAKHOA =?";/*Xóa 1 khoa dựa trên MAKHOA tức 
	           khoa nào có MAKHOA mà ta truyền vào đối tượng khoa muốn Xóa như bên class 
	           TestKhoaDataAccessObject 
	           ví dụ: ta tạo ra 1 đối tượng là: 
			   Khoa khoa1 = new Khoa("KT","Kế Toán", "2015-6-13", "F305","89898989", "GV01");
			   thì khi gọi KhoaDataAccessObject.getInstance().Uppdate(khoa1); thì
			   trong đây nó sẽ xử lý Column của khoa nào có MAKHOA là KT thì column của khoa đó bị delete*/
			PreparedStatement Khoa =  c.prepareStatement(sql);
			Khoa.setString(1, t.getMAKHOA());/*- Set có 2 tham số truyền vào: 
			+ thứ 1: là thứ tự. Thứ tự thứ bao nhiêu tương đương với nội dung thứ bao nhiêu đc truyền
			vào dấu ? và thứ tự của dấu ? theo thứ tự từ trái sang phải 
			+ thứ 2: là nội dung
			Ví dụ: table khoa có các column theo thứ tự MAKHOA, TENKHOA, NAMTL, PHONGLV, TEL, MATRGKHOA
			thì khi insert vào có 6 column thì ta đặt 6 dấu ? là ?,?,?,?,?,? 
			-> thì thứ tự 1 là dấu chấm hỏi nằm trái nhất tương ứng với nội dung là MAKHOA
			-> tương tự số 2 là dấu chấm hỏi kế dấu chấm hỏi trái nhất tương ứng với nội dung là TENKHOA
			-> Tương tự........ 
			Khi nội dung đc gắn vào dấu chấm hỏi tương ứng với số thứ tự của từng dấu ? thì trước khi gán 
			nội dung vào dấu ? thì nó sẽ có sự kiểm tra nếu số 1 tương đương với dấu chấm ? trái nhất với
			nội dung của MAKHOA là chuỗi câu lệnh sql gì đó thì nó sẽ bỏ qua và ngăn chặn không cho phép 
			chúng ta cộng thành chuỗi coi nhưng đây là 1 thằng statement sẵn sàng thực thi rồi và những gì 
			mà chúng ta truyền vào chỉ là 1 dữ liệu thôi chứ nó không đc cấu thành 1 câu lệnh sql */
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
		    ketqua = Khoa.executeUpdate();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta 1 con
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
	public ArrayList<Khoa> selecALL() {
		ArrayList<Khoa> ketqua = new ArrayList<Khoa>();
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng PreparedStatement
			String sql = "SELECT * FROM Khoa " ;
			PreparedStatement Khoa =  c.prepareStatement(sql);
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			System.out.println(sql);
			ResultSet rs = Khoa.executeQuery(sql);/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta các 
			dữ liệu từ cơ sở dữ liệu mà ta truy vấn ra vì Query là truy vấn, Còn ResultSet giống như 1 cái 
			table bên sql nó trả về cho ta từng dữ liệu trong table
			 */
			
			//Bước 4: Xử lý 
			while (rs.next()) {/*Next là 1 phương thức đi tới ở trong một đối tượng ResultSet tức nếu cần
			dự liệu thì nó sẽ next tới lấy dữ liệu ra*/
				String MAKHOA = rs.getString("MAKHOA");
				String TENKHOA = rs.getString("TENKHOA");
				String NAMTL = rs.getString("NAMTL");
				String PHONGLV = rs.getString("PHONGLV");
				String TEL = rs.getString("TEL");
				String MATRGKHOA = rs.getString("MATRGKHOA");
			
				Khoa khoa = new Khoa(MAKHOA, TENKHOA, NAMTL, PHONGLV, TEL, MATRGKHOA);//Tạo ra 1 đối tượng khoa
				ketqua.add(khoa);//Vì là select * nên dòng này để đưa tất cả dữ liệu vào arraylist 
				
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
	public Khoa selectById(Khoa t) {
		Khoa ketqua = null;
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			String sql = "SELECT * FROM Khoa where MAKHOA =?" ;
			PreparedStatement khoa =  c.prepareStatement(sql);
			 khoa.setString(1, t.getMAKHOA());;/*- Set có 2 tham số truyền vào: 
			+ thứ 1: là thứ tự. Thứ tự thứ bao nhiêu tương đương với nội dung thứ bao nhiêu đc truyền
			vào dấu ? và thứ tự của dấu ? theo thứ tự từ trái sang phải 
			+ thứ 2: là nội dung
			Ví dụ: table khoa có các column theo thứ tự MAKHOA, TENKHOA, NAMTL, PHONGLV, TEL, MATRGKHOA
			thì khi insert vào có 6 column thì ta đặt 6 dấu ? là ?,?,?,?,?,? 
			-> thì thứ tự 1 là dấu chấm hỏi nằm trái nhất tương ứng với nội dung là MAKHOA
			-> tương tự số 2 là dấu chấm hỏi kế dấu chấm hỏi trái nhất tương ứng với nội dung là TENKHOA
			-> Tương tự........ 
			Khi nội dung đc gắn vào dấu chấm hỏi tương ứng với số thứ tự của từng dấu ? thì trước khi gán 
			nội dung vào dấu ? thì nó sẽ có sự kiểm tra nếu số 1 tương đương với dấu chấm ? trái nhất với
			nội dung của MAKHOA là chuỗi câu lệnh sql gì đó thì nó sẽ bỏ qua và ngăn chặn không cho phép 
			chúng ta cộng thành chuỗi coi nhưng đây là 1 thằng statement sẵn sàng thực thi rồi và những gì 
			mà chúng ta truyền vào chỉ là 1 dữ liệu thôi chứ nó không đc cấu thành 1 câu lệnh sql */
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			System.out.println(sql);
			ResultSet rs = khoa.executeQuery();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta các 
			dữ liệu từ cơ sở dữ liệu mà ta truy vấn ra vì Query là truy vấn, Còn ResultSet giống như 1 cái 
			table bên sql nó trả về cho ta từng dữ liệu trong table
			 */
			
			//Bước 4: Xử lý 
			while (rs.next()) {/*Next là 1 phương thức đi tới ở trong một đối tượng ResultSet tức nếu cần
			dự liệu thì nó sẽ next tới lấy dữ liệu ra*/
				String MAKHOA = rs.getString("MAKHOA");
				String TENKHOA = rs.getString("TENKHOA");
				String NAMTL = rs.getString("NAMTL");
				String PHONGLV = rs.getString("PHONGLV");
				String TEL = rs.getString("TEL");
				String MATRGKHOA = rs.getString("MATRGKHOA");
			
				ketqua = new Khoa(MAKHOA, TENKHOA, NAMTL, PHONGLV, TEL, MATRGKHOA);
				
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
	public ArrayList<Khoa> selecByCondition(String condition) {
		ArrayList<Khoa> ketqua = new ArrayList<Khoa>();
		try {
	
			// TODO Auto-generated method stub
			//Bước 1: Tạo kết nối đến cơ sở dữ liệu
			Connection c = JDBCUnitl.getConnection();
			
			//Bước 2: Tạo ra đối tượng PreparedStatement
			String sql = "SELECT * FROM Khoa where "+ condition ;
			 PreparedStatement  Khoa =  c.prepareStatement(sql);
			
			//Bước 3: Thực thi câu lệnh SQL(VÍ dụ: Insert, Update, Delete...)
			//Update
			System.out.println(sql);
			ResultSet rs = Khoa.executeQuery();/*Sau khi dòng này đc thực thi thì nó sẽ trả về cho ta các 
			dữ liệu từ cơ sở dữ liệu mà ta truy vấn ra vì Query là truy vấn, Còn ResultSet giống như 1 cái 
			table bên sql nó trả về cho ta từng dữ liệu trong table
			 */
			
			//Bước 4: Xử lý 
			while (rs.next()) {/*Next là 1 phương thức đi tới ở trong một đối tượng ResultSet tức nếu cần
			dự liệu thì nó sẽ next tới lấy dữ liệu ra*/
				String MAKHOA = rs.getString("MAKHOA");
				String TENKHOA = rs.getString("TENKHOA");
				String NAMTL = rs.getString("NAMTL");
				String PHONGLV = rs.getString("PHONGLV");
				String TEL = rs.getString("TEL");
				String MATRGKHOA = rs.getString("MATRGKHOA");
			
				Khoa khoa = new Khoa(MAKHOA, TENKHOA, NAMTL, PHONGLV, TEL, MATRGKHOA);//Tạo ra 1 đối tượng khoa
				ketqua.add(khoa);//Vì là select * nên dòng này để đưa tất cả dữ liệu vào arraylist 
				
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
