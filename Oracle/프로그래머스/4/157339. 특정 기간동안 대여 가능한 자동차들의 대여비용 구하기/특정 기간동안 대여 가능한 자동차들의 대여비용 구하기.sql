-- 코드를 입력하세요
with d as (select plan_id, car_type, duration_type, discount_rate
                 from car_rental_company_discount_plan
                  where regexp_substr(duration_type, '[0-9]+') = '30'),
tmp as (
    SELECT distinct c.car_id, c.car_type, (c.daily_fee * 0.01 * (100 - d.discount_rate) * 30) as fee
    from car_rental_company_car c, d
    where c.car_type = d.car_type
        and (c.car_type = '세단' or c.car_type = 'SUV')
        and not exists (
            select 1
            from car_rental_company_rental_history r
            where r.car_id = c.car_id
                and r.start_date <= to_date('2022-11-30', 'yyyy-mm-dd') and r.end_date > to_date('2022-11-01', 'yyyy-mm-dd')
        ) 
    )
SELECT car_id, car_type, fee
from tmp
where fee >= 500000 and fee <= 2000000
order by fee desc, car_type, car_id desc;
