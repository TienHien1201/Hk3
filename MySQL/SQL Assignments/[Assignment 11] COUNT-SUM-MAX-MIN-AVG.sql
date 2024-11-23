# Sinh viên tiến hành chạy file DB.sql để lấy dữ liệu trước khi thực hiện các yêu cầu tiếp theo

USE DB;

# Các hàm này được sử dụng trong mệnh đề SELECT hoặc HAVING
# Không dùng cho WHERE

# Tính tổng lương, lương lớn nhất, lương nhỏ nhất và lương trung bình của toàn bộ giáo viên
SELECT SUM(LUONG), MAX(LUONG), MIN(LUONG), AVG(LUONG)
FROM GIAOVIEN;

# Cho biết số lượng giáo viên
SELECT COUNT(*)
FROM GIAOVIEN;

# Bài tập 
-- 1. Tính tổng lương, lương lớn nhất, lương nhỏ nhất và lương trung bình
-- của giáo viên thuộc bộ môn 'Hệ thống thông tin'
select sum(giaovien.LUONG) As "Toltal Salary", max(giaovien.LUONG) As "Max Salary", 
min(giaovien.LUONG) As "Min Salary", avg(giaovien.LUONG) As "Avg Salary"
from giaovien
join bomon
on giaovien.MABM = bomon.MABM
where bomon.TENBM = 'Hệ thống thông tin';
-- 2. Cho biết số lượng giáo viên ở bộ môn 'Hệ thống thông tin'
select count(giaovien.MAGV) As "Number of teachers" from giaovien
join bomon
on giaovien.MABM = bomon.MABM
where bomon.TENBM = 'Hệ thống thông tin';

-- 3. Cho biết số lượng các mức lương của giáo viên (không tính giá trị lương bị trùng)
select  count(distinct giaovien.LUONG) As "Number of teacher salaries" from giaovien
