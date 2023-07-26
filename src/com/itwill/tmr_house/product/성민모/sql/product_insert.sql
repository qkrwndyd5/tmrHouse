desc product;
/*
이름             널?       유형            
-------------- -------- ------------- 
P_NO           NOT NULL NUMBER(10)    
P_NAME                  VARCHAR2(100)  
P_PRICE                 NUMBER(10)    
P_IMG                   VARCHAR2(100)  
P_DESC                  VARCHAR2(100) 
P_FREEDELIVERY NOT NULL String(10) 
*/

/************************product insert************************/

insert into product values (1, '리브 우드 침대', 189000, null, 'LED 헤드3단 원목수납침대', 'N');
insert into product values (2, '모던 우드 침대', 140000, null, '모리 TK76  원목침대', 'N');
insert into product values (3, '침대 틈새 선반', 70000,  null, '틈새 슬림 선반 ', 'Y');
insert into product values (4, '침대 틈새 서랍장',221000, null,'침대옆 간이 서랍장 원목 협탁', 'Y');