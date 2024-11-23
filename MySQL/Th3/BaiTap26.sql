-- Bài Tập 26
select khachhang.HOTEN ,max(hoadon.TRIGIA) As 'Trị Giá Hóa đơn Max'
from hoadon
left join khachhang
on khachhang.MAKH = hoadon.MAKH
where year(hoadon.NGHD) = '2022'
group by khachhang.HOTEN
order by max(hoadon.TRIGIA) desc
limit 1;