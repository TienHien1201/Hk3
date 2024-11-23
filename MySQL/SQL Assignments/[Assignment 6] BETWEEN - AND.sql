# Sinh viên tiến hành chạy file DB.sql để lấy dữ liệu trước khi thực hiện các yêu cầu tiếp theo

USE DB;

# Cho biết thông tin các giáo viên có lương nằm trong khoảng từ 2000 đến 2500
SELECT * 
FROM GIAOVIEN
WHERE LUONG BETWEEN 2000 AND 2500;

# Cho biết thông tin các giáo viên có lương không nằm trong khoảng từ 2000 đến 2500
SELECT * 
FROM GIAOVIEN
WHERE LUONG NOT BETWEEN 2000 AND 2500;



# Bài tập 
# 1. Cho biết thông tin các giáo viên có độ tuổi từ 25 đến 35 tuổi
SELECT *, YEAR(curdate()) - YEAR(giaovien.NGSINH) as "TUOI"  FROM giaovien
where (YEAR(curdate()) - YEAR(giaovien.NGSINH)) between 25 and 35;
# 2. Cho biết thông tin các khoa thành lập từ năm 1980 đến năm 1990
select * from khoa
where khoa.NAMTL between 1980 and 1990;
# 3. Cho biết thông tin các giáo viên có mức phụ cấp tham gia đề tài từ 1.5 đến 2.0
select * from thamgiadt
where thamgiadt.PHUCAP between 1.5 and 2.0;
# 4. Cho biết thông tin các đề tài có kinh phí không nằm trong khoảng từ 50tr đến 100tr
select * from detai
where detai.KINHPHI not between 50 and 100 ;  
# 5. Cho biết thông tin các trưởng bộ môn nhận chức từ đầu năm 2015 đến hết năm 2016
select bomon.TRUONGBM from bomon 
where (year(bomon.NGAYNHANCHUC )) between 2015 and 2016;













SELECT *
FROM GIAOVIEN
WHERE  YEAR(curdate()) - YEAR(NGSINH) BETWEEN 25 AND 35
