SELECT distinct 
    a.num ConsecutiveNums 
FROM
    Logs a 
        JOIN Logs b on a.id = b.id - 1
        JOIN logs c on b.id = c.id - 1
WHERE 
    a.num = b.num 
    and 
    b.num = c.num
;