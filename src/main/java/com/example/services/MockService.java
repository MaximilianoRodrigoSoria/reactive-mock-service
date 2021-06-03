package com.example.services;

import com.example.models.DTOs.MockDTO;
import com.example.models.documents.Mock;
import com.example.models.repositories.MockReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MockService {

    private MockReactiveRepository repository;

    @Autowired
    public MockService(MockReactiveRepository repository){
        this.repository = repository;
    }

    public Mono<MockDTO> save(MockDTO mockDTO){
        return Mono.just(mockDTO)
        .map(MockDTO::toDocument)
        .flatMap(repository::save)
        .map(Mock::toDTO);


    }

    public Flux<MockDTO> findAll()
    {
        return repository.findAll().map(Mock::toDTO);
    }


}
