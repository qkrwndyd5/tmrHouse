package com.itwill.tmr_house.admin;

import java.util.ArrayList;
import java.util.List;

import com.itwill.tmr_house.member.Member;
import com.itwill.tmr_house.member.MemberDao;
import com.itwill.tmr_house.order.이찬영.Order;
import com.itwill.tmr_house.order.이찬영.OrderDao;
import com.itwill.tmr_house.product.Product;
import com.itwill.tmr_house.product.ProductDao;

public class AdminService {
	private MemberDao memberDao;
	private OrderDao orderDao;
	private ProductDao productDao;
	
	
	public AdminService() throws Exception {
		memberDao= new MemberDao();
		orderDao= new OrderDao();
		productDao = new ProductDao();
		
	}
	//회원전체리스트
	public List<Member> adMemberListAll() throws Exception {
		return memberDao.findAll();
	}
	//주문전체리스트 //오더서비스에 findAll() 메소드 추가 //sql문 추가
	/*public List<Order> adOrderListAll() throws Exception {
		return orderDao.findByAll();
	}*/
	//상품추가
	public int adProductInsert(Product product) throws Exception {
		return productDao.insert(product);
	}
	//상품삭제
	public int adProductDelete(int p_no) throws Exception {
		return productDao.deleteByNo(p_no);
	}
	//상품업데이트
	public int adProductUpdate(Product product) throws Exception {
		return productDao.updateProduct(product);
	}
	
	
	
	
}
