package com.shoppingcart.tree.dto.queryImplentors;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.DeleteResult;
import com.shoppingcart.tree.dto.customqueryrepository.cartcustomRepository;
import com.shoppingcart.tree.dto.customqueryrepository.productRepository;
import com.shoppingcart.tree.dto.mongorepository.cartRepository;
import com.shoppingcart.tree.entiry.cartDetails;
import com.shoppingcart.tree.entiry.mobiles;

@Service
@Qualifier("cartRepoImpl")
public class cartRepoImpl implements cartcustomRepository{
	  @Autowired
	  private final MongoTemplate mongoTemplate;
	  
	  @Autowired
	    public cartRepoImpl(MongoTemplate mongoTemplate) {
	        this.mongoTemplate = mongoTemplate;
	    }

	@Override
	public cartDetails removeFromCart(String _id) {
	System.out.println("_id ------->"+_id);
	  	Query query = new Query();
	  	query.addCriteria(Criteria.where("_id").exists(true)
          .orOperator(Criteria.where("_id").is(_id)));
	  	cartDetails _cartDetails = mongoTemplate.findAndRemove(query,cartDetails.class);
	  	System.out.println("cartDetails--->"+_cartDetails);
		return _cartDetails;
	}
}