select hoadon.SOHD, count(distinct cthd.MASP) 'SoSanPham' from hoadon
left join cthd using(SOHD)
left join sanpham using(MASP)
group by hoadon.SOHD
having SoSanPham > 4
