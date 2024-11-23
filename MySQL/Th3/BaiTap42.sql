select MASP, TENSP, sum(cthd.SL) 'TongSoLuongMin' from sanpham
left join cthd using(MASP)
left join hoadon using(SOHD)
where year(hoadon.NGHD) = '2022'
group by MASP, TENSP
order by TongSoLuongMin 
limit 1;