select car_id, case 
                when max(case
                            when to_date('2022-10-16', 'yyyy-mm-dd') between start_date and end_date then '1'
                            else '0'
                         end) > 0 then '대여중'
                else '대여 가능'
               end as availability
from car_rental_company_rental_history
group by car_id
order by car_id desc;