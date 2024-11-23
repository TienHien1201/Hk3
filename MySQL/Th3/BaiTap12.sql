-- Bài Tập 12
select hoadon.SOHD from hoadon
left join cthd
on hoadon.SOHD = cthd.SOHD
left join sanpham
on sanpham.MASP = cthd.MASP
where sanpham.MASP = 'BB01' and cthd.SL between 10 
and 20 or sanpham.MASP = 'BB02' and cthd.SL between 10 and 20
group by hoadon.SOHD;

-- Đọc lại giáo trình
select cthd.SOHD from cthd
left join sanpham
on sanpham.MASP = cthd.MASP
where sanpham.MASP = 'BB01'  and cthd.SL between 10 
and 20 or sanpham.MASP = 'BB02' and cthd.SL between 10 and 20
group by cthd.SOHD;