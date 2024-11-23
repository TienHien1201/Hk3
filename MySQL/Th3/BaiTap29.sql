-- Bài Tập 29
select MASP, TENSP 
from sanpham
join ( select distinct GIA
       from sanpham 
       order by  GIA desc
	   limit 3) as MucGia
on sanpham.GIA = MucGia.GIA
where sanpham.NUOCSX = 'Thái Lan';

       
