SELECT distinct 
    num ConsecutiveNums 
FROM (
    select num
        , lead(num,1) over (order by id) as l1
        , lead(num,2) over (order by id) as l2
    from Logs) as l
WHERE 
    num = l1 and l1 = l2
;