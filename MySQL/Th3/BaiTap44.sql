select NUOCSX ,count(distinct sanpham.GIA) 'SoSanPham' from sanpham
group by NUOCSX
having SoSanPham >= 3
