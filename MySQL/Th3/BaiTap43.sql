select NUOCSX ,max(sanpham.GIA) 'GiaMAx' from sanpham
where NUOCSX = 'Việt Nam'
union
select NUOCSX ,max(sanpham.GIA) 'GiaMAx' from sanpham
where NUOCSX = 'Trung Quốc'
union
select NUOCSX ,max(sanpham.GIA) 'GiaMAx' from sanpham
where NUOCSX = 'Thái Lan'
union
select NUOCSX ,max(sanpham.GIA) 'GiaMAx' from sanpham
where NUOCSX = 'Singapore'






