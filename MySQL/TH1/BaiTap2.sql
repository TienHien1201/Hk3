-- Bài tập 2
select thisinh.HOTEN 
from thisinh
left join ketqua using(SOBD)
left join monthi using(MAMT)
where ketqua.DIEMTHI = 0
group by thisinh.HOTEN;