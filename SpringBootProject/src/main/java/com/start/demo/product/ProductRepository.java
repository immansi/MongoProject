package com.start.demo.product;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface ProductRepository extends MongoRepository<ProductModel ,String> {

}
