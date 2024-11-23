select MAKH, HOTEN, count(hoadon.SOHD) 'SoLanMuaHang' from khachhang
left join hoadon using(MAKH)
group by MAKH, HOTEN
order by SoLanMuaHang desc
limit 1;

