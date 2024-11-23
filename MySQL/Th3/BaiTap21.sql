-- Bài Tập 21
select count(distinct sanpham.MASP) As 'Số Sản Phẩm khác Nhau Bán Đc Trong Năm 2022'
from sanpham
left join cthd
on sanpham.MASP = cthd.MASP
left join hoadon
on hoadon.SOHD = cthd.SOHD
where year(hoadon.NGHD) = '2022'