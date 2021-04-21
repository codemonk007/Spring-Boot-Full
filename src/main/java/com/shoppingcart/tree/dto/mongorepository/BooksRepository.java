package com.shoppingcart.tree.dto.mongorepository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BooksRepository extends MongoRepository<com.shoppingcart.tree.entiry.books, String> {

}