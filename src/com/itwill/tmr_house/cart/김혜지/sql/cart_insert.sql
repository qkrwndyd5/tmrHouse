desc cart;
/*
이름             널?       유형           
-------------- -------- ------------ 
C_NO           NOT NULL NUMBER(10) 
C_QTY                   NUMBER(10)   
M_ID                    VARCHAR2(50) 
P_NO                    NUMBER(10)   
P_IMG                   VARCHAR2(50) 
P_FREEDELIVERY          CHAR(10)  
*/

/************************cart insert************************/
--aaaa님
insert into cart (c_no, c_qty, m_id, p_no) values (cart_cart_no_SEQ.nextval,1,'aaaa',1);
insert into cart (c_no, c_qty, m_id, p_no) values (cart_cart_no_SEQ.nextval,3,'aaaa',3);

--bbbb님
insert into cart (c_no, c_qty, m_id, p_no) values (cart_cart_no_SEQ.nextval,2,'bbbb',2);
insert into cart (c_no, c_qty, m_id, p_no) values (cart_cart_no_SEQ.nextval,4,'bbbb',4);