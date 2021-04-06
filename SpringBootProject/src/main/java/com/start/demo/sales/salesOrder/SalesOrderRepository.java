package com.start.demo.sales.salesOrder;

import org.springframework.data.mongodb.repository.MongoRepository;




public interface SalesOrderRepository extends MongoRepository<SalesOrderModel, String> {

}
