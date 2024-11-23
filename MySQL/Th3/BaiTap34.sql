-- Bài Tập 34
select count(sanpham.MASP) 'ToltalSanPham', max(sanpham.GIA) 'GiaMax',
min(sanpham.GIA) 'GiaMin', avg(sanpham.GIA) 'AvgGia '
from sanpham
where sanpham.NUOCSX = 'Trung Quốc'
union
select count(sanpham.MASP) 'ToltalSanPham', max(sanpham.GIA) 'GiaMax',
min(sanpham.GIA) 'GiaMin', avg(sanpham.GIA) 'AvgGia'
 from sanpham
where sanpham.NUOCSX = 'Việt Nam'
union
select count(sanpham.MASP) 'ToltalSanPham', max(sanpham.GIA) 'GiaMax',
min(sanpham.GIA) 'GiaMin', avg(sanpham.GIA) 'Avg Gia'
 from sanpham
where sanpham.NUOCSX = 'Singapore'
union
select count(sanpham.MASP) 'ToltalSanPham', max(sanpham.GIA) 'GiaMax',
min(sanpham.GIA) 'GiaMin', avg(sanpham.GIA) 'AvgGia'
 from sanpham
where sanpham.NUOCSX = 'Thái Lan'
