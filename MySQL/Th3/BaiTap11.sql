-- Bài Tập 11
select hoadon.SOHD from hoadon
left join cthd
on hoadon.SOHD = cthd.SOHD
left join sanpham
on sanpham.MASP = cthd.MASP
where sanpham.MASP = 'BB01' or sanpham.MASP = 'BB02';

-- Đọc lại giáo trình
select cthd.SOHD from cthd
left join sanpham
on sanpham.MASP = cthd.MASP
where sanpham.MASP = 'BB01' or sanpham.MASP = 'BB02';