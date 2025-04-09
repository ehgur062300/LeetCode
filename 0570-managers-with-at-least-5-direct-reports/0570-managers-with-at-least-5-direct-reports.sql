# Write your MySQL query statement below
with cte as (
    select *,count(*) as cnt
    from Employee
    where managerId IS NOT NULL
    group by managerId
)

select e.name
from Employee e, cte
where cte.cnt >= 5
and cte.managerId = e.id