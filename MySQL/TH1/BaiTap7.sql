-- Bài Tập 7
select monthi.TENMT,avg(ketqua.DIEMTHI) As 'AVGPoint'
from ketqua
left join monthi using(MAMT)
left join thisinh using(SOBD)
group by monthi.TENMT
having AVGPoint < 5;


