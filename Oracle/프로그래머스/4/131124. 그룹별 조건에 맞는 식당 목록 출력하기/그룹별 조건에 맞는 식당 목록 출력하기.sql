-- 코드를 입력하세요
with tmp as (select member_id, count(*) as count
            from rest_review
            group by member_id
            order by count desc
            fetch first 1 rows only)
SELECT p.member_name, r.review_text, to_char(r.review_date, 'yyyy-mm-dd') as review_date
from member_profile p, rest_review r, tmp
where p.member_id = r.member_id
    and p.member_id = tmp.member_id
order by to_date(review_date, 'yyyy-mm-dd'), r.review_text;
