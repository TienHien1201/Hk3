-- Bài Tập 2
select thisinh.SOBD,thisinh.HOTEN, sum(ketqua.DIEM) As 'ToltalPoint'
from thisinh
left join ketqua using(SOBD)
left join monthi using(MON)
group by thisinh.SOBD,thisinh.HOTEN
order by ToltalPoint Desc
limit 1;	
