package com.example.models.repositories;

import com.example.models.documents.Mock;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MockReactiveRepository extends ReactiveMongoRepository<Mock, String> {



}
