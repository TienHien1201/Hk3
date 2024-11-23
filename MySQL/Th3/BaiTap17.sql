-- Bài Tập 16
-- Bài Tập 17
select sanpham.MASP, sanpham.TENSP
from sanpham
left join cthd 
on sanpham.MASP = cthd.MASP
left join hoadon
on hoadon.SOHD = cthd.SOHD
left join khachhang
on hoadon.MAKH = khachhang.MAKH
where sanpham.NUOCSX = 'Trung Quốc' 
and year(hoadon.NGHD) = '2022' 
and hoadon.MAKH is null