-- Bài Tập 18
select hoadon.SOHD from hoadon
left join cthd
on hoadon.SOHD = cthd.SOHD
left join sanpham
on sanpham.MASP = cthd.MASP
where sanpham.NUOCSX = 'Singapore'