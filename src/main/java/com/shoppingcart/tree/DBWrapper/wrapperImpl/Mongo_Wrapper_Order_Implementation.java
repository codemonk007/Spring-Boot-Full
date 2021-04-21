package com.shoppingcart.tree.DBWrapper.wrapperImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shoppingcart.tree.DBWrapper.MongoWrapperOrderDetails;
import com.shoppingcart.tree.dto.customqueryrepository.cartcustomRepository;
import com.shoppingcart.tree.dto.customqueryrepository.order_Custom_Repository;
import com.shoppingcart.tree.dto.mongorepository.cartRepository;
import com.shoppingcart.tree.dto.mongorepository.orderRepository;
import com.shoppingcart.tree.entiry.orderBase;
import com.shoppingcart.tree.entiry.orderDetails;

@Service
@Qualifier("order")
public class Mongo_Wrapper_Order_Implementation implements MongoWrapperOrderDetails{
	
	@Autowired
	private orderRepository _orderRepository;
	
	@Qualifier("orderRepoImpl")
	@Autowired
	private order_Custom_Repository _order_Custom_Repository;
	
	@Override
	public String toString() {
		return "Mongo_Wrapper_Order_Implementation []";
	}

	public Mongo_Wrapper_Order_Implementation() {
	}
	
	
	@Override
	public orderDetails save(orderDetails order) {
		// TODO Auto-generated method stub
		System.out.println("[inside of Db wrapper order]"+order);
		orderDetails orderDetails = _orderRepository.save(order);
		System.out.println("orderDetails-->"+orderDetails.getOrderDetails());
		for (orderBase _orderBase : orderDetails.getOrderDetails()) {
		    System.out.println("_orderBase--->"+_orderBase);
		}
		return orderDetails;
	}

	@Override
	public List<orderDetails> getAll() {
		// TODO Auto-generated method stub
	List<orderDetails> _orderDetails = _orderRepository.findAll();
	System.out.println("_orderDetails from impl--->"+_orderDetails);
	return _orderDetails;
	}

}
