-- Bài Tập 8
select khachhang.MAKH, khachhang.HOTEN from khachhang
left join hoadon
on khachhang.MAKH = hoadon.MAKH
where hoadon.NGHD = '2023-1-1'