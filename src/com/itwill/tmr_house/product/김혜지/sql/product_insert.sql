desc product;

/*
이름             널?       유형            
-------------- -------- ------------- 
P_NO           NOT NULL NUMBER(10)    
P_NAME                  VARCHAR2(50)  
P_PRICE                 NUMBER(10)    
P_IMG                   VARCHAR2(50)  
P_DESC                  VARCHAR2(512) 
P_FREEDELIVERY          VARCHAR2(50) 
*/

/************************product insert************************/

insert into product values (product_p_no_SEQ.nextval, '스틸 원형 테이블', 120000, null, '미드센추리 모던 테이블', 'N');
insert into product values (product_p_no_SEQ.nextval, '원목 사각 테이블', 90000, null, '내추럴한 원목 테이블', 'N');
insert into product values (product_p_no_SEQ.nextval, '스틸 원목 의자', 110000, null, '미드센추리 모던 감성의 미니멀한 의자', 'Y');
insert into product values (product_p_no_SEQ.nextval, '라탄 원목 의자', 50000, null, '고무나무 원목과 라탄이 조화로운 의자', 'Y');
insert into product values (product_p_no_SEQ.nextval, '테이블 조명', 10000, null, '탁상용 단스탠드. 지름 20cm, 높이 30cm', 'Y');
insert into product values (product_p_no_SEQ.nextval, '팬턴트 조명', 50000, null, '식탁용 천장 조명. 지름 40cm, 길이 160cm', 'Y');
insert into product values (product_p_no_SEQ.nextval, '몬스테라 화분', 30000, null, '초보자도 키우기 쉬운 공기정화 식물', 'Y');
insert into product values (product_p_no_SEQ.nextval, '올리브 나무 화분', 20000, null, '건조한 환경을 좋아하는 플랜테리어 식물', 'Y');


