# Write your MySQL query statement below
WITH cte AS (
    SELECT DISTINCT sales_id
    FROM Orders
    WHERE com_id IN (SELECT com_id FROM Company WHERE name = 'RED')
)
SELECT DISTINCT s.name
FROM SalesPerson s
WHERE NOT EXISTS (
    SELECT 1
    FROM cte c
    WHERE c.sales_id = s.sales_id
);