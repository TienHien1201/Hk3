# Sinh viên tiến hành chạy file DB.sql để lấy dữ liệu trước khi thực hiện các yêu cầu tiếp theo

USE DB;

-- Dùng đặt bí danh (alias) cho cột, bảng

# Đổi tên cột hiển thị
SELECT MABM AS 'Mã môn', TENBM AS 'Tên môn' 
FROM BOMON;

# Cho biết mã giáo viên, họ tên và lương của họ sau khi tăng lên 10%
SELECT MAGV, HOTEN, LUONG*1.1 
FROM GIAOVIEN;

# Cho biết mã giáo viên, họ tên và lương của họ sau khi tăng lên 10%
SELECT MAGV AS 'Mã GV', HOTEN AS 'Họ tên', LUONG*1.1 AS 'Lương Tăng 10%' 
FROM GIAOVIEN;

# Cho biết mã giáo viên, họ tên giáo viên thuộc bộ môn 'Hệ thống thông tin'
SELECT GV.MAGV, GV.HOTEN
FROM GIAOVIEN AS GV, BOMON AS BM
WHERE GV.MABM = BM.MABM 
	  AND BM.TENBM = 'Hệ thống thông tin' ;

# Bài tập 
-- 1. Đổi tên cột MAKHOA thành 'Mã khoa' và TENKHOA thành 'Tên khoa'
select khoa.MAKHOA AS "Mã Khoa", khoa.TENKHOA AS "Tên Khoa" from khoa;
-- 2. Cho biết mã giáo viên, họ tên giáo viên và họ tên người quản lý chuyên môn giáo viên nếu có
select MAGV, HOTEN, GVQLCM from giaovien
where GVQLCM is not NULL;
-- 3. Cho biết mã giáo viên, họ tên giáo viên và tên người thân tương ứng
select giaovien.MAGV, giaovien.HOTEN, nguoithan.TEN AS "NAME NGUOITHAN Of GIAOVIEN " from giaovien, nguoithan
where giaovien.MAGV = nguoithan.MAGV;
-- 4. Cho biết danh sách các giáo viên có tham gia đề tài
select giaovien.* from giaovien, thamgiadt
where giaovien.MAGV = thamgiadt.MAGV;
-- 5. Cho biết danh sách các giáo viên là chủ nhiệm đề tài
select giaovien.* from giaovien, detai
where giaovien.MAGV = detai.GVCNDT;
