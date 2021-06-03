package com.example.controllers;

import com.example.models.DTOs.EndpointDTO;
import com.example.models.DTOs.MockDTO;
import com.example.services.MockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/api/v1/")
@Slf4j
public class MockController {


    private MockService service;

    @Autowired
    public MockController(MockService service){
        this.service = service;
    }


    @PostMapping("/mock")
    public Mono<ResponseEntity<MockDTO>> save(@RequestBody MockDTO mockDTO){
        return this.service.save(mockDTO)
                .map(r -> new ResponseEntity<MockDTO>(r, HttpStatus.OK))
                .doOnNext(r-> log.info(r.getBody().toString()))
                .doOnError(e -> new ResponseEntity<MockDTO>(mockDTO, HttpStatus.BAD_REQUEST));

    }

     @GetMapping("/mock")
     public Flux<ResponseEntity<MockDTO>> findAll()
        {
            return this.service.findAll()
                    .map(r -> new ResponseEntity<MockDTO>(r, HttpStatus.OK))
                    .doOnNext(r-> log.info(r.getBody().toString()))
                    .doOnError(e -> new ResponseEntity<MockDTO>(new MockDTO(), HttpStatus.BAD_REQUEST));
        }
}
