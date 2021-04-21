package com.shoppingcart.tree.dto.queryImplentors;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.shoppingcart.tree.dto.customqueryrepository.productRepository;
import com.shoppingcart.tree.entiry.books;
import com.shoppingcart.tree.entiry.cartDetails;
import com.shoppingcart.tree.entiry.mobiles;
import com.shoppingcart.tree.entiry.orderBase;
import com.shoppingcart.tree.entiry.vegitables;


@Repository	
public class productRepoImpl implements productRepository{
	  @Autowired
	  private final MongoTemplate mongoTemplate;
	  
	  @Autowired
	    public productRepoImpl(MongoTemplate mongoTemplate) {
	        this.mongoTemplate = mongoTemplate;
	    }
	  
	@Override
	public List<cartDetails> updateProduct(String id) {
		return mongoTemplate.findAll(cartDetails.class);
	}

	@Override
	public boolean updateProductForCatagory(String name, String Catagory,String Ops) {
		// TODO Auto-generated method stub
		System.out.println("Catagory--->"+Catagory);
		Query query = new Query();
		System.out.println("Ops---->"+Ops);
		switch (Ops) {
		case "addItemToCart":
			switch (Catagory.toString()) {
			case "Books":
				query.addCriteria(Criteria.where("name").is(name.toString()));
				books _books = mongoTemplate.find(query,books.class).get(0);
				_books.setCartAdded(true);
				_books.setItemCount(_books.getItemCount().intValue()+1);
				_books.setItemLeft(_books.getItemLeft().intValue()-1);
				mongoTemplate.save(_books);			
				System.out.println(_books);
				return true;
			case "Mobiles":
				query.addCriteria(Criteria.where("name").is(name.toString()));
				mobiles _mobile = mongoTemplate.find(query,mobiles.class).get(0);
				_mobile.setCartAdded(true);
				_mobile.setItemCount(_mobile.getItemCount().intValue()+1);
				_mobile.setItemLeft(_mobile.getItemLeft().intValue()-1);
				mongoTemplate.save(_mobile);			
				System.out.println("+_+_+"+_mobile);
				break;	
			case "Vegitables":
				query.addCriteria(Criteria.where("name").is(name.toString()));
				vegitables _vegitables = mongoTemplate.find(query,vegitables.class).get(0);
				_vegitables.setCartAdded(true);
				_vegitables.setItemCount(_vegitables.getItemCount().intValue()+1);
				_vegitables.setItemLeft(_vegitables.getItemLeft().intValue()-1);
				mongoTemplate.save(_vegitables);			
				System.out.println(_vegitables);
				break;
			default:
				break;
			}
			break;
		case "removeItemToCart":
			switch (Catagory.toString()) {
			case "Books":
				query.addCriteria(Criteria.where("name").is(name.toString()));
				books _books = mongoTemplate.find(query,books.class).get(0);
				_books.setCartAdded(false);
				_books.setItemCount(_books.getItemCount().intValue()-1);
				_books.setItemLeft(_books.getItemLeft().intValue()+1);
				mongoTemplate.save(_books);			
				System.out.println(_books);
				return true;
			case "Mobiles":
				query.addCriteria(Criteria.where("name").is(name.toString()));
				mobiles _mobile = mongoTemplate.find(query,mobiles.class).get(0);
				_mobile.setCartAdded(false);
				_mobile.setItemCount(_mobile.getItemCount().intValue()-1);
				_mobile.setItemLeft(_mobile.getItemLeft().intValue()+1);
				mongoTemplate.save(_mobile);			
				return true;	
			case "Vegitables":
				query.addCriteria(Criteria.where("name").is(name.toString()));
				vegitables _vegitables = mongoTemplate.find(query,vegitables.class).get(0);
				_vegitables.setCartAdded(false);
				_vegitables.setItemCount(_vegitables.getItemCount().intValue()-1);
				_vegitables.setItemLeft(_vegitables.getItemLeft().intValue()+1);
				mongoTemplate.save(_vegitables);			
				System.out.println(_vegitables);
				return true;
			default:
				break;
			}
			break;
		default:
			break;
		}
		return false;
	}
	
	public boolean updateProductForCatagory(String name, String Catagory,orderBase _orderBase) {
		Query query = new Query();
		switch (Catagory.toString()) {
		case "Books":
			query.addCriteria(Criteria.where("name").is(name.toString()));
			books _books = mongoTemplate.find(query,books.class).get(0);
			_books.setCartAdded(false);
			_books.setItemLeft(_orderBase.getItemLeft().intValue());
			System.out.println("_books.getItemLeft().intValue()--->"+_books.getItemLeft().intValue());
			_books.setItemCount(0);
			mongoTemplate.save(_books);				
			System.out.println(_books.getItemLeft());
			return true;
		case "Mobiles":
			query.addCriteria(Criteria.where("name").is(name.toString()));
			mobiles _mobile = mongoTemplate.find(query,mobiles.class).get(0);
			_mobile.setCartAdded(false);
			_mobile.setItemCount(0);
			_mobile.setItemLeft(_orderBase.getItemLeft().intValue());
			mongoTemplate.save(_mobile);			
			System.out.println(_mobile.getItemLeft());
			break;	
		case "Vegitables":
			query.addCriteria(Criteria.where("name").is(name.toString()));
			vegitables _vegitables = mongoTemplate.find(query,vegitables.class).get(0);
			_vegitables.setCartAdded(false);
			_vegitables.setItemCount(0);
			_vegitables.setItemLeft(_orderBase.getItemLeft().intValue());
			mongoTemplate.save(_vegitables);			
			System.out.println(_vegitables.getItemLeft());
			break;
		default:
			return false;
		}
		return false;
	}
}
