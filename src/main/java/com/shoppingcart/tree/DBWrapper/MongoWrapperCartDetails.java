package com.shoppingcart.tree.DBWrapper;

import java.util.List;

import com.shoppingcart.tree.entiry.cartDetails;


public interface MongoWrapperCartDetails {

	List<cartDetails> saveAll(List<cartDetails> cart);
	cartDetails save(cartDetails cart);
	List<cartDetails> getAll();
	cartDetails removeCaerData(String _id); 
	
}
