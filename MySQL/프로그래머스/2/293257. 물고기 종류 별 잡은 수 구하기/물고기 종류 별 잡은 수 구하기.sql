-- 코드를 작성해주세요
# with info as (select fish_type, count(*) as fish_count
#              from fish_info
#              group by fish_type
#              )
# select info.fish_count, name.fish_name
# from info, fish_name_info name
# where info.fish_type = name.fish_type
# order by info.fish_count desc;

select count(*) as fish_count, name.fish_name
from fish_info info, fish_name_info name
where info.fish_type = name.fish_type
group by name.fish_name
order by fish_count desc;