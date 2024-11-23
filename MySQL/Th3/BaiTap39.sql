select hoadon.SOHD, count(distinct cthd.MASP) 'SoSanPham' from hoadon
left join cthd using(SOHD)
left join sanpham using(MASP)
where sanpham.NUOCSX = 'Việt Nam'
group by hoadon.SOHD
having SoSanPham = 3 
