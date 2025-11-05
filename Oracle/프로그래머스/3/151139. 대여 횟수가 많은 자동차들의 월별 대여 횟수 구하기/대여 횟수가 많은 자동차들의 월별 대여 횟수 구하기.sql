-- 코드를 입력하세요
SELECT extract(month from start_date) as month, car_id, count(*) as records
from car_rental_company_rental_history
where car_id in (select car_id
                 from car_rental_company_rental_history
                 where start_date >= date '2022-08-01' and start_date <= date '2022-10-31'
                group by car_id
                having count(*) >= 5)
    and start_date >= date '2022-08-01' and start_date <= date '2022-10-31'
group by extract(month from start_date), car_id
having count(*) > 0
order by to_number(month), car_id desc;