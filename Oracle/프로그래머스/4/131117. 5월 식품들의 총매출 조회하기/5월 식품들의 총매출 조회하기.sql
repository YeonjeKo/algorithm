-- 코드를 입력하세요
with o as (select product_id, sum(amount) as amount
                     from food_order
                     where to_char(produce_date, 'yyyy-mm') = '2022-05'
                     group by product_id)
SELECT p.product_id, p.product_name, (p.price * o.amount) as total_sales
from food_product p, o
where p.product_id = o.product_id
order by total_sales desc, p.product_id asc;

