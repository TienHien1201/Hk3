-- Bài Tập 36
select sum(cthd.SL) 'TongSanPham' from sanpham
left join cthd using(MASP)
left join hoadon using(SOHD)
where hoadon.NGHD like '2022-10%'; 


	