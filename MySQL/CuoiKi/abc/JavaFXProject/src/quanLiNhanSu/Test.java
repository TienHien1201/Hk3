package quanLiNhanSu;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChucNangPNS danhSach = new ChucNangPNS("NhanSu.dat");

		short luachon = 0;
		//	Menu 14
		while (true) {
			System.out.println("\t\t+------------------MENU------------------------------------+");
			System.out.println("\t\t| 1.Them moi nhan su                                       |\r\n"
					+ "\t\t| 2.Liet ke tat ca nhan su trong cong ty                   |\r\n"
					+ "\t\t| 3.Tim kiem theo Ten                                      |\r\n"
					+ "\t\t| 4.Sua thong tin nhan su (do nhap sai)                    |\r\n"
					+ "\t\t| 5.Xoa ho su nhan su da thoi viec                         |\r\n"
					+ "\t\t| 6.Tim kiem theo ma nhan vien                             |\r\n"
					+ "\t\t| 7.Tim kiem theo Ho va Ten                                |\r\n"                     
					+ "\t\t| 8.Liet ke theo doi tuong                                 |\r\n"
					+ "\t\t| 9.Tong luong thang cua tung doi tuong                    |\r\n"
					+ "\t\t| 10.Luong trung binh cua ca cong ty                       |\r\n"
					+ "\t\t| 11.Luong trung binh cua tung doi tuong                   |\r\n"
					+ "\t\t| 12.Liet ke theo Tuoi(Nguoi cao tuoi hien thi truoc)      |\r\n"
					+ "\t\t| 13.Tuoi trung binh cua cong ty                           |\r\n"
					+ "\t\t| 14.Nguoi tre nhat va lon tuoi nhat trong cong ty         |\r\n"
					+ "\t\t| 0.Ket thuc !                                             |\r\n"
					+ "\t\t+----------------------------------------------------------+");   
			System.out.println("\t\tMoi ban lua chon !");
			luachon = sc.nextShort();
			sc.nextLine();

			//				Thêm mới nhân sự
			if (luachon == 1) {
				while (true) {
					System.out.println("\t\tBan Muon Nhap thong tin nhan su nao ?");
					System.out.println("\t\t+----------------------------------------+");
					System.out.println("\t\t| 1.Nhap thong tin KY SU:                |\r\n"
							+ "\t\t| 2.Nhap thong tin CONG NHAN:            |\r\n"
							+ "\t\t| 3.Nhap thong tin NHAN VIEN:            |\r\n"
							+ "\t\t| 4.Nhap thong tin CHUYEN GIA NUOC NGOAI:|\r\n"
							+ "\t\t| 5.Nhap thong tin THUC TAP SINH:        |\r\n"
							+ "\t\t| 6.Nhap thong tin LAO DONG PHO THONG:   |\r\n"
							+ "\t\t| 7.Nhap thong tin NHAN VIEN PARTIME:    |\r\n"
							+ "\t\t| 8.Nhap thong tin CAN BO QUAN LI:       |\r\n"
							+ "\t\t| 0.Ket thuc lua chon !                  |\r\n"
							+ "\t\t+----------------------------------------+");   
					short chon = 0;
					System.out.println("\t\tMoi ban lua chon !");
					chon = sc.nextShort();
					sc.nextLine();
					if (chon == 1) {
						System.out.println("Moi nhap thong tin nhan su KY SU:");
						System.out.println("Ma Nhan Vien(1XXXX): ");
						String maNhanVien = sc.nextLine();
						System.out.println("Ho va Ten: " );
						String hoVaTen = sc.nextLine();
						System.out.println("Nam sinh(dd/MM/yyyy): " );
						String namSinhInput = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate namSinh = LocalDate.parse(namSinhInput,formatter);
						System.out.println("Gioi Tinh: " );
						String gioiTinh = sc.nextLine();
						System.out.println("So Dien Thoai: " );
						String soDienThoai = sc.nextLine();
						System.out.println("Chuyen nghanh dao tao: ");
						String chuyenNghanhDaoTao = sc.nextLine();
						System.out.println("Da thoi viec chua: ");
						String daThoiViec = sc.nextLine();
						System.out.println("So Gio Lam: ");
						Float soGioLamViec = sc.nextFloat();
						KySu ks = new KySu("1" + maNhanVien, hoVaTen, namSinh, gioiTinh, soDienThoai, chuyenNghanhDaoTao, soGioLamViec, daThoiViec);
						danhSach.addNhanSu(ks);
					}
					else if(chon == 2) {
						System.out.println("Moi nhap thong tin nhan su CONG NHAN:");
						System.out.println("Ma Nhan Vien(2XXXX): ");
						String maNhanVien = sc.nextLine();
						System.out.println("Ho va Ten: " );
						String hoVaTen = sc.nextLine();
						System.out.println("Nam sinh(dd/MM/yyyy): " );
						String namSinhInput = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate namSinh = LocalDate.parse(namSinhInput,formatter);
						System.out.println("Gioi Tinh: " );
						String gioiTinh = sc.nextLine();
						System.out.println("So Dien Thoai: " );
						String soDienThoai = sc.nextLine();
						System.out.println("Bac Nghe: ");
						String bacNghe = sc.nextLine();
						System.out.println("Da thoi viec chua: ");
						String daThoiViec = sc.nextLine();
						System.out.println("So Gio Lam: ");
						Float soGioLamViec = sc.nextFloat();
						CongNhan cn = new CongNhan("2" + maNhanVien, hoVaTen, namSinh, gioiTinh, soDienThoai, daThoiViec, soGioLamViec, daThoiViec);
						danhSach.addNhanSu(cn);

					}

					else if(chon == 3) {
						System.out.println("Moi nhap thong tin nhan su NHAN VIEN:");
						System.out.println("Ma Nhan Vien(3XXXX): ");
						String maNhanVien = sc.nextLine();
						System.out.println("Ho va Ten: " );
						String hoVaTen = sc.nextLine();
						System.out.println("Nam sinh(dd/MM/yyyy): " );
						String namSinhInput = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate namSinh = LocalDate.parse(namSinhInput,formatter);
						System.out.println("Gioi Tinh: " );
						String gioiTinh = sc.nextLine();
						System.out.println("So Dien Thoai: " );
						String soDienThoai = sc.nextLine();
						System.out.println("Cong Viec Chinh \n(Lao dong chan tay/ lao dong tri oc): ");
						String congViecChinh = sc.nextLine();
						System.out.println("Da thoi viec chua: ");
						String daThoiViec = sc.nextLine();
						System.out.println("So Gio Lam: ");
						Float soGioLamViec = sc.nextFloat();
						NhanVien nv = new NhanVien("3" + maNhanVien, hoVaTen, namSinh, gioiTinh, soDienThoai, daThoiViec, soGioLamViec, congViecChinh);
						danhSach.addNhanSu(nv);
					}

					else if (chon == 4) {
						System.out.println("Moi nhap thong tin nhan su CHUYEN GIA NUOC NGOAI:");
						System.out.println("Ma Nhan Vien(4XXXX): ");
						String maNhanVien = sc.nextLine();
						System.out.println("Ho va Ten: " );
						String hoVaTen = sc.nextLine();
						System.out.println("Nam sinh(dd/MM/yyyy): " );
						String namSinhInput = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate namSinh = LocalDate.parse(namSinhInput,formatter);
						System.out.println("Gioi Tinh: " );
						String gioiTinh = sc.nextLine();
						System.out.println("So Dien Thoai: " );
						String soDienThoai = sc.nextLine();
						System.out.println("Chuyen nghanh dao tao: ");
						String chuyenNghanh = sc.nextLine();
						System.out.println("Tham nien trong nghe: ");
						int thamNien = sc.nextInt();
						sc.nextLine();
						System.out.println("Quoc Tich: ");
						String quocTich = sc.nextLine();
						System.out.println("Ngay Het Han Visa(dd/mm/yy): ");
						String ngayHetHanVisa = sc.nextLine();
						System.out.println("Da thoi viec chua: ");
						String daThoiViec = sc.nextLine();
						System.out.println("So Gio Lam: ");
						Float soGioLamViec = sc.nextFloat();
						ChuyenGiaNuocNgoai cgnn = new ChuyenGiaNuocNgoai("4" + maNhanVien, hoVaTen, namSinh, gioiTinh, soDienThoai, daThoiViec, soGioLamViec, chuyenNghanh, thamNien, quocTich, ngayHetHanVisa);
						danhSach.addNhanSu(cgnn);
					}
					else if (chon == 5) {
						System.out.println("Moi nhap thong tin nhan su THUC TAP SINH:");
						System.out.println("Ma Nhan Vien (5XXXX): ");
						String maNhanVien = sc.nextLine();
						System.out.println("Ho va Ten: " );
						String hoVaTen = sc.nextLine();
						System.out.println("Nam sinh(dd/MM/yyyy): " );
						String namSinhInput = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate namSinh = LocalDate.parse(namSinhInput,formatter);
						System.out.println("Gioi Tinh: " );
						String gioiTinh = sc.nextLine();
						System.out.println("So Dien Thoai: " );
						String soDienThoai = sc.nextLine();
						System.out.println("Truong Dang Hoc : ");
						String daiHoc = sc.nextLine();
						System.out.println("Chuyen nghanh: ");
						String chuyenNghanh = sc.nextLine();
						System.out.println("Da thoi viec chua: ");
						String daThoiViec = sc.nextLine();
						System.out.println("So Gio Lam: ");
						Float soGioLamViec = sc.nextFloat();
						ThucTapSinh tts = new ThucTapSinh("5"+maNhanVien, hoVaTen, namSinh, gioiTinh, soDienThoai, daThoiViec, soGioLamViec, daiHoc, chuyenNghanh);
						danhSach.addNhanSu(tts);}
					else if (chon == 6) {
						System.out.println("Moi nhap thong tin nhan su LAO DONG PHO THONG:");
						System.out.println("Ma Nhan Vien(6XXXX): ");
						String maNhanVien = sc.nextLine();
						System.out.println("Ho va Ten: " );
						String hoVaTen = sc.nextLine();
						System.out.println("Nam sinh(dd/MM/yyyy): " );
						String namSinhInput = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate namSinh = LocalDate.parse(namSinhInput,formatter);
						System.out.println("Gioi Tinh: " );
						String gioiTinh = sc.nextLine();
						System.out.println("So Dien Thoai: " );
						String soDienThoai = sc.nextLine();
						System.out.println("Bang Cap(Cap 0/ 2/ 3/ dai Hoc) : ");
						String bangCap = sc.nextLine();
						System.out.println("Da thoi viec chua: ");
						String daThoiViec = sc.nextLine();
						System.out.println("So Gio Lam: ");
						Float soGioLamViec = sc.nextFloat();
						LaoDongPhoThong ldpt = new LaoDongPhoThong("6" + maNhanVien, hoVaTen, namSinh, gioiTinh, soDienThoai, daThoiViec, soGioLamViec, bangCap);
						danhSach.addNhanSu(ldpt);}

					else if (chon == 7) {
						System.out.println("Moi nhap thong tin nhan su NHAN VIEN PARTIME:");
						System.out.println("Ma Nhan Vien(7XXXX): ");
						String maNhanVien = sc.nextLine();
						System.out.println("Ho va Ten: " );
						String hoVaTen = sc.nextLine();
						System.out.println("Nam sinh(dd/MM/yyyy): " );
						String namSinhInput = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate namSinh = LocalDate.parse(namSinhInput,formatter);
						System.out.println("Gioi Tinh: " );
						String gioiTinh = sc.nextLine();
						System.out.println("So Dien Thoai: " );
						String soDienThoai = sc.nextLine();
						System.out.println("Nang suat(So gio lam): ");
						int nangSuat = sc.nextInt();
						sc.nextLine();
						System.out.println("Da thoi viec chua: ");
						String daThoiViec = sc.nextLine();
						System.out.println("So Gio Lam: ");
						Float soGioLamViec = sc.nextFloat();
						NhanVienPartTime nvbtg = new NhanVienPartTime("7" + maNhanVien, hoVaTen, namSinh, gioiTinh, soDienThoai, daThoiViec, soGioLamViec, nangSuat);
						danhSach.addNhanSu(nvbtg); 
					}
					else if (chon == 8) {
						System.out.println("Moi nhap thong tin nhan su CAN BO QUAN LI");
						System.out.println("Ma Nhan Vien (8xxxx): ");
						String maNhanVien = sc.nextLine();
						System.out.println("Ho va Ten: " );
						String hoVaTen = sc.nextLine();
						System.out.println("Nam sinh(dd/MM/yyyy): " );
						String namSinhInput = sc.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate namSinh = LocalDate.parse(namSinhInput,formatter);
						System.out.println("Gioi Tinh: " );
						String gioiTinh = sc.nextLine();
						System.out.println("So Dien Thoai: " );
						String soDienThoai = sc.nextLine();
						System.out.println("Nam Kinh Nghiem: ");
						int namKinhNghiem = sc.nextInt();
						sc.nextLine();
						System.out.println("Da thoi viec chua: ");
						String daThoiViec = sc.nextLine();
						System.out.println("So Gio Lam: ");
						Float soGioLamViec = sc.nextFloat();
						CanBoQuanLy cbql = new CanBoQuanLy("8" + maNhanVien, hoVaTen, namSinh, soDienThoai, gioiTinh, daThoiViec, soGioLamViec, namKinhNghiem);
						danhSach.addNhanSu(cbql);
					}
					else if (chon == 0) {
						break;}
					else {
						System.out.println("Lua chon khong hop le. Hay chon tu 0 - 8 !");
					}}}

			//Liệt kê all nhân sự theo thứ tự alpha 
			else if (luachon == 2) {
				danhSach.listNhanSu();
			}

			//Tìm nhân sự theo tên
			else if (luachon == 3) {
				System.out.println("Nhap Ten nhan su can tim: ");
				String Ten = sc.nextLine();
				Ten = Ten.trim();

				ArrayList<ConNguoi> kq = danhSach.searchNhanSu(Ten);
				if (kq.size() == 0) 
					System.out.println("Khong tim thay NHAN SU nao ten: " + Ten);
				else 
					System.out.println("Ket Qua tim duoc: ");
				for (ConNguoi conNguoi : kq)
					System.out.println(conNguoi.toString());


			}


			//Sửa thông tin nhân sự khi nhập sai thông tin
			else if (luachon == 4) {
				System.out.println("Nhap Ho va Ten nhan su can Sua: ");
				String hoVaTen = sc.nextLine();
				danhSach.suaThongTin(hoVaTen);
			}

			//Xóa Nhân Sự đã thôi việc
			else if (luachon == 5) {
				danhSach.xoaNhanSuDaThoiViec();

			}

			//Tìm theo mã nhân viên				
			else if (luachon == 6) {
				System.out.println("Nhap MA NHAN VIEN can tim: ");
				String maNhanVien = sc.nextLine();
				ArrayList<ConNguoi> kq = danhSach.searchMaNhanVien(maNhanVien);
				if (kq.size() == 0) 
					System.out.println("Khong tim thay NHAN SU nao co ma nhan vien la: " + maNhanVien);
				else 
					System.out.println("Ket qua tim: ");
				for (ConNguoi conNguoi : kq) 
					System.out.println(conNguoi.toString());

			}

			//Tìm theo họ và tên
			else if (luachon == 7) {
				System.out.println("Nhap Vao Ho va Ten nhan su Muon Tim: ");
				String hoVaTen = sc.nextLine();
				hoVaTen = hoVaTen.trim();

				ArrayList<ConNguoi> kq = danhSach.searchNhanSuTheoHoVaTen(hoVaTen);
				if (kq.size() == 0) 
					System.out.println("Khong tim thay NHAN SU nao co ho va ten la: " + hoVaTen);
				else 
					System.out.println("Ket Qua tim duoc: ");
				for (ConNguoi conNguoi : kq) 
					System.out.println(conNguoi.toString());
			}
			//Liệt kê theo Đối tượng
			else if (luachon == 8) {

				while (true) {
					System.out.println("\t\tBan muon xem danh sach  NHAN SU nao ?");
					System.out.println("\t\t+----------------------------------------+");
					System.out.println("\t\t| 1.Danh Sach thong tin KY SU:           |\r\n"
							+ "\t\t| 2.Thong tin CONG NHAN:                 |\r\n"
							+ "\t\t| 3.Thong tin NHAN VIEN:                 |\r\n"
							+ "\t\t| 4.Thong tin CHUYEN GIA NUOC NGOAI:     |\r\n"
							+ "\t\t| 5.Thong tin THUC TAP SINH:             |\r\n"
							+ "\t\t| 6.Thong tin LAO DONG PHO THONG:        |\r\n"
							+ "\t\t| 7.Thong tin NHAN VIEN PARTIME:         |\r\n"
							+ "\t\t| 8.Thong tin CAN BO QUAN LI:            |\r\n"
							+ "\t\t| 0.Thoat khoi lua chon                  |\r\n"
							+ "\t\t+----------------------------------------+");   
					System.out.println("\t\tHay Nhap MA NHAN VIEN tuong ung :");
					String maNhanVien = sc.nextLine();
					if (maNhanVien.equals("0")) {
						break; // Thoát khỏi vòng lặp nếu người dùng chọn 0
					} else if (maNhanVien.equals("1")) {
						danhSach.lietKeNhanSuTheoMa(maNhanVien);
					} else if (maNhanVien.equals("2")) {
						danhSach.lietKeNhanSuTheoMa(maNhanVien);
					} else if (maNhanVien.equals("3")) {
						danhSach.lietKeNhanSuTheoMa(maNhanVien);
					} else if (maNhanVien.equals("4")) {
						danhSach.lietKeNhanSuTheoMa(maNhanVien);
					} else if (maNhanVien.equals("5")) {
						danhSach.lietKeNhanSuTheoMa(maNhanVien);
					} else if (maNhanVien.equals("6")) {
						danhSach.lietKeNhanSuTheoMa(maNhanVien);
					} else if (maNhanVien.equals("7")) {
						danhSach.lietKeNhanSuTheoMa(maNhanVien);
					} else if (maNhanVien.equals("8")) {
						danhSach.lietKeNhanSuTheoMa(maNhanVien);
					} else {
						System.out.println("Lua chon khong hop le. Hay chon tu 0 - 8 !");
					}}}

			//Tong luong thang cua tung doi tuong
			else if (luachon == 9) {
				danhSach.TongLuongThang();
			}

			//Luong trung binh cua ca cong ty
			else if (luachon == 10) {
				danhSach.luongTrungBinh();
			}

			//Luong trung binh cua tung doi tuong
			else if (luachon == 11) {
				danhSach.tinhLuongTrungBinhCuaTungDoiTuong();
			}

			//Liet ke theo ngay sinh(Nguoi cao tuoi hien thi truoc)
			else if (luachon == 12) {
				danhSach.listNhanSuTheoTuoi();
			}


			//Tuoi trung binh cua cong ty 
			else if (luachon == 13) {
				double ketQua = danhSach.tinhDoTuoiTrungBinh();
				if (ketQua == 0.0)
					System.out.println("Khong ton tai nhan su de tinh tuoi trung binh !");
				else 
					System.out.println("So tuong trung binh cua cong ty: " + danhSach.tinhDoTuoiTrungBinh());	


			}
			//Người trẻ nhất và lớn tuổi nhất trong công ty
			else if (luachon == 14) {
				danhSach.timNguoiTreNhatVaLonTuoiNhat();
			}
			else if (luachon ==0) {
				break;
			}
			else {
				System.out.println("Lua chon khong hop le. Hay chon tu 0 - 14 !");
			}

		}		
	}
}
