-- Bài Tập 23
select avg(hoadon.TRIGIA) As 'Trị Giá Trung Bình Các đơn hàng 2022'
from hoadon
where year(hoadon.NGHD) = '2022'