-- 코드를 입력하세요
SELECT name, datetime
from animal_ins
where not exists (select 1
                  from animal_outs
                  where animal_ins.animal_id = animal_outs.animal_id)
order by datetime
fetch first 3 rows only;