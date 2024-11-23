-- Bài Tập 25
select max(hoadon.TRIGIA) As 'Trị Giá Hóa đơn Max'
from hoadon
where year(hoadon.NGHD) = '2022'
