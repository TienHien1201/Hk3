-- Bài Tập 35
select month(hoadon.NGHD) 'ThangBan', sum(hoadon.TRIGIA) 'TongTien' 
from hoadon
left join khachhang using(MAKH) 
group by ThangBan
order by ThangBan;
