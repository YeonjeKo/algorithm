-- 코드를 입력하세요
SELECT board_id, writer_id, title, price, case when used_goods_board.status = 'SALE' then '판매중'
                                                when used_goods_board.status = 'RESERVED' then '예약중'
                                                when used_goods_board.status = 'DONE' then '거래완료'
                                            end as status
from used_goods_board
where created_date = '2022-10-05'
order by board_id desc;