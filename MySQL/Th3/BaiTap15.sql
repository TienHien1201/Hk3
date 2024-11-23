-- Bài tập 15
select sanpham.MASP, sanpham.TENSP
from sanpham
left join cthd 
on sanpham.MASP = cthd.MASP
left join hoadon
on hoadon.SOHD = cthd.SOHD
left join khachhang
on hoadon.MAKH = khachhang.MAKH
where hoadon.MAKH is null