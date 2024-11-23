-- Bài Tập 24
select sum(hoadon.TRIGIA) As 'Doanh thu bán hàng 2022'
from hoadon
where year(hoadon.NGHD) = '2022'