-- 코드를 입력하세요
SELECT a.author_id, a.author_name, b.category, sum(s.sales * b.price) as total_sales
from book b, author a, book_sales s
where b.book_id = s.book_id and b.author_id = a.author_id 
    and to_char(s.sales_date, 'yyyy-mm') = '2022-01'
group by a.author_id, a.author_name, b.category
order by a.author_id, b.category desc;