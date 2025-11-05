-- 코드를 입력하세요
SELECT i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, round(avg(r.review_score), 2) as score
from rest_info i, rest_review r
where i.rest_id = r.rest_id and i.address like '서울%'
group by i.rest_id, i.rest_name, i.food_type, i.favorites, i.address
order by score desc, i.favorites desc;