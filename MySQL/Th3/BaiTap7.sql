-- Bài tập 7
select SOHD, TRIGIA, NGHD
from hoadon
where month(NGHD) = 1 and year(NGHD) = 2023  
order by NGHD asc,TRIGIA desc;


