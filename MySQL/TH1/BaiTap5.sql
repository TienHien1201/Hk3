-- Bài tập 5
select thisinh.HOTEN
from thisinh
left join ketqua
on thisinh.SOBD = ketqua.SOBD
left join monthi
on monthi.MAMT = ketqua.MAMT
where ketqua.DIEMTHI = 0 and ketqua.GHICHU like 'VT'
group by thisinh.HOTEN
having  count(monthi.MAMT) = 6;