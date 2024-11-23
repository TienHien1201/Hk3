# Sinh viên tiến hành chạy file DB.sql để lấy dữ liệu trước khi thực hiện các yêu cầu tiếp theo

USE DB;

## Cấu trúc phép kết bằng ( inner join )
# inner join kiểu cũ
SELECT * 
FROM GIAOVIEN, BOMON
WHERE BOMON.MABM = GIAOVIEN.MABM;

# inner join kiểu mới. mọi join điều cần điều kiện
SELECT *
FROM GIAOVIEN INNER JOIN BOMON 
ON BOMON.MABM = GIAOVIEN.MABM;
# SQL cho phép viết tắt INNER JOIN -> JOIN
SELECT *
FROM GIAOVIEN JOIN BOMON 
ON BOMON.MABM = GIAOVIEN.MABM;


# Bài tập
-- 1. Cho biết mã giáo viên, họ tên giáo viên thuộc bộ môn 'Hệ thống thông tin'
select giaovien.MAGV, giaovien.HOTEN from giaovien
join bomon
on giaovien.MABM = bomon.MABM
where bomon.TENBM = 'Hệ thống thông tin';
-- 2. Cho biết mã giáo viên, họ tên giáo viên quản lý chuyên môn
select giaovien.MAGV, giaovien.HOTEN from giaovien 
where giaovien.GVQLCM is not null;
-- 3. Cho biết mã giáo viên, họ tên giáo viên và tên người thân của giáo viên đó
select giaovien.MAGV, giaovien.HOTEN, nguoithan.TEN from giaovien
join nguoithan 
on giaovien.MAGV = nguoithan.MAGV;
-- 4. Cho biết mã giáo viên, họ tên giáo viên trưởng khoa và tên khoa tương ứng
select giaovien.MAGV, khoa.TRUONGKHOA, khoa.TENKHOA from giaovien 
join bomon
on giaovien.MABM = bomon.MABM
join khoa
on khoa.MAKHOA = bomon.MAKHOA;
-- 5. Cho biết mã giáo viên, họ tên giáo, số điện thoại của các giáo viên bộ môn 'Hệ thống thông tin'
select giaovien.MAGV, giaovien.HOTEN, bomon.DIENTHOAI from giaovien 
join bomon
on giaovien.MABM = bomon.MABM
where bomon.TENBM = 'Hệ thống thông tin';


