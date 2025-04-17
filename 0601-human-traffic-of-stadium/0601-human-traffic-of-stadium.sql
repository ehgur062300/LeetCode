# Write your MySQL query statement below
with cte as (
    select s1.id, s1.visit_date, s1.people, s2.second, s2.third
    from (
        select id,visit_date,people
        from Stadium
        where people >= 100
        order by id
    ) as s1
    left join (
        select
            lead(j.id,1) over() as second,
            lead(j.id,2) over() as third
        from (
            select id,visit_date,people
            from Stadium
            where people >= 100
            order by id
        ) as j
    ) as s2
    on s1.id + 1 = s2.second and s1.id + 2 = s2.third
    where s2.second IS NOT NULL and s2.third IS NOT NULL
) 

select distinct(s.id), s.visit_date, s.people 
from Stadium s, cte c
where s.id = c.id or s.id = c.second or s.id = c.third