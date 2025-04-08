select
    round(count(a2.player_id) / count(a1.player_id), 2) as fraction
from
(
    select
        player_id,
        min(event_date) as first_event_date
    from Activity
    group by player_id
) as a1
left outer join Activity as a2
on a1.player_id = a2.player_id and a1.first_event_date = date_sub(a2.event_date, interval 1 day)