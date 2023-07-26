package com.itwill.tmr_house.order;

import java.util.ArrayList;
import java.util.List;

import com.itwill.tmr_house.cart.Cart;
import com.itwill.tmr_house.cart.CartDao;
import com.itwill.tmr_house.product.Product;
import com.itwill.tmr_house.product.ProductDao;

public class OrdersService {
	private OrdersDao ordersDao;
	private ProductDao productDao;
	private CartDao cartDao;
	
	public OrdersService() throws Exception {
		ordersDao = new OrdersDao();
		productDao = new ProductDao();
		cartDao = new CartDao();
	}
	
	//주문 한개 삭제
		public int deleteByOrderNo(int o_no) throws Exception {
			return ordersDao.deleteByOrderNo(o_no);
		}
		//주문 전체 삭제
		public int deleteByM_id(String m_id) throws Exception {
			return ordersDao.deleteByMemberId(m_id);
		}
		//주문리스트 아이디로 찾기
		public List<Orders> orderList(String m_id) throws Exception {
			return ordersDao.findById(m_id);
		}
		
		// 주문리스트 ( orderitem리스트까지) 아이디로찾기
		public List<Orders>orderListAddOrderItemList(String m_id) throws Exception{
			return ordersDao.findByMid(m_id);
		}
		
		//주문상세보기
		public Orders orderListDetail(String m_id,int o_no) throws Exception {
			return ordersDao.findByOrderNo(m_id, o_no);
		}
		
		//상품에서 직접주문
		public int directOrder(String m_id,int p_no,int oi_qty) throws Exception {
			Product product = productDao.findByProductNo(p_no);
			OrderItem orderItem = new OrderItem(0, oi_qty, p_no, product);
			List<OrderItem> orderItemList = new ArrayList<OrderItem>();
			orderItemList.add(orderItem);
			Orders newOrders = null;
			
			if(product.getP_freeDelivery().equals("N")) {
				newOrders =	new Orders(0, 
							    orderItemList.get(0).getProduct().getP_name(),
							   oi_qty,
							   (orderItemList.get(0).getOi_qty()*orderItemList.get(0).getProduct().getP_price()) + 3000,
							   null,
							   m_id);
							newOrders.setOrderItemList(orderItemList);
			}else {
				newOrders =	new Orders(0, 
					    orderItemList.get(0).getProduct().getP_name(),
					   oi_qty,
					   orderItemList.get(0).getOi_qty()*orderItemList.get(0).getProduct().getP_price(),
					   null,
					   m_id);
				
			}
			
			return ordersDao.insertOrder(newOrders);
		}
		
		//cart에서 주문
		public int cartOrder(String m_id) throws Exception{
			Product product = new Product();
			List<Cart> cartList=cartDao.findByUserId(m_id);
			List<OrderItem> orderItemList=new ArrayList<OrderItem>();
			String o_desc = null;
			int o_tot_price=0;
			int oi_tot_count=0;
			for (Cart cart : cartList) {
				OrderItem orderItem=new OrderItem(0,cart.getC_qty(),0, cart.getProduct());
				orderItemList.add(orderItem);
				o_tot_price+=orderItem.getOi_qty()*orderItem.getProduct().getP_price();
				oi_tot_count+=orderItem.getOi_qty();
			}
			if(cartList.get(0).getProduct().getP_freeDelivery().equals("N")) {
				o_tot_price += 3000;
			}else {
				
			}
			if(orderItemList.size() < 2) {
				 o_desc = orderItemList.get(0).getProduct().getP_name();
			} else {
				
				o_desc = orderItemList.get(0).getProduct().getP_name()+"외 "+(oi_tot_count-1)+" 개";
			}
			
			Orders newOrder=new Orders(0, o_desc, oi_tot_count, o_tot_price, null, m_id);
			newOrder.setOrderItemList(orderItemList);
			
			
			cartDao.deleteByUserId(m_id);
			return ordersDao.insertOrder(newOrder);
		}
		//cart에서 선택주문
		public int cartSelectOrder(String m_id,String[] cart_item_checks) throws Exception{
			Product product = new Product();
			List<OrderItem> orderItemList=new ArrayList<OrderItem>();
			int o_tot_price=0;
			int oi_tot_count=0;
			String o_desc = null;
			for(int i =0; i < cart_item_checks.length;i++) {
				Cart  cartItem = cartDao.findByCartNo(Integer.parseInt(cart_item_checks[i]));
				OrderItem orderItem=new OrderItem(0, cartItem.getC_qty(),0,cartItem.getProduct());
				orderItemList.add(orderItem);
				o_tot_price+=orderItem.getOi_qty()*orderItem.getProduct().getP_price();
				oi_tot_count+=orderItem.getOi_qty();
			}
			if(orderItemList.get(0).getProduct().getP_freeDelivery().equals("N")) {
				o_tot_price += 3000;
			}else {
				
			}
			if(orderItemList.size() < 2) {
				 o_desc = orderItemList.get(0).getProduct().getP_name();
			} else {
				
				o_desc = orderItemList.get(0).getProduct().getP_name()+"외 "+(oi_tot_count-1)+" 개";
			}
			
			Orders newOrder=new Orders(0,o_desc, oi_tot_count, o_tot_price,null, m_id);
			newOrder.setOrderItemList(orderItemList);
			
			for(int i = 0;i<cart_item_checks.length;i++) {
				cartDao.deleteByCartNo(Integer.parseInt(cart_item_checks[i]));
			}
			return ordersDao.insertOrder(newOrder);
		}

}