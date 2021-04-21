package com.shoppingcart.tree.entiry;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Component;

@Component
public class product {
	
	 @DBRef
	public List<books> books;
	 @DBRef
	public List<mobiles> mobiles;
	 @DBRef
	public List<vegitables> vegitables;
	
	public List<books> getBooks() {
		return books;
	}
	public void setBooks(List<books> books) {
		this.books = books;
	}
	public List<mobiles> getMobiles() {
		return mobiles;
	}
	public void setMobiles(List<mobiles> mobiles) {
		this.mobiles = mobiles;
	}
	public List<vegitables> getVegitables() {
		return vegitables;
	}
	public void setVegitables(List<vegitables> vegitables) {
		this.vegitables = vegitables;
	}
	public product() {
		// TODO Auto-generated constructor stub
	}
	public product(List<books> books, List<mobiles> mobiles,
			List<vegitables> vegitables) {
		super();
		this.books = books;
		this.mobiles = mobiles;
		this.vegitables = vegitables;
	}
	@Override
	public String toString() {
		return "product [books=" + books + ", mobiles=" + mobiles + ", vegitables="
				+ vegitables + "]";
	}
	
	
	
}
