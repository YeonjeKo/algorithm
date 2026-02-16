-- 코드를 작성해주세요
with tmp as (select t.item_id
from item_info i, item_tree t
where t.parent_item_id = i.item_id and i.rarity = 'RARE'
)
select tmp.item_id, i.item_name, i.rarity
from tmp, item_info i
where tmp.item_id = i.item_id
order by tmp.item_id desc;