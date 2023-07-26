DROP TABLE product CASCADE CONSTRAINTS;

CREATE TABLE product(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(100)		 NULL ,
		p_price                       		NUMBER(10)		 NULL ,
		p_img                         		VARCHAR2(100)		 NULL ,
		p_desc                        		VARCHAR2(100)		 NULL ,
		p_freeDelivery                		CHAR(10)		 DEFAULT 'N'		 NULL 
);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (p_no);