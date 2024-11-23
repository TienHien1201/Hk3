select thisinh.SOBD,thisinh.HOTEN, sum(ketqua.DIEMTHI) As 'TotalPoint' from thisinh
left join ketqua using(SOBD)
left join monthi using(MAMT)
group by thisinh.SOBD,thisinh.HOTEN
order by TotalPoint Desc
limit 1;

