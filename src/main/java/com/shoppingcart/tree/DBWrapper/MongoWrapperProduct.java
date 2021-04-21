package com.shoppingcart.tree.DBWrapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.shoppingcart.tree.entiry.cartDetails;
import com.shoppingcart.tree.entiry.orderBase;
import com.shoppingcart.tree.entiry.product;
import com.shoppingcart.tree.entiry.vegitables;

@Component
public interface MongoWrapperProduct {
	
	List<vegitables>  saveMany(product p);
	product save(product p);
	product getProducts();
	List<cartDetails> testget(String id);
	boolean updateProductForCatagory(String name,String Catagory,String Ops);
	boolean updateProductForCatagory(String name, String Catagory, orderBase _orderBase);
}
