# Write your MySQL query statement below
with cte as (
    select distinct p_id
    from Tree
)

select 
    id,
    case
        when p_id is null then 'Root'
        when id in (select * from cte) then 'Inner'
        else 'Leaf'
    end as type
from Tree
