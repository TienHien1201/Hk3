-- Bài Tập 4
select thisinh.HOTEN
from thisinh
left join ketqua using(SOBD)
where ketqua.DIEMTHI >= 8
group by thisinh.HOTEN
having  count(*) = 6;