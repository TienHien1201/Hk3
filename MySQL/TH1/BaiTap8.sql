-- Bài Tập 8
select thisinh.SOBD,thisinh.HOTEN,avg(ketqua.DIEMTHI) As 'AVGPoint'
from ketqua
left join monthi using(MAMT)
left join thisinh using(SOBD)
group by thisinh.SOBD,thisinh.HOTEN
having AVGPoint >= 8;