-- 코드를 입력하세요
SELECT h.history_id, floor((datediff(end_date, start_date) + 1) * (100 - ifnull(p.discount_rate, 0)) * 0.01 * c.daily_fee) as fee
from car_rental_company_car c
join car_rental_company_rental_history h on c.car_id = h.car_id
left join car_rental_company_discount_plan p on c.car_type = p.car_type
    and p.duration_type = (case when datediff(end_date, start_date) + 1 >= 90 then '90일 이상'
                            when datediff(end_date, start_date) + 1 >= 30 then '30일 이상'
                            when datediff(end_date, start_date) + 1 >= 7 then '7일 이상'
                            else null
                      end)
where c.car_type = '트럭'
order by fee desc, h.history_id desc;

# select *
# from car_rental_company_rental_history h, car_rental_company_car c
# where h.car_id = c.car_id
#     and datediff(h.end_date, h.start_date) + 1 < 7;
                                                                                                                 