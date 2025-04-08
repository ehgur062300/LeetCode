WITH cte AS (
    SELECT 
        player_id,
        event_date,
        LEAD(event_date) OVER (
            PARTITION BY player_id 
            ORDER BY event_date
        ) AS next_event_date,
        ROW_NUMBER() OVER(PARTITION BY player_id ORDER BY event_date) AS rn
    FROM Activity
)

SELECT 
    Round(count(*)/(SELECT count(*) FROM cte WHERE rn = 1),2) AS fraction
FROM cte
WHERE DATE_ADD(event_date,INTERVAL 1 DAY) = next_event_date
AND rn = 1
