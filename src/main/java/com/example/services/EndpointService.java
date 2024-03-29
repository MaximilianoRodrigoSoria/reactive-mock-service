package com.example.services;

import com.example.models.DTOs.EndpointDTO;
import com.example.models.documents.Endpoint;
import com.example.models.repositories.EndpointRectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EndpointService {

    private EndpointRectiveRepository repository;

    @Autowired
    public EndpointService(EndpointRectiveRepository repository){
        this.repository = repository;
    }

    public Mono<EndpointDTO> save(EndpointDTO endpointDTO){
        return Mono.just(endpointDTO)
                .map(EndpointDTO::toDocument)
                .flatMap(repository::save)
                .map(Endpoint::toDTO);

    }

    public Flux<EndpointDTO> findAll(){
         return  repository.findAll()
                 .map(Endpoint::toDTO);

    }

}
