package com.example.models.repositories;

import com.example.models.documents.Endpoint;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EndpointRectiveRepository extends ReactiveMongoRepository<Endpoint, String>

{
}
