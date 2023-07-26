package com.itwill.tmr_house.cart.김혜지;

import java.util.List;

public class CartService {
	private CartDao cartDao;
	public CartService() throws Exception {
		cartDao = new CartDao();
	}
	
	//카트에 새로운 상품 추가
	public int insertCart(Cart cart) throws Exception {
		if(cartDao.countByProductNo(cart.getM_id(), cart.getProduct().getP_no(), cart.getC_qty()) > 0) {
			return cartDao.updateByCartNo(cart.getM_id(), cart.getC_qty(), cart.getProduct().getP_no());
		}else {
			return cartDao.insertCart(cart);
		}
	}
	
	
	
	/*
	 * updateByCartNo, countByProductNo
	 */
	
	
	//카트에 담긴 특정 상품 삭제
	public int deleteCartItemByCartNo(int c_no) throws Exception {
		return cartDao.deleteByCartNo(c_no);
	}

	
	//회원의 카트에 담긴 상품 전체 삭제
	public int deleteCartItemByUserId(String m_id) throws Exception {
		return cartDao.deleteByUserId(m_id);
	}
	
	
	//카트에 담긴 아이템 찾기(카트번호로)
	public Cart findCartItemByCartNo(int c_no) throws Exception {
		return cartDao.findByCartNo(c_no);
	}

	
	//회원의 카트에 담긴 상품 전체 찾기
	public List<Cart> findCartItemByUserId(String m_id) throws Exception{
		return cartDao.findByUserId(m_id);
	}
	
}