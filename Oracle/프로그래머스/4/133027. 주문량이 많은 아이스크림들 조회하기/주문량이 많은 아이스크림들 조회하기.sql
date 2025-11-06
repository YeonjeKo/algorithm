-- 코드를 입력하세요
with july2 as (select flavor, sum(total_order) as total_order
              from july
              group by flavor),
tmp as (select coalesce(first_half.flavor, july2.flavor) as flavor, (nvl(first_half.total_order, 0) + nvl(july2.total_order, 0)) as total
         from first_half
         full outer join july2
         on first_half.flavor = july2.flavor
)
SELECT flavor
from (select flavor 
      from tmp 
      order by total desc)
where rownum <= 3;

