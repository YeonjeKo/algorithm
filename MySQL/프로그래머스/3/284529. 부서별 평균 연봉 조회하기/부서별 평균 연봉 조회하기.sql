-- 코드를 작성해주세요
with a as (select dept_id, round(avg(sal), 0) as avg_sal
        from hr_employees
        group by dept_id)
select a.dept_id, d.dept_name_en, a.avg_sal
from a, hr_department d
where a.dept_id = d.dept_id
order by a.avg_sal desc;
