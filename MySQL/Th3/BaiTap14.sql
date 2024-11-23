-- Bài Tập 14
select sanpham.MASP, sanpham.TENSP from sanpham
left join cthd
on sanpham.MASP = cthd.MASP
left join hoadon
on hoadon.SOHD = cthd.SOHD
where sanpham.NUOCSX = 'Trung Quốc' or hoadon.NGHD = '2023-1-1'