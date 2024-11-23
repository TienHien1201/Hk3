-- Bài tập 6
select ketqua.DIEMTHI from ketqua
left join monthi using(MAMT)
left join thisinh using(SOBD)
left join truong using(MATRG)
where truong.TENTRUONG like 'Lê Hồng Phong' and monthi.TENMT like 'Toán học'
group by ketqua.DIEMTHI ;


