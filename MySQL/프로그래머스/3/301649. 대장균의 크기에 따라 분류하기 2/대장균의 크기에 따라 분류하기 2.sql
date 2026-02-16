-- 코드를 작성해주세요
with tmp as (select id, ntile(4) over (order by size_of_colony desc) as a
            from ecoli_data)
select e.id, case when tmp.a = 1 then 'CRITICAL'
                  when tmp.a = 2 then 'HIGH'
                  when tmp.a = 3 then 'MEDIUM'
                  else "LOW" 
             end as colony_name
from ecoli_data e, tmp
where e.id = tmp.id
order by e.id;