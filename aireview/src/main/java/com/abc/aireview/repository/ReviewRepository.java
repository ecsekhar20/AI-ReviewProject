package com.abc.aireview.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abc.aireview.model.InvoiceData;

public interface ReviewRepository extends MongoRepository<InvoiceData, Integer> {

}
