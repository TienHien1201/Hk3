-- Bài Tập 5
select monthi.MON, ketqua.DIEM
from thisinh
left join ketqua using(SOBD)
left join monthi using(MON)
where ketqua.MON like '%CH' and ketqua.DIEM = 10
group by 	monthi.MON, ketqua.DIEM;