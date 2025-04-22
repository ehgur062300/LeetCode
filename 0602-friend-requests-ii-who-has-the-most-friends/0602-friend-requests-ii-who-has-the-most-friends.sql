# Write your MySQL query statement below
with cte as (
    select 
        requester_id as id,
        count(*) as cnt
    from RequestAccepted
    group by id
    union all
    select 
        accepter_id as id,
        count(*) as cnt
    from RequestAccepted
    group by id
)
select id, sum(cnt) as num 
from cte 
group by id
order by num desc
limit 1