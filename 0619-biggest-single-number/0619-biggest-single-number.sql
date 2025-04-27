# Write your MySQL query statement below
with cte as (
    select num
    from MyNumbers
    group by num
    having count(num) = 1
)

select IFNULL(max(num),null) as num from cte