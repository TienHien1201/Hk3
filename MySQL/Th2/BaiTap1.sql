-- Bài tập 1
select thisinh.SOBD,thisinh.HOTEN ,count(ketqua.SOBD) As 'SoMonThiTren8'
from thisinh
left join ketqua using(SOBD)
left join monthi using(MON)
where ketqua.DIEM >= 8
group by  thisinh.SOBD,thisinh.HOTEN 
having SoMonThiTren8 = 3;


