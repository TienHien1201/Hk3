-- Bài tập 4
select sanpham.MASP, sanpham.TENSP
from sanpham
where sanpham.NUOCSX = 'Trung Quốc' 
and sanpham.GIA between 30.000 and 40.000
or (sanpham.MASP, sanpham.TENSP) in (select sanpham.MASP, sanpham.TENSP
									 from sanpham
                                     where sanpham.NUOCSX = 'Thái Lan' 
                                     and sanpham.GIA between 30.000 and 40.000);