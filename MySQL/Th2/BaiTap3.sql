-- Bài Tập 3
select thisinh.SOBD, thisinh.HOTEN
from thisinh
left join ketqua using(SOBD)
left join monthi using(MON)
where ketqua.MON like '%CH' and ketqua.DIEM < 5 or (
    (thisinh.SOBD, thisinh.HOTEN) in (
        select thisinh.SOBD, thisinh.HOTEN
        from thisinh
        left join ketqua using(SOBD)
        left join monthi using(MON)
        where ketqua.DIEM < 2
        group by thisinh.SOBD, thisinh.HOTEN
    )
)
group by thisinh.SOBD, thisinh.HOTEN;








