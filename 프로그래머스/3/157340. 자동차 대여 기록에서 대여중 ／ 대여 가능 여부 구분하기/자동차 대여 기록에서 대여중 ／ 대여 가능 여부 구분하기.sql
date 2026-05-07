select car_id, case when min(case 
                    when date('2022-10-16') between start_date and end_date then '0'
                    when date('2022-10-16') = end_date then '0'
                    else '1' 
                    end) = 0 then '대여중' else '대여 가능' end as availability
                 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc
