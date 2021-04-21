package com.shoppingcart.tree.DBWrapper.wrapperImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shoppingcart.tree.DBWrapper.MongoWrapperCartDetails;
import com.shoppingcart.tree.dto.customqueryrepository.cartcustomRepository;
import com.shoppingcart.tree.dto.mongorepository.cartRepository;
import com.shoppingcart.tree.entiry.cartDetails;

@Service
@Qualifier("cart")
public class MongoWrapperCartImplementation implements MongoWrapperCartDetails {

	@Autowired
	private cartRepository _cartRepository;
	
	@Qualifier("cartRepoImpl")
	@Autowired
	private cartcustomRepository _cartcustomRepository;
	
	
	@Override
	public List<cartDetails>  saveAll(List<cartDetails> cart) {
		// TODO Auto-generated method stub
		try {	
			List<cartDetails> _CartDetails = _cartRepository.saveAll(cart);
		return _CartDetails;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("TEst");
			return null;
		}
	}
	@Override
	public cartDetails save(cartDetails cart) {
		// TODO Auto-generated method stub
		try {	
		cartDetails _CartDetails = _cartRepository.save(cart);
		System.out.println("_CartDetails-->"+_CartDetails);
		return _CartDetails;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("TEst");
			return null;
		}
	}
	
	
	@Override
	public List<cartDetails> getAll() {
		// TODO Auto-generated method stub
		List<cartDetails> _cartDetails = _cartRepository.findAll();
		return _cartDetails;
	}
	@Override
	public cartDetails removeCaerData(String _id) {
		// TODO Auto-generated method stub
		return _cartcustomRepository.removeFromCart(_id);
	}

}
