# Write your MySQL query statement below

select 
    a.id,
    case when a.id % 2 = 1 and b.id is not null then b.student 
        when a.id % 2 = 0 then c.student 
        else a.student end as student
from Seat a
left join Seat b
on a.id=b.id - 1
left join Seat c
on a.id=c.id + 1
