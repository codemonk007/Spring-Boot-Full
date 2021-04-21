package com.shoppingcart.tree.entiry;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "mobiles")
public class mobiles {
	
	@Id
	public String id;
	public String name;
	public String catagory;
	public Boolean addToWishList;
	public Boolean cartAdded;
	public Float Price;
	public String imageurl;
	public String Denaminamtion;
	public Number itemCount;
	public Number itemLeft;
	public mobiles() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public mobiles(String name, String catagory, Boolean addToWishList, Boolean cartAdded, Float price,
			String imageurl, String denaminamtion, Number itemCount, Number itemLeft) {
		super();
		this.name = name;
		this.catagory = catagory;
		this.addToWishList = addToWishList;
		this.cartAdded = cartAdded;
		Price = price;
		this.imageurl = imageurl;
		Denaminamtion = denaminamtion;
		this.itemCount = itemCount;
		this.itemLeft = itemLeft;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
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
	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		Price = price;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getDenaminamtion() {
		return Denaminamtion;
	}
	public void setDenaminamtion(String denaminamtion) {
		Denaminamtion = denaminamtion;
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
	@Override
	public String toString() {
		return "mobiles [id=" + id + ", name=" + name + ", catagory=" + catagory + ", addToWishList=" + addToWishList
				+ ", cartAdded=" + cartAdded + ", Price=" + Price + ", imageurl=" + imageurl + ", Denaminamtion="
				+ Denaminamtion + ", itemCount=" + itemCount + ", itemLeft=" + itemLeft + "]";
	}
	
	
}
