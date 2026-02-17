-- 코드를 작성해주세요
with tmp as (select emp_no, sum(score) as score
            from hr_grade
            group by emp_no, year
            order by score desc
            limit 1)
select tmp.score, tmp.emp_no, e.emp_name, e.position, e.email
from tmp, hr_employees e
where tmp.emp_no = e.emp_no;