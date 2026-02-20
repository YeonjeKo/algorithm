-- 코드를 입력하세요
SELECT distinct c.car_id
from car_rental_company_car c, car_rental_company_rental_history h
where c.car_id = h.car_id
and c.car_type = '세단' and month(h.start_date) = 10
order by car_id desc;