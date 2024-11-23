# Sinh viên tiến hành chạy file DB.sql để lấy dữ liệu trước khi thực hiện các yêu cầu tiếp theo

USE DB;

SELECT MABM
FROM GIAOVIEN;

SELECT MABM, COUNT(*)
FROM GIAOVIEN
GROUP BY MABM;


# Xuất ra danh sách tên bộ môn và số lượng giáo viên của bộ môn đó
SELECT TENBM, COUNT(*) AS 'SLGV' -- Cột hiển thị phải là thuộc tính của GROUP BY hoặc các hàm tính tổng hợp
FROM GIAOVIEN, BOMON
WHERE BOMON.MABM = GIAOVIEN.MABM
GROUP BY TENBM;


# Bài tập 
-- 1. Cho biết lương trung bình của giáo viên từng bộ môn.
select bomon.TENBM , avg(giaovien.LUONG) As "AVG Salary of teachers for each subject" from giaovien, bomon 
where giaovien.MABM = bomon.MABM
group by bomon.TENBM;
-- 2. Cho biết số lượng giáo viên tham gia cho mỗi đề tài.
select giaovien.MAGV,giaovien.HOTEN,count(thamgiadt.MAGV) As "Number of teachers participating in the topic" from giaovien, thamgiadt
where giaovien.MAGV = thamgiadt.MAGV
group by giaovien.MAGV,giaovien.HOTEN;
-- 3. Xuất ra tên giáo viên và số lượng đề tài giáo viên đó đã làm.
select giaovien.HOTEN, count(giaovien.MAGV) As "Number of topics teachers participate in"
from giaovien, thamgiadt
where giaovien.MAGV = thamgiadt.MAGV
group by giaovien.HOTEN;
-- 4. Xuất ra tên giáo viên và số lượng người thân của giáo viên đó.
select giaovien.HOTEN, count(nguoithan.MAGV) As "Number of relatives of the teacher"
from giaovien, nguoithan
where nguoithan.MAGV = giaovien.MAGV
group by giaovien.HOTEN;
-- 5. Xuất ra tên khoa có số lượng giáo viên trong khoa là nhiều nhất.
select khoa.TENKHOA, count(khoa.MAKHOA) As "Max Teacher In Khoa"
from khoa
join bomon
on bomon.MAKHOA = khoa.MAKHOA
join giaovien
on giaovien.MABM = bomon.MABM
where khoa.TENKHOA like 'Công nghệ thông tin'
group by khoa.TENKHOA
limit 1;
