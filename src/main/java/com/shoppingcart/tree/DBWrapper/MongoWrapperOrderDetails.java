package com.shoppingcart.tree.DBWrapper;

import java.util.List;

import com.shoppingcart.tree.entiry.orderDetails;

public interface MongoWrapperOrderDetails {
	orderDetails save(orderDetails order);
	List<orderDetails> getAll();
}
