package com.example.controllers;

import com.example.models.DTOs.EndpointDTO;
import com.example.models.documents.Endpoint;
import com.example.services.EndpointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/api/v1")
@Slf4j
public class EndpointController {


    private EndpointService service;

    @Autowired
    public EndpointController(EndpointService service){
        this.service = service;
    }


    @PostMapping("/endpoint")
    public Mono<ResponseEntity<EndpointDTO>> save(@RequestBody EndpointDTO endpointDTO){
        return this.service.save(endpointDTO)
                    .map(r -> new ResponseEntity<EndpointDTO>(r, HttpStatus.OK))
                    .doOnNext(r-> log.info(r.getBody().toString()))
                    .doOnError(e -> new ResponseEntity<EndpointDTO>(endpointDTO, HttpStatus.BAD_REQUEST));

    }

}
