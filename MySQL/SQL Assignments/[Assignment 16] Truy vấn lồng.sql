# Sinh viên tiến hành chạy file DB.sql để lấy dữ liệu trước khi thực hiện các yêu cầu tiếp theo

USE DB;

# Truy vấn lồng trong FROM
SELECT * 
FROM GIAOVIEN, (SELECT * FROM DETAI) AS DT;

# Truy vấn lồng trong WHERE
# Kiểm tra giáo viên 001 có phải là giáo viên quản lý chuyên môn hay không
-- B1. Lấy danh sách GVQLCM
-- B2. Kiểm tra mã GV 001 có tồn tại trong danh sách vừa lấy hay không
SELECT * 
FROM GIAOVIEN
WHERE MAGV = '001' AND MAGV IN (
	SELECT GVQLCM FROM GIAOVIEN 
);

# Xuất ra danh sách giáo viên tham gia nhiều hơn 1 đề tài
-- B1. Lấy ra tất cả thông tin của giáo viên
SELECT * FROM GIAOVIEN AS GV
-- B2. Khi số lượng đề tài giáo viên đó tham gia lớn hơn 1
WHERE  ( SELECT COUNT(*) FROM THAMGIADT WHERE THAMGIADT.MAGV = GV.MAGV) > 1;

# Xuất ra thông tin của khoa có nhiều hơn 2 giáo viên
SELECT * FROM KHOA 
WHERE  ( SELECT COUNT(*) 
			FROM BOMON, GIAOVIEN
			WHERE BOMON.MABM = GV.MABM AND BOMON.MAKHOA = KHOA.MAKHOA) > 2;
            
# Xuất ra danh sách giáo viên có mước lương > mức lương trung bình
SELECT *
FROM GIAOVIEN
WHERE LUONG > (
		(SELECT SUM(LUONG) FROM GIAOVIEN) / (SELECT COUNT(*) FROM GIAOVIEN)
);


# Bài tập 
-- 1. Cho biết mã giáo viên, họ tên giáo viên thuộc bộ môn 'Hệ thống thông tin'
select giaovien.MAGV, giaovien.HOTEN from giaovien, bomon 
where giaovien.MABM = bomon.MABM and bomon.TENBM = (
select bomon.TENBM from bomon 
where bomon.TENBM = 'Hệ thống thông tin');
-- 2. Tìm những trưởng bộ môn có tham gia ít nhất 1 đề tài.
SELECT TRUONGBM
FROM bomon
WHERE (
    SELECT COUNT(thamgiadt.MADT)
    FROM giaovien
    LEFT JOIN thamgiadt
    ON thamgiadt.MAGV = giaovien.MAGV
    WHERE bomon.MABM = giaovien.MABM
    GROUP BY bomon.TRUONGBM
) >= 1;

-- 3. Tìm những giáo viên có lương lớn hơn của ít nhất 1 giáo viên thuộc bộ môn 'Hệ thống thông tin'
select * from giaovien
where giaovien.LUONG > (
select min(gv.LUONG) from bomon, giaovien gv
where gv.MABM = bomon.MABM and bomon.TENBM like 'Hệ thống thông tin'
);
-- 4. Tìm những giáo viên có lương lớn hơn tất cả giáo viên thuộc bộ môn 'Hệ thống thông tin'
select * from giaovien
where giaovien.LUONG > (
select max(gv.LUONG) from bomon, giaovien gv
where gv.MABM = bomon.MABM and bomon.TENBM like 'Hệ thống thông tin'
);
-- 5. Cho biết mã giáo viên, họ tên giáo viên chưa tham gia đề tài nào.
select giaovien.MAGV, giaovien.HOTEN from giaovien
where giaovien.MAGV in (
select thamgiadt.MAGV from thamgiadt
where giaovien.MAGV = thamgiadt.MAGV and thamgiadt.KETQUA is null
); 

