# Sinh viên tiến hành chạy file DB.sql để lấy dữ liệu trước khi thực hiện các yêu cầu tiếp theo

USE DB;

# Ví dụ 1. Tạo store procedure xuất danh sách giáo viên (không chứa tham số truyền vào)
DELIMITER //  
CREATE PROCEDURE xuat_ds_giaovien()
BEGIN
	SELECT * FROM GIAOVIEN;
END
//

# Gọi store procedure in danh sách giáo viên
CALL xuat_ds_giaovien();


# Ví dụ 2. Tạo store procedure tìm danh sách giáo viên (có tên chứa kí tự là tham số truyền vào)
DELIMITER //  
CREATE PROCEDURE tim_ds_giaovien(str VARCHAR(10))
BEGIN
	SELECT * FROM GIAOVIEN
    WHERE HOTEN LIKE CONCAT('%',str,'%');
END
//

# Gọi store procedure tìm danh sách giáo viên có họ trần
CALL tim_ds_giaovien('Trần');


# Xoá store procedure
#DROP PROCEDURE IF EXISTS `DB`.`in_ds_giaovien`;

# Bài tập 
-- 1. Tạo store procedure xuất danh sách các bộ môn
DELIMITER //  
CREATE PROCEDURE xuat_ds_bomon()
BEGIN
	SELECT * FROM bomon;
END
//

call xuat_ds_bomon();
-- 2. Tạo store procedure xuất danh sách các giáo viên thuộc bộ môn 'HTTT'
delimiter //
create procedure giaovien_thuoc_HTTT(str varchar(5))
begin
  select giaovien.* from giaovien, bomon
  where giaovien.MABM = bomon.MABM and bomon.MABM like str;
end
//

call giaovien_thuoc_HTTT('HTTT');
-- 3. Tạo store các khoa thành lập từ năm 1980 đến năm 1990
delimiter //
create procedure list_khoa_1980to1990()
begin 
select * from khoa
where khoa.NAMTL between 1980 and 1990;
end
//

call list_khoa_1980to1990();
-- 4. Tạo store procedure xuất danh sách các giáo viên có độ tuổi từ a đến b (với a,b là 2 tham số truyền vào).
delimiter //
create procedure xuat_list_giaovien_tuoiTuADenB(a int, b int)
begin 
select *, (year(curdate()) - year(giaovien.NGSINH)) As 'Tuoi' from giaovien
where (year(curdate()) - year(giaovien.NGSINH)) between a and b;
end 
// 

call xuat_list_giaovien_tuoiTuADenB(23,40);
-- 5. Tạo store procedure tính tuổi của giáo viên, lưu kết quả tính được vào bảng giáo viên.
delimiter //
create procedure tinh_tuoi()
begin 
update giaovien 
set giaovien.Tuoi = year(curdate()) - year(giaovien.NGSINH);
end
//
set SQL_SAFE_UPDATES = 0; #Tắt chế độ cập nhật an toàn để sau khi tính tuổi cho các giáo viên xong 
#thì ta có thể cập nhật lưu tuổi của từng giáo viên vào cột Tuoi. Vì là tính tuổi cho toàn bộ giáo
# viên trong bảng giaovien nên không có điều kiện cập nhật nên phải tắt chế độ cập nhật an toàn để
# lưu tuổi của tất cả giáo viên và bảng giaovien
alter table giaovien add column Tuoi int;
call tinh_tuoi();


