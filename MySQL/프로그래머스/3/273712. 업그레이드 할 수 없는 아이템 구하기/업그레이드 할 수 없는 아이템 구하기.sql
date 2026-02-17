-- 코드를 작성해주세요
select item_id, item_name, rarity
from item_info i
where not exists (
    select 1
    from item_tree t
    where i.item_id = t.parent_item_id
)
order by item_id desc;