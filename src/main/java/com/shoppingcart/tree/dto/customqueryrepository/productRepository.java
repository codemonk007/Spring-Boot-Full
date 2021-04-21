package com.shoppingcart.tree.dto.customqueryrepository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.shoppingcart.tree.entiry.cartDetails;
import com.shoppingcart.tree.entiry.orderBase;

public interface productRepository {
	List<cartDetails> updateProduct(String id);
	boolean updateProductForCatagory(String name, String Catagory,String Ops);	
	boolean updateProductForCatagory(String name, String Catagory,orderBase _orderBase);
	
}
