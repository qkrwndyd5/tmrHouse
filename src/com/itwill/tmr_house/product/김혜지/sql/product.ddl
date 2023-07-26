DROP TABLE product CASCADE CONSTRAINTS;

CREATE TABLE product(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(50)		 NULL ,
		p_price                       		NUMBER(10)		 NULL ,
		p_img                         		VARCHAR2(50)		 NULL ,
		p_desc                        		VARCHAR2(512)		 NULL ,
		p_freeDelivery                		VARCHAR2(50)		 NULL 
);



ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (p_no);

