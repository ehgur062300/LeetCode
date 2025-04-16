-- # Write your MySQL query statement below
with cte as (
    select 
        MAX(o1.cnt) as max_cnt
    from (
        select customer_number, count(*) as cnt
        from Orders
        group by customer_number
    ) as o1
)

select o2.customer_number 
from (
    select customer_number, count(*) as cnt
    from Orders
    group by customer_number
) o2, cte c
where o2.cnt = c.max_cnt