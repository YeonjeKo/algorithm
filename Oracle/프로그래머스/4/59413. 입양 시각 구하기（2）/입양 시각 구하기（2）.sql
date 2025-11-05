-- 코드를 입력하세요
with hours as (select level - 1 as hour
                from dual
                connect by level <= 24)
select h.hour, nvl(count(a.animal_id), 0) as count
from hours h
left join animal_outs a
on h.hour = to_char(a.datetime, 'fmhh24')
group by h.hour
order by to_number(h.hour);

     
     