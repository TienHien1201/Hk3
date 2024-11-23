-- Bài Tập 35
select month(hoadon.NGHD) 'ThangBan', sum(hoadon.TRIGIA) 'TongTien' 
from hoadon
left join khachhang using(MAKH) 
where year(hoadon.NGHD) = '2022'
group by ThangBan
order by TongTien desc
limit 1;

