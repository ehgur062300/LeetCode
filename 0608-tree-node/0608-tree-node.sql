# Write your MySQL query statement below
select 
    distinct a.id,
    case 
        when a.p_id is null then 'Root'
        when b.id is null then 'Leaf'
        else 'Inner' end as type
from tree a
left join tree b 
on a.id = b.p_id;
