package com.example.rest_demo.rest.controller;

import com.example.rest_demo.rest.dto.Customer;
import com.example.rest_demo.rest.dto.TestType;
import java.util.Optional;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("customer")
public class CustomerController {

    /**
     * Get All Customer by id
     *
     * @param id test id
     * @return customer
     */
    @GetMapping("blub")
    public Customer getCustomerById(String id) {
        return new Customer(id, "hallo", Optional.of("welt"), TestType.Banana);
    }

    @PostMapping
    public void testPost(@RequestParam String data, @RequestBody String body) {
        throw new ResponseStatusException(HttpStatusCode.valueOf(418));
    }
}
