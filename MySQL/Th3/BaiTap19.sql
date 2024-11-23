-- Bài Tập 19
select hoadon.SOHD from hoadon
left join cthd
on hoadon.SOHD = cthd.SOHD
left join sanpham
on sanpham.MASP = cthd.MASP
where year(hoadon.NGHD) = '2022' and sanpham.NUOCSX = 'Singapore'