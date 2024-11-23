# Sinh viên tiến hành chạy file DB.sql để lấy dữ liệu trước khi thực hiện các yêu cầu tiếp theo

USE DB;

# Ví dụ 1. Tạo Trigger thêm giáo viên
# Tạo trigger
DELIMITER //  
CREATE TRIGGER them_giaovien
AFTER INSERT
ON GIAOVIEN FOR EACH ROW
BEGIN
	INSERT INTO GV_DT(MAGV, DIENTHOAI) VALUES (NEW.MAGV, '0392654310');
END 
//

INSERT INTO GIAOVIEN (MAGV, HOTEN, LUONG, PHAI, NGSINH, DIACHI, GVQLCM, MABM)
VALUES ('012','Lê Minh Đức', 2100, 'Nam','1994-10-01','153 Nguyễn Trãi, Q.5, TP HCM', NULL, 'HTTT');

# Xoá trigger
#DROP TRIGGER them_giaovien;


# Bài tập 
-- 1. Tạo trigger khi thêm hoặc chỉnh sửa dữ liệu của bảng giáo viên thì cột TUOI (tuổi)sẽ được tính theo công thức TUOI = năm hiện tại - 
-- năm sinh.

-- Trigger chỉnh sửa của bảng giáo viên
DELIMITER //
CREATE TRIGGER capnhat_tuoigv
before UPDATE ON giaovien
FOR EACH ROW
BEGIN
    SET NEW.Tuoi = YEAR(CURDATE()) - YEAR(NEW.NGSINH);
END;
//

-- Trigger thêm của bảng giáo viên
DELIMITER //
create trigger insert_tuoigv
before insert on giaovien
for each row
begin
    set new.Tuoi = year(CURDATE()) - year(NEW.NGSINH);
end;
//

INSERT INTO GIAOVIEN (MAGV, HOTEN, LUONG, PHAI, NGSINH, DIACHI, GVQLCM, MABM)
VALUES ('014','Nguyễn Văn B', 2550, 'Nam','1992-11-01','400 Nguyễn Xiễn, Q.9, TP HCM',null, 'MMT');

-- 2. Tạo trigger khi thêm một giáo viên thì mặc định để người đó tham gia đề tài có mã là 001.
DELIMITER //  
CREATE TRIGGER them_giaoviendt
AFTER INSERT
ON GIAOVIEN FOR EACH ROW
BEGIN

	insert into THAMGIADT( MAGV, MADT, STT, PHUCAP, KETQUA) 
    values (NEW.MAGV,'001',1 , null, null);
END 
//

#drop trigger them_giaoviendt;
#set SQL_SAFE_UPDATES = 1;

INSERT INTO GIAOVIEN (MAGV, HOTEN, LUONG, PHAI, NGSINH, DIACHI, GVQLCM, MABM)
VALUES ('013','Phan Văn Đức', 2900, 'Nam','1997-10-01','153 Nguyễn Xiễn, Q.9, TP HCM', NULL, 'HTTT');


