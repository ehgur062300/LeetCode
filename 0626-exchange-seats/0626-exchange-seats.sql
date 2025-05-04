# Write your MySQL query statement below
with cte as (
    select * from Seat order by id desc limit 1
)

select 
    s1.id,
    case
        when c.id % 2 != 0 and s1.id = c.id then (select s2.student from Seat s2 where s2.id = s1.id)
        when s1.id % 2 = 0 then (select s2.student from Seat s2 where s2.id = s1.id-1)
        when s1.id % 2 != 0 then (select s2.student from Seat s2 where s2.id = s1.id+1)
    end as student
from Seat s1, cte c

