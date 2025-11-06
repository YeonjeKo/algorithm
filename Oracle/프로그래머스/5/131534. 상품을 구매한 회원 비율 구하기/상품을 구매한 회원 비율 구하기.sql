-- 코드를 입력하세요
with tmp as (select to_char(o.sales_date, 'yyyy') as year, to_char(o.sales_date, 'fmmm') as month, count(distinct o.user_id) as purchased_users
           from online_sale o, user_info u
           where o.user_id = u.user_id
                and to_char(u.joined, 'yyyy') = '2021'
           group by to_char(o.sales_date, 'yyyy'), to_char(o.sales_date, 'fmmm')),
total as (select count(*) as t
          from user_info
          where to_char(joined, 'yyyy') = '2021')
select tmp.year, tmp.month, tmp.purchased_users, round(tmp.purchased_users / total.t, 1) as puchased_ratio
from tmp, total
order by to_number(tmp.year), to_number(tmp.month);