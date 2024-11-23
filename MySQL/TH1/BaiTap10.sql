-- Bài Tập 10
select count(distinct(thisinh.SOBD)) As 'NumberStudent' 
from thisinh
left join ketqua using(SOBD)
left join monthi using(MAMT)
where ketqua.DIEMTHI = 0 and ketqua.GHICHU like 'VT';
