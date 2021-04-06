package com.start.demo.purchase.purchaseOrder;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PurchaseOrderRepository extends MongoRepository<PurchaseOrderModel, String>{

}
