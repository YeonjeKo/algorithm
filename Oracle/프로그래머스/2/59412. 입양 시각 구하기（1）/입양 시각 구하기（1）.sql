-- 코드를 입력하세요
SELECT to_char(datetime, 'fmhh24') as hour, count(*) as count
from animal_outs
where to_number(to_char(datetime, 'fmhh24')) between 9 and 19
group by to_char(datetime, 'fmhh24')
order by to_number(hour);