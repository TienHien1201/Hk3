-- Bài Tập 20
select count(khachhang.NGDK) As 'Số Hóa Đơn Không phải của khách hàng đăng kí'
from hoadon
left join khachhang 
on hoadon.MAKH = khachhang.MAKH
where hoadon.MAKH is null



