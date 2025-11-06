-- 코드를 입력하세요
with s as (select product_id, sum(sales_amount) as sales_amount
           from offline_sale
           group by product_id)
SELECT p.product_code, p.price * s.sales_amount as sales
from product p, s
where p.product_id = s.product_id
order by sales desc, product_code asc;