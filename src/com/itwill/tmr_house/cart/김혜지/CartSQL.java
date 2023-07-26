package com.itwill.tmr_house.cart.김혜지;

public class CartSQL {
	
	//카트에 새로운 상품 추가
	public static final String CART_INSERT_CART = 
			"insert into cart (c_no, c_qty, m_id, p_no) values (cart_cart_no_SEQ.nextval,?,?,?)";

	/************성민모님 CartSQL에서 가져온 메서드*************/
	public static final String CART_UPDATE_BY_CART_NO = 
			"update cart set cart_qty=? where cart_no=?";

	public static String CART_COUNT_BY_PRODUCT_NO = 
			"select count(*)  as p_count from cart c join userinfo u on c.m_id=u.m_id where u.m_id=? and c.p_no=?";
	/************************************************************/

	//카트에 담긴 특정 상품 삭제
	public static final String CART_DELETE_BY_CART_NO =
			"delete from cart where c_no = ?";

	//회원의 카트에 담긴 상품 전체 삭제
	public static final String CART_DELETE_BY_USERID =
			"delete from cart where m_id = ?";

	//카트에 담긴 특정 상품 찾기(카트 번호로)
	public static final String CART_SELECT_BY_CART_NO =
			"select c.*,p.* from cart c join product p on c.p_no = p.p_no where c_no = ?";

	//회원의 카트에 담긴 상품 전체 찾기
	public static final String CART_SELECT_BY_USERID =
			"select c.*,p.* from cart c join product p on c.p_no = p.p_no where m_id = ?";

	}

