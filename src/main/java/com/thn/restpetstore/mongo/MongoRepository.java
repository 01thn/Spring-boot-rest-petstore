package com.thn.restpetstore.mongo;

import com.thn.restpetstore.entity.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepository extends org.springframework.data.mongodb.repository.MongoRepository<Car, Long> {
}
