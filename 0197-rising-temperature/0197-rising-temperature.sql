# Write your MySQL query statement below
select id
from (
    select *, 
        lead(temperature,1) over (order by recordDate desc) as yesterday_temp,
        lead(recordDate,1) over (order by recordDate desc) as l1
    from Weather
    order by recordDate
    
) as w
where temperature > yesterday_temp and datediff(recordDate,l1) = 1