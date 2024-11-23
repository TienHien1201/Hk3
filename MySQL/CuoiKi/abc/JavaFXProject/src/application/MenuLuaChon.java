package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;
import quanLiNhanSu.CanBoQuanLy;
import quanLiNhanSu.ChuyenGiaNuocNgoai;
import quanLiNhanSu.ConNguoi;
import quanLiNhanSu.CongNhan;
import quanLiNhanSu.KySu;
import quanLiNhanSu.LaoDongPhoThong;
import quanLiNhanSu.NhanVien;
import quanLiNhanSu.NhanVienPartTime;
import quanLiNhanSu.ThucTapSinh;

public class MenuLuaChon extends Application {
	private TableView<ConNguoi> tableView;
	private TableView<ConNguoi> tableViewDEMO;
	private ObservableList<ConNguoi> danhSachNhanSu;
	private ComboBox<String> loaiNhanSu;
	private TextField maSoNhanVien;
	private TextField hoVaTen;
	private DatePicker namSinh;
	private ToggleButton yes;
	private ToggleButton no;
	private ToggleButton nam;
	private ToggleButton nu;
	private TextField soDienThoai;
	private TextField soGioLamViec;
	private TextField chuyenNganh;
	private TextField daiHoc;
	private TextField congViecChinh;
	private TextField capBac;
	private TextField bangCap;
	private TextField namSuat;
	private TextField quocTich;
	private TextField hanViSa;
	private TextField namKinhNghiem;
	private TextField thamNien;
	private String s;
	Scene scene;
	Group gr;

	@Override
	public void start(Stage primaryStage) {

		gr = new Group();
		MenuBar menuBar = new MenuBar();
		Menu menu3 = new Menu("Help");	
		MenuItem item31 = new MenuItem("Trang Chủ");
		MenuItem item32 = new MenuItem("Trợ Giúp");
		
		Menu menu1 = new Menu("Nhân Sự");
		

		MenuItem item1 = new MenuItem("Quản Lý Nhân Sự");
	
		menu3.getItems().addAll(item31, item32);
		menu1.getItems().addAll(item1);
		menuBar.getMenus().addAll(menu3,menu1);

		danhSachNhanSu = FXCollections.observableArrayList();
		tableView = new TableView<>();
		tableView.setEditable(true);
		tableViewDEMO = new TableView<>();
		tableViewDEMO.setEditable(true);

		TextField timNS = new TextField();
		timNS.setPromptText("Mã NS");
		Label labelLoaiNS = new Label("Nhân Sự");
		loaiNhanSu = new ComboBox<>();
		loaiNhanSu.getItems().addAll("Cán Bộ Quản Lí", "Chuyên Gia Nước Ngoài", "Công Nhân", "Kỹ Sư",
				"Lao Động Phổ Thông", "Nhân Viên", "Nhân Viên PartTime", "Thực Tập Sinh");
		loaiNhanSu.setPromptText("Click Nhân Sự");

		Label lableID = new Label("Mã Nhân Sự");
		maSoNhanVien = new TextField();

		Label labelName = new Label("Họ Và Tên");
		hoVaTen = new TextField();

		Label labelNS = new Label("Ngày Sinh");
		namSinh = new DatePicker();
		
		Label labelGT = new Label("Giới Tính");
		nam = new ToggleButton("Nam");
		nu = new ToggleButton("Nữ");
		ToggleGroup groupReservation = new ToggleGroup();
		nam.setToggleGroup(groupReservation);
		nu.setToggleGroup(groupReservation);

		Label labelSDT = new Label("Phone");
		soDienThoai = new TextField();

		Label labelDaThoiViec = new Label("Trạng Thái");
		yes = new ToggleButton("Đã Thôi Việc");
		no = new ToggleButton("Chưa Thôi Việc");
		ToggleGroup groupReservationa = new ToggleGroup();
		yes.setToggleGroup(groupReservationa);
		no.setToggleGroup(groupReservationa);

		Label labelSoGioLam = new Label("Số Giờ Làm");
		soGioLamViec = new TextField();

		Label labeldaiHoc = new Label("Đại Học");
		daiHoc = new TextField();

		Label labelchuyenNganh = new Label("Chuyên Ngành");
		chuyenNganh = new TextField();

		Label labelquocTich = new Label("Quốc Tịch");
		quocTich = new TextField();

		Label labelhanViSa = new Label("Hạn ViSA");
		hanViSa = new TextField();

		Label labelcongViecChinh = new Label("Công Việc Chính");
		congViecChinh = new TextField();

		Label labelcapBac = new Label("Cấp Bậc");
		capBac = new TextField();

		Label labelbangCap = new Label("Bằng Cấp");
		bangCap = new TextField();

		Label labelloaiCongViec = new Label("Năng Suất");
		namSuat = new TextField();

		Label labelnamKinhNghiem = new Label("Năm Kinh Nghiệm");
		namKinhNghiem = new TextField();

		Label labelthamnien = new Label("Thâm Niên");
		thamNien = new TextField();
		Button button1 = new Button("Thêm NS");

		Button button2 = new Button("Xóa NS");
		// table view

		

		TableColumn<ConNguoi, String> maNhanSu = new TableColumn<>("MãNS");
		maNhanSu.setCellValueFactory(new PropertyValueFactory<>("maNhanVien"));
		maNhanSu.setCellFactory(TextFieldTableCell.forTableColumn());
		maNhanSu.setOnEditCommit(ec -> {
			TablePosition<ConNguoi, String> pos = ec.getTablePosition();
			String newID = ec.getNewValue();
			int row = pos.getRow();
			ConNguoi porson = ec.getTableView().getItems().get(row);
			porson.setMaNhanVien(newID);
		});

		TableColumn<ConNguoi, String> nameNhanSu = new TableColumn<>("TênNS");
		nameNhanSu.setCellValueFactory(new PropertyValueFactory<>("hoVaTen"));
		nameNhanSu.setCellFactory(TextFieldTableCell.forTableColumn());
		nameNhanSu.setOnEditCommit(ec -> {
			TablePosition<ConNguoi, String> pos = ec.getTablePosition();
			String newName = ec.getNewValue();
			int row = pos.getRow();
			ConNguoi porson = ec.getTableView().getItems().get(row);
			porson.setHoVaTen(newName);
		});

		TableColumn<ConNguoi, LocalDate> namSinhNhanSu = new TableColumn<>("NămSinh");
		namSinhNhanSu.setCellValueFactory(new PropertyValueFactory<>("namSinh"));
		namSinhNhanSu.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
		namSinhNhanSu.setOnEditCommit(ec -> {
			TablePosition<ConNguoi, LocalDate> pos = ec.getTablePosition();
			LocalDate newNS = ec.getNewValue();
			int row = pos.getRow();
			ConNguoi person = ec.getTableView().getItems().get(row);
			person.setNamSinh(newNS);
		});

		TableColumn<ConNguoi, String> gioiTinhNhanSu = new TableColumn<>("GiớiTính");
		gioiTinhNhanSu.setCellValueFactory(new PropertyValueFactory<>("goiTinh"));
		gioiTinhNhanSu.setCellFactory(TextFieldTableCell.forTableColumn());
		gioiTinhNhanSu.setOnEditCommit(ec -> {
			TablePosition<ConNguoi, String> pos = ec.getTablePosition();
			String newgt = ec.getNewValue();
			int row = pos.getRow();
			ConNguoi porson = ec.getTableView().getItems().get(row);
			porson.setGoiTinh(newgt);

		});

		TableColumn<ConNguoi, String> soDienThoaiNhanSu = new TableColumn<>("Phone");
		soDienThoaiNhanSu.setCellValueFactory(new PropertyValueFactory<>("soDienThoai"));
		soDienThoaiNhanSu.setCellFactory(TextFieldTableCell.forTableColumn());
		soDienThoaiNhanSu.setOnEditCommit(ec -> {
			TablePosition<ConNguoi, String> pos = ec.getTablePosition();
			String newsdt = ec.getNewValue();
			int row = pos.getRow();
			ConNguoi porson = ec.getTableView().getItems().get(row);
			porson.setSoDienThoai(newsdt);
		});

		TableColumn<ConNguoi, String> trangThaiNhanSu = new TableColumn<>("TrạngThái");
		trangThaiNhanSu.setCellValueFactory(new PropertyValueFactory<>("daThoiViec"));
		trangThaiNhanSu.setCellFactory(TextFieldTableCell.forTableColumn());
		trangThaiNhanSu.setOnEditCommit(ec -> {
			TablePosition<ConNguoi, String> pos = ec.getTablePosition();
			String newTT = ec.getNewValue();
			int row = pos.getRow();
			ConNguoi porson = ec.getTableView().getItems().get(row);
			porson.setDaThoiViec(newTT);
		});

		TableColumn<ConNguoi, Float> soGioLam = new TableColumn<>("SốGiờLàm");
		soGioLam.setCellValueFactory(new PropertyValueFactory<>("soGioLamViec"));
		soGioLam.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
		soGioLam.setOnEditCommit(ec -> {
			TablePosition<ConNguoi, Float> pos = ec.getTablePosition();
			float newgl = ec.getNewValue();
			int row = pos.getRow();
			ConNguoi porson = ec.getTableView().getItems().get(row);
			porson.setSoGioLamViec(newgl);
		});

		TableColumn<ConNguoi, String> chuyenNganhView1 = new TableColumn<>("Chuyên Ngành");
		chuyenNganhView1.setCellFactory(TextFieldTableCell.forTableColumn());
		TableColumn<ConNguoi, String> daiHocView = new TableColumn<>("ĐạiHọc");
		daiHocView.setCellFactory(TextFieldTableCell.forTableColumn());
		TableColumn<ConNguoi, String> congViecView = new TableColumn<>("CVChính");
		congViecView.setCellFactory(TextFieldTableCell.forTableColumn());
		TableColumn<ConNguoi, String> capBacView = new TableColumn<>("CấpBậc");
		capBacView.setCellFactory(TextFieldTableCell.forTableColumn());
		TableColumn<ConNguoi, String> bangCapView = new TableColumn<>("BằngCấp");
		bangCapView.setCellFactory(TextFieldTableCell.forTableColumn());
		TableColumn<ConNguoi, Integer> loaiCongViecView = new TableColumn<>("Năng Suất");
		loaiCongViecView.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		TableColumn<ConNguoi, String> quocTichView = new TableColumn<>("QuốcTịch");
		quocTichView.setCellFactory(TextFieldTableCell.forTableColumn());
		TableColumn<ConNguoi, String> hanVSView = new TableColumn<>("HạnVS");
		hanVSView.setCellFactory(TextFieldTableCell.forTableColumn());
		TableColumn<ConNguoi, Integer> thamNienView = new TableColumn<>("ThâmNiên");
		thamNienView.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		TableColumn<ConNguoi, Integer> kinhNghiemView	 = new TableColumn<>("NămKN");
		thamNienView.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		
		// sắp xếp tableview
					tableView.getSortOrder().add(nameNhanSu);
					tableView.getSortOrder().add(namSinhNhanSu);
					nameNhanSu.setSortType(SortType.ASCENDING);
					namSinhNhanSu.setSortType(SortType.ASCENDING);
					namSinhNhanSu.setSortable(true);
					nameNhanSu.setSortable(true);
					maNhanSu.setSortable(false);
					soDienThoaiNhanSu.setSortable(false);
					soGioLam.setSortable(false);
					trangThaiNhanSu.setSortable(false);
					gioiTinhNhanSu.setSortable(false);
					chuyenNganhView1.setSortable(false);
					capBacView.setSortable(false);
					bangCapView.setSortable(false);
					loaiCongViecView.setSortable(false);
					hanVSView.setSortable(false);
					daiHocView.setSortable(false);
					thamNienView.setSortable(false);
					quocTichView.setSortable(false);
					congViecView.setSortable(false);
		// quản lý nhân sự
		item1.setOnAction(e -> {
			gr.getChildren().clear();
			tableView.getColumns().clear();
			tableView.setItems(danhSachNhanSu);
			
			tableView.sort();
			tableView.setPrefHeight(200);
			tableView.getColumns().addAll(maNhanSu, nameNhanSu, namSinhNhanSu, gioiTinhNhanSu, soDienThoaiNhanSu,
					soGioLam, chuyenNganhView1, bangCapView, capBacView, loaiCongViecView, congViecView, hanVSView,
					quocTichView, daiHocView, thamNienView, kinhNghiemView, trangThaiNhanSu);
			
			HBox hbox2 = new HBox(70, yes, no);
			HBox hbox1 = new HBox(70, nam, nu);
			GridPane gird = new GridPane();
			gird.add(labelLoaiNS, 0, 0);
			gird.add(loaiNhanSu, 1, 0);
			gird.add(labelthamnien, 3, 0);
			gird.add(thamNien, 4, 0);
			gird.add(lableID, 0, 1);
			gird.add(maSoNhanVien, 1, 1);
			gird.add(labelName, 0, 2);
			gird.add(hoVaTen, 1, 2);
			gird.add(labelNS, 0, 3);
			gird.add(namSinh, 1, 3);
			gird.add(labelGT, 0, 4);
			gird.add(hbox1, 1, 4);
			gird.add(labelSDT, 0, 5);
			gird.add(soDienThoai, 1, 5);
			gird.add(labelchuyenNganh, 0, 6);
			gird.add(chuyenNganh, 1, 6);
			gird.add(labeldaiHoc, 0, 7);
			gird.add(daiHoc, 1, 7);
			gird.add(labelquocTich, 0, 8);
			gird.add(quocTich, 1, 8);
			gird.add(labelhanViSa, 3, 1);
			gird.add(hanViSa, 4, 1);
			gird.add(labelbangCap, 3, 2);
			gird.add(bangCap, 4, 2);
			gird.add(labelcapBac, 3, 3);
			gird.add(capBac, 4, 3);
			gird.add(labelcongViecChinh, 3, 4);
			gird.add(congViecChinh, 4, 4);
			gird.add(labelnamKinhNghiem, 3, 5);
			gird.add(namKinhNghiem, 4, 5);
			gird.add(labelloaiCongViec, 3, 6);
			gird.add(namSuat, 4, 6);
			gird.add(labelDaThoiViec, 3, 7);
			gird.add(hbox2, 4, 7);
			gird.add(labelSoGioLam, 3, 8);
			gird.add(soGioLamViec, 4, 8);
			gird.add(button1, 7, 2);
			gird.add(button2, 8, 2);

			gird.setVgap(15);
			gird.setHgap(35);
			gird.setPadding(new Insets(20, 150, 10, 10));
			VBox hbox = new VBox(menuBar, tableView, gird);
			gr.getChildren().addAll(hbox);
			docFile();
		});
		// sử lý sự kiện loại nhân sự
		loaiNhanSu.setOnAction(event -> {	
			suKienLoaiNhanSu();
			s = loaiNhanSu.getValue();
		});

		button1.setOnAction(an -> {
			// thông báo khi để trống

			String hoVaTenValue = hoVaTen.getText();
			String maSoNhanVienValue = maSoNhanVien.getText();
			String gioiTinhValue = nam.isSelected() ? nam.getText() : nu.getText();
			String soDienThoaiValue = soDienThoai.getText();
			String trangThaiValue = yes.isSelected() ? yes.getText() : no.getText();
			String soGioLamViecValuea = soGioLamViec.getText();
		
			if (hoVaTenValue.isEmpty() || maSoNhanVienValue.isEmpty() || gioiTinhValue.isEmpty()
					|| soDienThoaiValue.isEmpty() || soGioLamViecValuea.isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Lỗi");
				alert.setHeaderText(null);
				alert.setContentText("Không được để trống!");
				alert.showAndWait();
				return;
			} 
			
			if (soGioLamViecValuea.isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Lỗi");
				alert.setHeaderText(null);
				alert.setContentText("Số giờ làm việc không được để trống!");
				alert.showAndWait();
				return;
			}
			LocalDate ngaySinhValue = namSinh.getValue();
			if (ngaySinhValue == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Lỗi");
				alert.setHeaderText(null);
				alert.setContentText("Vui lòng chọn ngày sinh!");
				alert.showAndWait();
				return;
			}
			ThongBao();
			String ID = maSoNhanVien.getText();
			String Name = hoVaTen.getText();
			LocalDate namSinhs = namSinh.getValue();
			String gioiTinh1 = "";
			if (nam.isSelected()) {
				gioiTinh1 = nam.getText();
			} else if (nu.isSelected()) {
				gioiTinh1 = nu.getText();
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Lỗi");
				alert.setHeaderText(null);
				alert.setContentText("Vui lòng chọn giới tính!");
				alert.showAndWait();
				return;
			}
			String sDT = soDienThoai.getText();
			String trangThai = "";
			String chuyenNganhValue = chuyenNganh.getText();
			if (yes.isSelected()) {
				trangThai = yes.getText();
			} else if (no.isSelected()) {
				trangThai = no.getText();
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Lỗi");
				alert.setHeaderText(null);
				alert.setContentText("Vui lòng chọn trạng thái!");
				alert.showAndWait();
				return;
			}
			float soGio1 = Float.parseFloat(soGioLamViec.getText());
			String bangCapValue = bangCap.getText();
			String capBacValue = capBac.getText();
			String congViecChinhValue = congViecChinh.getText();
			String daiHocValue = daiHoc.getText();
			String quocTichValue = quocTich.getText();
			String hanViSaValue = hanViSa.getText();


			chuyenNganhView1.setCellValueFactory(null);
			congViecView.setCellValueFactory(null);
			kinhNghiemView.setCellValueFactory(null);
			thamNienView.setCellValueFactory(null);
			quocTichView.setCellValueFactory(null);
			hanVSView.setCellValueFactory(null);
			capBacView.setCellValueFactory(null);
			bangCapView.setCellValueFactory(null);
			loaiCongViecView.setCellValueFactory(null);
			daiHocView.setCellValueFactory(null);
			if (s.equals("Kỹ Sư")) {
				chuyenNganhView1.setCellValueFactory(new PropertyValueFactory<>("chuyenNghanh"));
				ConNguoi connguoi = new KySu("KS" + ID, Name, namSinhs, gioiTinh1, sDT, trangThai, soGio1,
						chuyenNganhValue);
				danhSachNhanSu.add(connguoi);

			} else if (s.equals("Cán Bộ Quản Lí")) {
				int namKinhNghiemValuea = Integer.valueOf(namKinhNghiem.getText());
				kinhNghiemView.setCellValueFactory(new PropertyValueFactory<>("namKinhNghiem"));
				CanBoQuanLy cb = new CanBoQuanLy("CBQL" +ID, Name, namSinhs, gioiTinh1, sDT, trangThai, soGio1,
						namKinhNghiemValuea);
				danhSachNhanSu.add(cb);
			} else if (s.equals("Chuyên Gia Nước Ngoài")) {
				int thamNienn = Integer.valueOf(thamNien.getText());
				thamNienView.setCellValueFactory(new PropertyValueFactory<>("thamNien"));
				chuyenNganhView1.setCellValueFactory(new PropertyValueFactory<>("chuyenNghanh"));
				quocTichView.setCellValueFactory(new PropertyValueFactory<>("quocTich"));
				hanVSView.setCellValueFactory(new PropertyValueFactory<>("hanViSa"));
				ChuyenGiaNuocNgoai cgnc = new ChuyenGiaNuocNgoai("CGNN"+ID, Name, namSinhs, gioiTinh1, sDT, trangThai,
						soGio1, chuyenNganhValue, thamNienn, quocTichValue, hanViSaValue);
				danhSachNhanSu.add(cgnc);
			} else if (s.equals("Công Nhân")) {
				capBacView.setCellValueFactory(new PropertyValueFactory<>("capBac"));
				CongNhan cn = new CongNhan("CN"+ID, Name, namSinhs, gioiTinh1, sDT, trangThai, soGio1, capBacValue);
				danhSachNhanSu.add(cn);
			} else if (s.equals("Lao Động Phổ Thông")) {
				bangCapView.setCellValueFactory(new PropertyValueFactory<>("bangCap"));
				LaoDongPhoThong ldpt = new LaoDongPhoThong("LDPT"+ID, Name, namSinhs, gioiTinh1, sDT, trangThai, soGio1,
						bangCapValue);
				danhSachNhanSu.add(ldpt);
			} else if (s.equals("Nhân Viên")) {
				congViecView.setCellValueFactory(new PropertyValueFactory<>("conViecChinh"));
				NhanVien nv = new NhanVien("NV"+ID, Name, namSinhs, gioiTinh1, sDT, trangThai, soGio1,
						congViecChinhValue);
				danhSachNhanSu.add(nv);

			} else if (s.equals("Nhân Viên PartTime")) {
				int nangSuat = Integer.valueOf(namSuat.getText());
				loaiCongViecView.setCellValueFactory(new PropertyValueFactory<>("nangSuat"));
				NhanVienPartTime nvpt = new NhanVienPartTime("NVPT"+ID, Name, namSinhs, gioiTinh1, sDT, trangThai, soGio1,
						nangSuat);
				danhSachNhanSu.add(nvpt);
			} else if (s.equals("Thực Tập Sinh")) {
				chuyenNganhView1.setCellValueFactory(new PropertyValueFactory<>("chuyenNghanh"));
				daiHocView.setCellValueFactory(new PropertyValueFactory<>("daiHoc"));
				ThucTapSinh tts = new ThucTapSinh("TTS"+ID, Name, namSinhs, gioiTinh1, sDT, trangThai, soGio1,
						daiHocValue, chuyenNganhValue);
				danhSachNhanSu.add(tts);
			}
			
			tableView.setItems(danhSachNhanSu);
			Cler();
			ghiFile();
		});
		button2.setOnAction(ent -> {
			xoaNS();
			ghiFile();
		});
		//trang chủ
		item31.setOnAction(aas ->{
			gr.getChildren().clear();
			Text tenDOAn = new Text(190, 90, "Đồ Án Môn Học OOP");
			tenDOAn.setStroke(Color.BLUE);
			tenDOAn.setFill(Color.WHITE);
			tenDOAn.setStrokeWidth(2);
			tenDOAn.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 47));
			tenDOAn.setTranslateX(350);
			
			Label an = new Label("Đào Tuấn An");
			Label mssvan = new Label("22150316");
			Label hien = new Label("Phạm Tiến Hiền");
			Label mssvh= new Label("22150319");
			Label thanh = new Label("Lê Trung Thành");
			Label mssvt = new Label("22150329");
			
			an.setFont(Font.font("Arial", FontWeight.BOLD, 18));
			mssvan.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
			hien.setFont(Font.font("Arial", FontWeight.BOLD, 18));
			mssvh.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
			thanh.setFont(Font.font("Arial", FontWeight.BOLD, 18));
			mssvt.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
			
			HBox hboxa = new HBox(10,an,mssvan);
			HBox hboxb = new HBox(10,hien,mssvh);
			HBox hboxc = new HBox(10,thanh,mssvt);
			VBox vboxaa = new VBox(10,hboxa,hboxb,hboxc);
			vboxaa.setTranslateX(650);
			vboxaa.setTranslateY(150);
			gr.getChildren().addAll(menuBar,tenDOAn,vboxaa);
		});
		item32.setOnAction(aza -> {
			gr.getChildren().clear();
			Label an = new Label("Mọi Thắc Mắc Xin Liên Hệ:");
			Label mssvan = new Label("gmail: daotuanan2004@gmail.com");
			Label hien = new Label("facebook: https://www.facebook.com/yongi3010/");
			an.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			mssvan.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
			hien.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

			VBox vboxaa = new VBox(10,mssvan,hien);
			HBox hboxc = new HBox(10,an,vboxaa );
			 hboxc.setTranslateX(350);
			 hboxc.setTranslateY(140);
			gr.getChildren().addAll(menuBar,hboxc);
		});
		Text tenDOAn = new Text(190, 90, "Đồ Án Môn Học OOP");
		tenDOAn.setStroke(Color.BLUE);
		tenDOAn.setFill(Color.WHITE);
		tenDOAn.setStrokeWidth(2);
		tenDOAn.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 47));
		tenDOAn.setTranslateX(350);
		
		Label an = new Label("Đào Tuấn An");
		Label mssvan = new Label("22150316");
		Label hien = new Label("Phạm Tiến Hiền");
		Label mssvh= new Label("22150319");
		Label thanh = new Label("Lê Trung Thành");
		Label mssvt = new Label("22150329");
		
		an.setFont(Font.font("Arial", FontWeight.BOLD, 18));
		mssvan.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
		hien.setFont(Font.font("Arial", FontWeight.BOLD, 18));
		mssvh.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
		thanh.setFont(Font.font("Arial", FontWeight.BOLD, 18));
		mssvt.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
		
		HBox hboxa = new HBox(10,an,mssvan);
		HBox hboxb = new HBox(10,hien,mssvh);
		HBox hboxc = new HBox(10,thanh,mssvt);
		VBox vboxaa = new VBox(10,hboxa,hboxb,hboxc);
		vboxaa.setTranslateX(650);
		vboxaa.setTranslateY(150);
		gr.getChildren().addAll(tenDOAn, menuBar,vboxaa);
		Scene scene = new Scene(gr, 1500, 700);
		scene.setFill(Color.ALICEBLUE);
		primaryStage.setTitle("Nhân Sự");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	public void sukien() {

	}
	public void Cler() {
		maSoNhanVien.clear();
		hoVaTen.clear();
		namSinh.setValue(null);
		nam.setSelected(false);
		nu.setSelected(false);
		yes.setSelected(false);
		no.setSelected(false);
		soDienThoai.clear();
		soGioLamViec.clear();
		chuyenNganh.clear();
		daiHoc.clear();
		congViecChinh.clear();
		capBac.clear();
		bangCap.clear();
		namSuat.clear();
		quocTich.clear();
		hanViSa.clear();
		namKinhNghiem.clear();
		thamNien.clear();
	}

	public void ghiFile() {
		try {
			// Tạo một FileWriter để ghi dữ liệu vào tệp tin
			FileWriter fileWriter = new FileWriter("NhanSu1.dat");
			// Tạo một BufferedWriter để cung cấp các phương thức ghi dữ liệu nâng cao
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			// Lặp qua danh sách nhân sự và ghi từng bản ghi vào tệp tin
			for (ConNguoi nguoi : danhSachNhanSu) {
				String line = nguoi.getMaNhanVien() + "," + nguoi.getHoVaTen() + "," + nguoi.getNamSinh() + ","
						+ nguoi.getGoiTinh() + "," + nguoi.getSoDienThoai() + "," + nguoi.getDaThoiViec() + ","
						+ nguoi.getSoGioLamViec();

				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
			// Đóng BufferedWriter để lưu các thay đổi và giải phóng tài nguyên
			bufferedWriter.close();
			System.out.println("Ghi dữ liệu từ tệp tin thành công!");
		} catch (IOException e1) {
			// Xử lý ngoại lệ nếu có lỗi trong quá trình ghi dữ liệu
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Lỗi");
			alert.setHeaderText(null);
			alert.setContentText("Đã xảy ra lỗi khi ghi dữ liệu vào tệp tin!");
			alert.showAndWait();
		}
	}

	public void docFile() {
		try {
			// Tạo một FileReader để đọc dữ liệu từ tệp tin
			FileReader fileReader = new FileReader("NhanSu1.dat");
			// Tạo một BufferedReader để cung cấp các phương thức đọc dữ liệu nâng cao
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				// Xử lý dòng dữ liệu
				String[] data = line.split(",");
				if (data.length == 7) {
					String maNhanVien = data[0];
					String hoVaTen = data[1];
					LocalDate namSinh = LocalDate.parse(data[2]);
					String gioiTinh = data[3];
					String soDienThoai = data[4];
					String daThoiViec = data[5];
					float soGioLamViec = Float.parseFloat(data[6]);
					// Thêm dữ liệu vào danh sách nhân sự hoặc xử lý theo nhu cầu của bạn
					ConNguoi nguoi = new ConNguoi(maNhanVien, hoVaTen, namSinh, gioiTinh, soDienThoai, daThoiViec,
							soGioLamViec);
					danhSachNhanSu.add(nguoi);
				}
			}
			// Đóng BufferedReader để giải phóng tài nguyên
			bufferedReader.close();
		} catch (IOException e) {
			// Xử lý ngoại lệ nếu có lỗi trong quá trình đọc dữ liệu
			System.out.println("Lỗi" + e.getMessage());
		}
	}

	public void xoaNS() {
		ConNguoi selectedNhanSu = tableView.getSelectionModel().getSelectedItem();
		if (selectedNhanSu != null) {
			danhSachNhanSu.remove(selectedNhanSu);
		}
	}

	public void suKienLoaiNhanSu() {
		// Kích hoạt tất cả các trường textfield
		String s = loaiNhanSu.getValue();
		chuyenNganh.setDisable(false);
		daiHoc.setDisable(false);
		congViecChinh.setDisable(false);
		capBac.setDisable(false);
		bangCap.setDisable(false);
		namSuat.setDisable(false);
		quocTich.setDisable(false);
		hanViSa.setDisable(false);
		namKinhNghiem.setDisable(false);
		thamNien.setDisable(false);

		if (s.equals("Kỹ Sư")) {
			daiHoc.setDisable(true);
			congViecChinh.setDisable(true);
			capBac.setDisable(true);
			bangCap.setDisable(true);
			namSuat.setDisable(true);
			quocTich.setDisable(true);
			hanViSa.setDisable(true);
			namKinhNghiem.setDisable(true);
			thamNien.setDisable(true);

		} else if (s.equals("Cán Bộ Quản Lí")) {
			chuyenNganh.setDisable(true);
			daiHoc.setDisable(true);
			congViecChinh.setDisable(true);
			capBac.setDisable(true);
			bangCap.setDisable(true);
			namSuat.setDisable(true);
			quocTich.setDisable(true);
			hanViSa.setDisable(true);
			thamNien.setDisable(true);

		} else if (s.equals("Chuyên Gia Nước Ngoài")) {
			daiHoc.setDisable(true);
			congViecChinh.setDisable(true);
			capBac.setDisable(true);
			bangCap.setDisable(true);
			namSuat.setDisable(true);
			namKinhNghiem.setDisable(true);

		} else if (s.equals("Công Nhân")) {
			chuyenNganh.setDisable(true);
			daiHoc.setDisable(true);
			congViecChinh.setDisable(true);
			bangCap.setDisable(true);
			namSuat.setDisable(true);
			quocTich.setDisable(true);
			hanViSa.setDisable(true);
			namKinhNghiem.setDisable(true);
			thamNien.setDisable(true);
		} else if (s.equals("Lao Động Phổ Thông")) {
			chuyenNganh.setDisable(true);
			capBac.setDisable(true);
			daiHoc.setDisable(true);
			congViecChinh.setDisable(true);
			namSuat.setDisable(true);
			quocTich.setDisable(true);
			hanViSa.setDisable(true);
			namKinhNghiem.setDisable(true);
			thamNien.setDisable(true);
		} else if (s.equals("Nhân Viên")) {
			chuyenNganh.setDisable(true);
			capBac.setDisable(true);
			daiHoc.setDisable(true);
			namSuat.setDisable(true);
			quocTich.setDisable(true);
			hanViSa.setDisable(true);
			namKinhNghiem.setDisable(true);
			bangCap.setDisable(true);
			thamNien.setDisable(true);
		} else if (s.equals("Nhân Viên PartTime")) {
			chuyenNganh.setDisable(true);
			capBac.setDisable(true);
			daiHoc.setDisable(true);
			quocTich.setDisable(true);
			hanViSa.setDisable(true);
			namKinhNghiem.setDisable(true);
			bangCap.setDisable(true);
			congViecChinh.setDisable(true);
			thamNien.setDisable(true);
		} else if (s.equals("Thực Tập Sinh")) {
			capBac.setDisable(true);
			quocTich.setDisable(true);
			hanViSa.setDisable(true);
			namKinhNghiem.setDisable(true);
			bangCap.setDisable(true);
			congViecChinh.setDisable(true);
			namSuat.setDisable(true);
			thamNien.setDisable(true);
		}
	}

	public void ThongBao() {

		try {
			float soGioLamViecValue = Float.parseFloat(soGioLamViec.getText());
		} catch (NumberFormatException e1) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Lỗi");
			alert.setHeaderText(null);
			alert.setContentText("Số giờ không hợp lệ!");
			alert.showAndWait();
			return;
		}
		String LoaiNS = loaiNhanSu.getValue();
		if (LoaiNS.equals("Cán Bộ Quản Lí")) {
			try {
				int namKinhNghiemValuea = Integer.valueOf(namKinhNghiem.getText());
			} catch (NumberFormatException e1) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Lỗi");
				alert.setHeaderText(null);
				alert.setContentText("Năm kinh nghiệm không hợp lệ!");
				alert.showAndWait();
				return;
			}
		}
		if (LoaiNS.equals("Chuyên Gia Nước Ngoài")) {
			try {
				int thamNienn = Integer.valueOf(thamNien.getText());
			} catch (NumberFormatException e1) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Lỗi");
				alert.setHeaderText(null);
				alert.setContentText("Thâm Niên không hợp lệ!");
				alert.showAndWait();
				return;
			}
		}
	}

}
//public class MenuLuaChon extends Application {
//
//	@Override
//	public void start(Stage stage) throws Exception {
//		//Chuẩn bị đạo cụ: Tạo thanh Menu các mục
//		MenuBar menuBar = new MenuBar();
//
//		Menu menu1 = new Menu("Nhan Su");
//		MenuItem item1_1 = new MenuItem("Them Nhan Su");
//		MenuItem item1_2 = new MenuItem("Xoa Nhan Su");
//		MenuItem item1_3 = new MenuItem("Liet Ke Nhan Su");
//		menu1.getItems().addAll(item1_1, item1_2, item1_3);
//
//		Menu menu2 = new Menu("Thong Ke");
//		MenuItem item2_1 = new MenuItem("Muc Luong");
//		MenuItem item2_2 = new MenuItem("Thanh Tuu");
//		menu2.getItems().addAll(item2_1, item2_2);
//
//		Menu menu3 = new Menu("Tro Giup");
//
//		//Tên đồ án
//		Text tenDoAn = new Text(190, 90,"Ung Dung Quan Li Nhan Su");
//		tenDoAn.setStroke(Color.BLUE);
//		tenDoAn.setFill(Color.AQUAMARINE);
//		tenDoAn.setStrokeWidth(2);
//		tenDoAn.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR,47));
//
//		//Đưa tất cả đạo cụ vào nhóm
//		Group group = new Group();
//		menuBar.getMenus().addAll(menu1,menu2,menu3);
//		group.getChildren().addAll(menuBar,tenDoAn);
//		//Bắt sự kiện và xử lí khi chọn các mục
//		item1_1.setOnAction(e ->{
//			Label label = new Label("Ban vua chon muc them nhan su");
//			label.setLayoutX(50);
//			label.setLayoutY(150);
//
//			group.getChildren().addAll(label);
//		});
//
//		item1_2.setOnAction(e ->{
//			Label label = new Label("Ban vua chon muc xoa nhan su");
//			label.setLayoutX(50);
//			label.setLayoutY(170);
//			
//			group.getChildren().addAll(label);
//		});
//
//		
//		//Trình diễn lên sân khấu
//		Scene scene = new Scene(group,900, 600);
//		
//		stage.setTitle("Menu");
//		stage.setScene(scene);
//		stage.show();
//	}
//public static void main(String[] args) {
//	launch(args);
//}
//}
