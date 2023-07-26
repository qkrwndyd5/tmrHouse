package com.itwill.tmr_house.cart;

import java.util.List;

public class CartService {
	private CartDao cartDao;

	public CartService() throws Exception {
		cartDao = new CartDao();
	}

	// 카트에 새로운 상품 추가
	public int insertCart(Cart cart) throws Exception {
		if (cartDao.countByProductNo(cart.getM_id(), cart.getC_no()) > 0) {
			return cartDao.updateByProductNo(cart.getProduct().getP_no(), cart.getC_qty(), cart.getM_id());
		} else {
			return cartDao.insert(cart);
		}
	}

	// updateByCartNo,
	public int updateCartByCartNo(int c_no, int qty) throws Exception {
		return cartDao.updateByCartNo(c_no, qty);
	}

	// 카트에 담긴 상품 수량 추가
	public int updateCartByProductNo(int p_no, int qty, String m_id) throws Exception {
		return cartDao.updateByProductNo(p_no, qty, m_id);
	}

	// 카트에 담긴 특정 상품 삭제
	public int deleteCartItemByCartNo(int c_no) throws Exception {
		return cartDao.deleteByCartNo(c_no);
	}

	// 회원의 카트에 담긴 상품 전체 삭제
	public int deleteCartItemByUserId(String m_id) throws Exception {
		return cartDao.deleteByUserId(m_id);
	}

	// 카트에 담긴 아이템 찾기(카트번호로)
	public Cart findCartItemByCartNo(int c_no) throws Exception {
		return cartDao.findByCartNo(c_no);
	}

	// 회원의 카트에 담긴 상품 전체 찾기
	public List<Cart> findCartItemByUserId(String m_id) throws Exception {
		return cartDao.findByUserId(m_id);
	}
}
