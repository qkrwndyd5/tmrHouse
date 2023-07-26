/**********************member insert************************/
insert into member(m_id, m_pw, m_name, m_birth, m_phone, m_address) values('aaaa','aaaa','철수','920630','1234-5698','떡잎마을');
insert into member(m_id, m_pw, m_name, m_birth, m_phone, m_address) values('bbbb','bbbb','유리','920731','4568-8547','떡잎마을');
insert into member(m_id, m_pw, m_name, m_birth, m_phone, m_address) values('cccc','cccc','짱구','921225','9512-7584','떡잎마을');

/*********************product insert*************************/
insert into product values (product_p_no_SEQ.nextval, '스틸 원형 테이블', 120000, 'table_steel_round150.png', '미드센추리 모던 테이블', 'N');
insert into product values (product_p_no_SEQ.nextval, '원목 사각 테이블', 90000, 'table_wood_square150.png', '내추럴한 원목 테이블', 'N');
insert into product values (product_p_no_SEQ.nextval, '스틸 원목 의자', 110000, 'chair_steel_wood150.png', '미드센추리 모던 감성의 미니멀한 의자', 'Y');
insert into product values (product_p_no_SEQ.nextval, '라탄 원목 의자', 50000, 'chair_rattan_wood150.png', '고무나무 원목과 라탄이 조화로운 의자', 'Y');
insert into product values (product_p_no_SEQ.nextval, '테이블 조명', 10000, 'lighting_short_table150.png', '탁상용 단스탠드. 지름 20cm, 높이 30cm', 'Y');
insert into product values (product_p_no_SEQ.nextval, '팬턴트 조명', 50000, 'lighting_ceiling_pendant150.png', '식탁용 천장 조명. 지름 40cm, 길이 160cm', 'Y');
insert into product values (product_p_no_SEQ.nextval, '몬스테라 화분', 30000, 'plant_monstera150.png', '초보자도 키우기 쉬운 공기정화 식물', 'Y');
insert into product values (product_p_no_SEQ.nextval, '올리브 나무 화분', 20000, 'plant_olive150.png', '건조한 환경을 좋아하는 플랜테리어 식물', 'Y');

/*********************cart insert**********************/
--aaaa
insert into cart(c_no, c_qty, m_id, p_no) values(cart_c_no_SEQ.nextval,1,'aaaa',1);
insert into cart(c_no, c_qty, m_id, p_no) values(cart_c_no_SEQ.nextval,1,'aaaa',2);
insert into cart(c_no, c_qty, m_id, p_no) values(cart_c_no_SEQ.nextval,1,'aaaa',3);

--bbbb
insert into cart(c_no, c_qty, m_id, p_no) values(cart_c_no_SEQ.nextval,1,'bbbb',2);
insert into cart(c_no, c_qty, m_id, p_no) values(cart_c_no_SEQ.nextval,2,'bbbb',3);
insert into cart(c_no, c_qty, m_id, p_no) values(cart_c_no_SEQ.nextval,1,'bbbb',4);

/*********************orders insert*********************/
/*
aaaa님이
    제품번호 1번 1개
    제품번호 3번 1개
*/
-- orders insert
insert into orders(o_no, o_desc, o_qty, o_price, o_date,m_id) values(orders_o_no_SEQ.nextval,'스틸 원형 테이블 외 1건',1,230000,sysdate,'aaaa');

-- order item insert
-- 제품번호 1번 1개 
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,1);

-- 제품번호 3번 1개
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,3);

/*
bbbb님이
    제품번호 2번 1개
    제품번호 3번 2개
    제품번호 4번 1개
*/
-- orders insert
insert into orders(o_no, o_desc, o_qty, o_price, o_date,m_id) values(orders_o_no_SEQ.nextval,'원목 사각테이블 외 2건',1,363000,sysdate,'bbbb');

-- order item insert
-- 제품번호 2번 1개
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,2);

-- 제품번호 3번 2개
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_SEQ.nextval,2,orders_o_no_SEQ.currval,3);

--제품번호 4번 1개
insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,4);

commit;






select * from orders o join order_item oi on o.o_no = oi.o_no join product p on oi.p_no = p.p_no where o.m_id='bbbb';

