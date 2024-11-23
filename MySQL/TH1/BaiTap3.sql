-- Bài tập 3 
select thisinh.SOBD, HOTEN
from thisinh
left join ketqua using(SOBD)
where ketqua.DIEMTHI = 0 and ketqua.GHICHU like 'VT'
group by thisinh.SOBD, HOTEN
having  count(*) = 6;
