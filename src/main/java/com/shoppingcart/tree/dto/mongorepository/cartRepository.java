package com.shoppingcart.tree.dto.mongorepository;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface cartRepository extends MongoRepository<com.shoppingcart.tree.entiry.cartDetails, String> {

}