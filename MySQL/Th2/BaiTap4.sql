-- Bài Tập 4
select thisinh.SOBD, thisinh.HOTEN
from thisinh
left join ketqua using(SOBD)
left join monthi using(MON)
where ketqua.DIEM = 0 and ketqua.MON not like '%CH'
group by  thisinh.SOBD, thisinh.HOTEN;