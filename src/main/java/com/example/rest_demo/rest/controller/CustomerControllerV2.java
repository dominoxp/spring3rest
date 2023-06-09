package com.example.rest_demo.rest.controller;

import com.example.rest_demo.rest.dto.CustomerV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customerV2")
public class CustomerControllerV2 {


    /**
     * Get All CustomerV2 by id
     * @param id test id
     * @return customer
     */
    @GetMapping("blub")
    public Mono<CustomerV2> getCustomerById(String id) {
        return Mono.just(new CustomerV2(id, "hallo", null));
    }
}
