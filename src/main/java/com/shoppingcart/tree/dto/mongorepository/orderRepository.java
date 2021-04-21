package com.shoppingcart.tree.dto.mongorepository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface orderRepository extends MongoRepository<com.shoppingcart.tree.entiry.orderDetails, String> {

}
