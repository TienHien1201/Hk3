  -- Bài Tập 10
select sanpham.MASP, sanpham.TENSP
from sanpham
left join cthd
on sanpham.MASP = cthd.MASP
left join hoadon
on hoadon.SOHD = cthd.SOHD
left join khachhang 
on khachhang.MAKH = hoadon.MAKH
where khachhang.HOTEN = 'Nguyễn Thành Nam' 
and month(hoadon.NGHD) = '10'
and year(hoadon.NGHD) = '2022'
group by sanpham.MASP, sanpham.TENSP