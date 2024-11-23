-- Bài Tập 30
select sanpham.MASP, sanpham.TENSP
from sanpham 
where sanpham.NUOCSX = 'Trung Quốc'
group by sanpham.MASP, sanpham.TENSP
order by  max(sanpham.GIA) desc
limit 3;