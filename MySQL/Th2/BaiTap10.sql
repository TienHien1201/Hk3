-- Bài Tập 10
select thisinh.SOBD, thisinh.HOTEN
from thisinh
left join ketqua using(SOBD)
left join monthi using(MON)
where ketqua.MON like '%CH' and ketqua.DIEM >= 5 or (
    (thisinh.SOBD, thisinh.HOTEN) in (
        select thisinh.SOBD, thisinh.HOTEN
        from thisinh
        left join ketqua using(SOBD)
        left join monthi using(MON)
        where ketqua.DIEM >= 2
        group by thisinh.SOBD, thisinh.HOTEN
        having sum(ketqua.DIEM)  >= 20
    )
)
group by thisinh.SOBD, thisinh.HOTEN;







