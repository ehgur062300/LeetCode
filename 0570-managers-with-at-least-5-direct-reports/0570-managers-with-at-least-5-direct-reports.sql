# Write your MySQL query statement below
select name
from Employee e1
where (select count(*) from Employee e2 where e1.id = e2.managerId) >= 5 