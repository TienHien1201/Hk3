-- Bài Tập 2
select thisinh.SOBD,thisinh.HOTEN, thisinh.LOPCH,monthi.MON, ketqua.DIEM
from thisinh
left join ketqua using(SOBD)
left join monthi using(MON)
where ketqua.MON like '%CH'
group by thisinh.SOBD,thisinh.HOTEN, thisinh.LOPCH,monthi.MON, ketqua.DIEM;