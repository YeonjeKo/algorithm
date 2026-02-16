with tmp as (select parent_id, count(*) as child_count
            from ecoli_data
            where parent_id is not null
            group by parent_id)
select e.id, ifnull(tmp.child_count, 0) as child_count
from ecoli_data e
left join tmp on e.id = tmp.parent_id
order by e.id;