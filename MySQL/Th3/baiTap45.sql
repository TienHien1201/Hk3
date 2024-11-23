-- Bài Tập 45
select *
from khachhang
where MAKH = (select A.MAKH
from ( select MAKH
from khachhang 
order by DOANHSO desc limit 10) As A
left join 
(select MAKH, count(SOHD) As SL
From hoadon
group by MAKH) AS B
on 	A.MAKH = B.MAKH
order by SL desc limit 1);

