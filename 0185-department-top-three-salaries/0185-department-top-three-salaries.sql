# Write your MySQL query statement below
with cte as (
    select 
        departmentId as id,
        salary as Salary,
        name as Employee,
        dense_rank() over(partition by departmentId order by salary desc) as rnk
    from Employee 
)
select d.name as Department, Employee, Salary
from cte
join Department d
on d.id = cte.id
where cte.rnk < 4
