-- Bài Tập 8
select thisinh.SOBD,thisinh.HOTEN
from thisinh
left join ketqua using(SOBD)
left join monthi using(MON)
where ketqua.DIEM < 5
group by thisinh.SOBD,thisinh.HOTEN;

