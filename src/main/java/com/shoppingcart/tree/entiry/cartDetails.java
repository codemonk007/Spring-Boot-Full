package com.shoppingcart.tree.entiry;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "CartDetails")
public class cartDetails {
	@Id
	public String id;
	public String Denaminamtion;
	public Boolean addToWishList;
	public Boolean cartAdded;
	public String catagory;
	public String imageurl;
	public Number itemCount;
	public Number itemLeft;
	public String name;
	public Float price ;
	
	public cartDetails() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "cartDetails [id=" + id + ", Denaminamtion=" + Denaminamtion  + ", addToWishList="
				+ addToWishList + ", cartAdded=" + cartAdded + ", catagory=" + catagory + ", imageurl=" + imageurl
				+ ", itemCount=" + itemCount + ", itemLeft=" + itemLeft + ", name=" + name + ", price=" + price + "]";
	}

	public cartDetails(String id, String denaminamtion, Boolean addToWishList, Boolean cartAdded, String catagory,
			String imageurl, Number itemCount, Number itemLeft, String name, Float price) {
		super();
		this.id = id;
		Denaminamtion = denaminamtion;
		this.addToWishList = addToWishList;
		this.cartAdded = cartAdded;
		this.catagory = catagory;
		this.imageurl = imageurl;
		this.itemCount = itemCount;
		this.itemLeft = itemLeft;
		this.name = name;
		this.price = price;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDenaminamtion() {
		return Denaminamtion;
	}

	public void setDenaminamtion(String denaminamtion) {
		Denaminamtion = denaminamtion;
	}

	public Boolean getAddToWishList() {
		return addToWishList;
	}

	public void setAddToWishList(Boolean addToWishList) {
		this.addToWishList = addToWishList;
	}

	public Boolean getCartAdded() {
		return cartAdded;
	}

	public void setCartAdded(Boolean cartAdded) {
		this.cartAdded = cartAdded;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public Number getItemCount() {
		return itemCount;
	}

	public void setItemCount(Number itemCount) {
		this.itemCount = itemCount;
	}

	public Number getItemLeft() {
		return itemLeft;
	}

	public void setItemLeft(Number itemLeft) {
		this.itemLeft = itemLeft;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	

}
