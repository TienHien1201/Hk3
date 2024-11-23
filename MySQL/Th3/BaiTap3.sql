-- Bài tập 3
select sanpham.MASP, sanpham.TENSP
from sanpham
where sanpham.NUOCSX = 'Trung Quốc' 
and sanpham.GIA between 30.000 and 40.000;