-- 코드를 작성해주세요
select count(*) as fish_count
from fish_info fi, fish_name_info fni
where fi.fish_type = fni.fish_type
    and fni.fish_name in ('BASS', 'SNAPPER');