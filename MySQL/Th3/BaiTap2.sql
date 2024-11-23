-- Bài tập 2
select sanpham.MASP, sanpham.TENSP
from sanpham
where sanpham.DVT = 'cây' or sanpham.DVT = 'quyển';