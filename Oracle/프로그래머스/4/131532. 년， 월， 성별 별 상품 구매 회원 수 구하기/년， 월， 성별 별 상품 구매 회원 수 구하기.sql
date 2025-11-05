-- 코드를 입력하세요
SELECT to_char(sales_date, 'yyyy') as year, to_char(o.sales_date, 'fmmm') as month, i.gender, count(distinct o.user_id) as users
from user_info i, online_sale o
where i.user_id = o.user_id and i.gender is not null
group by to_char(o.sales_date, 'yyyy'), to_char(o.sales_date, 'fmmm'), i.gender
order by to_number(year), to_number(month), gender;