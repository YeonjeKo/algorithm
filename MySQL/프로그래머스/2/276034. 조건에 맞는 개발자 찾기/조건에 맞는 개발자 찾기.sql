-- 코드를 작성해주세요
select distinct d.id, d.email, d.first_name, d.last_name
from developers d, skillcodes s
where d.skill_code & s.code = s.code and (s.name = 'Python' or s.name = 'C#')
order by d.id;