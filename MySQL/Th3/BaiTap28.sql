-- Bài Tập 28
select sanpham.MASP, sanpham.TENSP
from sanpham 
group by sanpham.MASP, sanpham.TENSP
order by  max(sanpham.GIA) desc
limit 3;