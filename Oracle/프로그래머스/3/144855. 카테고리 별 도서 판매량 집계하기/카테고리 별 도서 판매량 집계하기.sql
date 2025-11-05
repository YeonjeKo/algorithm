-- 코드를 입력하세요
SELECT b.category, sum(s.sales) as total_sales
from book b, book_sales s
where b.book_id = s.book_id and to_char(s.sales_date, 'yyyy-mm') = '2022-01'
group by category
order by category;