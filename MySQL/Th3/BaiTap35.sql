-- Bài Tập 35
select date(hoadon.NGHD) 'NgayBan', sum(hoadon.TRIGIA) 'TongTien' 
from hoadon
left join khachhang using(MAKH) 
group by NgayBan
order by NgayBan;
