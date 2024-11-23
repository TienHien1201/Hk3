-- Bài Tập 33
select sanpham.NUOCSX,count(sanpham.MASP) 'ToltalSanPham'
from sanpham
where sanpham.NUOCSX = 'Trung Quốc'
union
select sanpham.NUOCSX,count(sanpham.MASP) 'ToltalSanPham'
from sanpham
where sanpham.NUOCSX = 'Việt Nam'
union
select sanpham.NUOCSX, count(sanpham.MASP) 'ToltalSanPham'
from sanpham
where sanpham.NUOCSX = 'Singapore'
union
select sanpham.NUOCSX,count(sanpham.MASP) 'ToltalSanPham'
from sanpham
where sanpham.NUOCSX = 'Thái Lan'
