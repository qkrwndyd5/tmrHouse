/****************************order*******************************/
--aaaa멤버의 주문전체목록
select * from orders where m_id = 'aaaa';

--주문(주문아이템+제품) 전체목록
select * 
    from orders o
    join order_item oi
    on o.o_no = oi.o_no
    join product p
    on oi.p_no = p.p_no
where m_id = 'aaaa';

-- 주문(주문아이템+제품) 한개목록
select * 
    from orders o
    join order_item oi
    on o.o_no = oi.o_no
    join product p
    on oi.p_no = p.p_no
where m_id = 'aaaa' and o.o_no=2;

--주문삭제(delete)
delete from orders where o_no=1;
delete from orders where m_id='aaaa';