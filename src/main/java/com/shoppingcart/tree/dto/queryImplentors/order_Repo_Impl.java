package com.shoppingcart.tree.dto.queryImplentors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shoppingcart.tree.dto.customqueryrepository.cartcustomRepository;
import com.shoppingcart.tree.dto.customqueryrepository.order_Custom_Repository;
import com.shoppingcart.tree.entiry.cartDetails;

@Service
@Qualifier("orderRepoImpl")
public class order_Repo_Impl implements order_Custom_Repository {

	
}
