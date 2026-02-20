-- 코드를 입력하세요
SELECT concat('/home/grep/src/', b.board_id, '/', f.file_id, f.file_name, f.file_ext) as file_path
from used_goods_board b, used_goods_file f
where b.board_id = f.board_id 
and b.views = (select max(views)
                from used_goods_board)
order by f.file_id desc;
