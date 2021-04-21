package com.shoppingcart.tree.DBWrapper.wrapperImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shoppingcart.tree.DBWrapper.MongoWrapperProduct;
import com.shoppingcart.tree.dto.mongorepository.BooksRepository;
import com.shoppingcart.tree.dto.mongorepository.mobilesRepository;
import com.shoppingcart.tree.dto.mongorepository.vegitableRepository;
import com.shoppingcart.tree.dto.queryImplentors.productRepoImpl;
import com.shoppingcart.tree.entiry.books;
import com.shoppingcart.tree.entiry.cartDetails;
import com.shoppingcart.tree.entiry.mobiles;
import com.shoppingcart.tree.entiry.orderBase;
import com.shoppingcart.tree.entiry.product;
import com.shoppingcart.tree.entiry.vegitables;


@Service
@Qualifier("vegitable")
public class MongoWrapperProductImplementation implements MongoWrapperProduct {

//	vegitables _vegitables;
//	
//	mobiles _mobiles;
//	
//	books _books;
	@Autowired
	productRepoImpl _productRepoImpl ;
	
	@Autowired
	private vegitableRepository _vegitableRepository;
	
	@Autowired
	private BooksRepository _BooksRepository;
	
	@Autowired
	private mobilesRepository _mobilesRepository;
	
	@Autowired
	product _product;
	
	@Override
	public product save(product product) {
		// TODO Auto-generated method stub		
		List<vegitables> _vegitables = _vegitableRepository.saveAll(product.getVegitables());
		List<books> _books = _BooksRepository.saveAll(product.getBooks());
		List<mobiles> _mobiles = _mobilesRepository.saveAll(product.getMobiles());
		_product.setVegitables(_vegitables);
		_product.setBooks(_books);
		_product.setMobiles(_mobiles);
		return _product;
	}

	@Override
	public List<vegitables> saveMany(product _product) {
		return null;
	}

	@Override
	public product getProducts() {
		// TODO Auto-generated method stub
		List<vegitables> _vegitables = _vegitableRepository.findAll();
		List<books> _books = _BooksRepository.findAll();
		List<mobiles> _mobiles = _mobilesRepository.findAll();
		_product.setVegitables(_vegitables);
		_product.setBooks(_books);
		_product.setMobiles(_mobiles);
		return _product;

	}
	public List<cartDetails> testget(String id){
		return _productRepoImpl.updateProduct(id);
		}

	@Override
	public boolean updateProductForCatagory(String name, String Catagory, String Ops) {
		// TODO Auto-generated method stub
		return _productRepoImpl.updateProductForCatagory(name, Catagory,Ops);
	}
	@Override
	
	public boolean updateProductForCatagory(String name, String Catagory,orderBase _orderBase) {
		// TODO Auto-generated method stub
		return _productRepoImpl.updateProductForCatagory(name, Catagory,_orderBase);
	}
	
	

}
