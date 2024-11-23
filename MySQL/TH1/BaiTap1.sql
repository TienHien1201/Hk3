USE QUANLYTHITOTNGHIEP;
-- Bài tập 1
select ketqua.DIEMTHI, monthi.TENMT
from thisinh
left join ketqua using(SOBD)
left join monthi using(MAMT)
where thisinh.SOBD = '19101'
group by ketqua.DIEMTHI, monthi.TENMT;

