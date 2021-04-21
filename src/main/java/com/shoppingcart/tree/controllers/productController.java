package com.shoppingcart.tree.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.tree.DBWrapper.MongoWrapperCartDetails;
import com.shoppingcart.tree.DBWrapper.MongoWrapperOrderDetails;
import com.shoppingcart.tree.DBWrapper.MongoWrapperProduct;
import com.shoppingcart.tree.entiry.cartDetails;
import com.shoppingcart.tree.entiry.orderBase;
import com.shoppingcart.tree.entiry.orderDetails;
import com.shoppingcart.tree.entiry.product;


@CrossOrigin(origins = "http://localhost:3000",maxAge = 6000)
@RestController
@RequestMapping("/api")
public class productController {
	
	@Qualifier("vegitable")
	@Autowired
	MongoWrapperProduct _MongoWrapperProduct;
	
	@Qualifier("cart")
	@Autowired
	MongoWrapperCartDetails _MongoWrapperCartDetails;
	
	@Qualifier("order")
	@Autowired
	MongoWrapperOrderDetails _MongoWrapperOrderDetails;
	
	Logger _Logger = LoggerFactory.getLogger(productController.class);
	
	  @PostMapping("/ProductList")
	  public ResponseEntity<product> createProductList(@RequestBody product productList) {
	    try {	
	    	System.out.println("inside controller");
	    	_Logger.info("++--------------inside controller-----------++");
	    	_Logger.info("adding new entry to ProductList");
	    	product Product = _MongoWrapperProduct.save(new product(productList.getBooks(),productList.getMobiles(),productList.getVegitables()));
	    	_Logger.info("Respone to be sent"+Product);
	         return new ResponseEntity<>(Product, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
 @GetMapping("/ProductList")	
 
	  public ResponseEntity<product> getProductList(@RequestHeader Map<String,String> headers) {
		  
		  headers.forEach((key,value) ->{
	            System.out.println("Header Name: "+key+" Header Value: "+value);
	        });
		  
	    try {	
	    	_Logger.info("++--------------inside controller-----------++");
	    	_Logger.info("Getting List of ProductList");
	    	product Product = _MongoWrapperProduct.getProducts();
	    	_Logger.info("ProductList response"+Product);
	         return new ResponseEntity<>(Product, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PostMapping("/addCartDetails")	
	  public ResponseEntity<cartDetails> postCartList(@RequestBody cartDetails cart) {
		  try {	
				_Logger.info("++--------------inside controller-----------++");
		    	_Logger.info("adding a product to Cart");
		    	cartDetails _cartDetails = _MongoWrapperCartDetails.save(cart);
		         String   Ops = "addItemToCart";
		    	boolean _Product = _MongoWrapperProduct.updateProductForCatagory(cart.getName(), cart.getCatagory(),Ops);
		    	_Logger.info("Cart Response"+_cartDetails);
		         return new ResponseEntity<>(_cartDetails, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }		
	  
	  @DeleteMapping("/removeCartDetails/{_id}")	
	  public ResponseEntity<cartDetails> removeCartList(@PathVariable String _id) {
		  
		  
		  try {	
		    	_Logger.info("++--------------inside controller-----------++");
		    	_Logger.info("removing Item from controller"+_id);
		    	cartDetails _cartDetails = _MongoWrapperCartDetails.removeCaerData(_id);
		    	String   Ops = "removeItemToCart";
		    	boolean _Product = _MongoWrapperProduct.updateProductForCatagory(_cartDetails.getName(), _cartDetails.getCatagory(),Ops);
		    	_Logger.info("removing Item from controller"+_cartDetails);
		         return new ResponseEntity<>(_cartDetails, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }

	  @PutMapping("/CartDetails")	
	  public ResponseEntity<cartDetails> updateCartList(@RequestBody cartDetails cart) {
		  try {	
			  _Logger.info("inside controller"+cart);
		    	cartDetails _cartDetails = _MongoWrapperCartDetails.save(cart);
		         return new ResponseEntity<>(_cartDetails, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }	
	  
	  @PutMapping("/cartDetails/{id}")	
	  public ResponseEntity<cartDetails> updateCartList(@RequestBody List<cartDetails> cart) {
		  try {	
		    	System.out.println("inside controller"+cart);
		    	List<cartDetails> _cartDetails = _MongoWrapperCartDetails.saveAll(cart);
//		    	_MongoWrapperProduct.updateProductForCatagory(name, Catagory)
//		         return new ResponseEntity<>(_cartDetails, HttpStatus.CREATED);
		    	return null;
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }	
	  
	  @GetMapping("/cartList")	
	  
	  public ResponseEntity<List<cartDetails>> getcartList() {
	    try {	
	    	System.out.println("inside controller");
	    	List<cartDetails> _cartDetails = _MongoWrapperCartDetails.getAll();
	    	
	         return new ResponseEntity<List<cartDetails>>(_cartDetails, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	   
	  @PutMapping("/testget/{id}")	
	  public ResponseEntity<List<cartDetails>> getRandom(@PathVariable String id) {
		  try {	
		    	
		    	List<cartDetails> product = _MongoWrapperProduct.testget(id);
		    	return new ResponseEntity<List<cartDetails> >(product,HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	  
	  @PostMapping("/orderCheckout")
	  public ResponseEntity<orderDetails> checkOutOrder(@RequestBody orderDetails orderDetails){
		 try {
			 System.out.println("order checkout cart"+orderDetails);
			  orderDetails _orderDetails = _MongoWrapperOrderDetails.save(orderDetails);
			  if(_orderDetails.getOrderDetails().size()>0) {			  
				  for (orderBase _orderBase : _orderDetails.getOrderDetails()) {
					    System.out.println("_orderBase--->"+_orderBase);
					    _MongoWrapperCartDetails.removeCaerData(_orderBase.getId());
					    _MongoWrapperProduct.updateProductForCatagory(_orderBase.getName(), _orderBase.getCatagory(),_orderBase);
					}
			  }
			  return new ResponseEntity<orderDetails>(_orderDetails,HttpStatus.CREATED);
		 }
		 catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	  
	  @GetMapping("/getOrderDetails")
	  public ResponseEntity<List<orderDetails>> getOrderSummary(){
		  try {
		  List<orderDetails> _orderDetails = _MongoWrapperOrderDetails.getAll();
		  System.out.println("_orderDetails"+_orderDetails);
		  return new ResponseEntity<List<orderDetails>>(_orderDetails,HttpStatus.CREATED);
	  } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
}