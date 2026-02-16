-- 코드를 작성해주세요
# select fish.id, name.fish_name, fish.length
# from fish_info fish, fish_name_info name
# where fish.fish_type = name.fish_type
# group by fish.fish_type
# order by fish.length;

with tmp as (select fish.fish_type, max(length) as length, name.fish_name
from fish_info fish, fish_name_info name
where fish.fish_type = name.fish_type
group by fish.fish_type, name.fish_name)
select fish.id, tmp.fish_name, tmp.length
from fish_info fish, tmp
where fish.fish_type = tmp.fish_type and fish.length = tmp.length
order by fish.id;
