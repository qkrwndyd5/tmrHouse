package com.itwill.tmr_house.cart.성민모;

public class CartService {
	
	private CartDao cartDao;
	public CartService() throws Exception {
		cartDao=new CartDao();
	}
	
	/*
	 * update, count
	 */
	
	//카트에 존재하는 상품을 추가(수량 변경)
	public int updateCartByCartNo(int c_no, int qty) throws Exception {
		return cartDao.updateByCartNo(c_no, qty);
	}
	
	public int updateCartByProductNo(int p_no, int qty, String m_id) throws Exception {
		return cartDao.updateByProductNo(p_no, qty, m_id);
	}
	
	//카트에 제품 존재하는지 확인
	public int countByProductNo(String m_id, int p_no) throws Exception {
		return cartDao.countByProductNo(m_id, p_no);	

    }
	
}