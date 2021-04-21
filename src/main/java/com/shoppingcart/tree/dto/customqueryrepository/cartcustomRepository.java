package com.shoppingcart.tree.dto.customqueryrepository;

import com.shoppingcart.tree.entiry.cartDetails;

public interface cartcustomRepository {

	cartDetails removeFromCart(String _id);
}
