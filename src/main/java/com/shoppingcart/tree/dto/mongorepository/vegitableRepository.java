package com.shoppingcart.tree.dto.mongorepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface vegitableRepository extends MongoRepository<com.shoppingcart.tree.entiry.vegitables, String> {

}