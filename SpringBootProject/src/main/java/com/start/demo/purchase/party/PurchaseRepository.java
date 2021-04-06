package com.start.demo.purchase.party;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PurchaseRepository extends MongoRepository<PurchaseModel,String > {

}
