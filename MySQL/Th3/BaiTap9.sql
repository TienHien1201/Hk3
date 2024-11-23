-- Bài Tập 9
select hoadon.SOHD, hoadon.TRIGIA 
from hoadon
left join nhanvien 
on hoadon.MANV = nhanvien.MANV
where nhanvien.HOTEN = 'Bùi Thị Ngọc Hân' 
and hoadon.NGHD = '2022-10-28'