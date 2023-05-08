package com.example.rest_demo.rest.dto;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Optional;


public class CustomerV2 {

    private String id;
    @Schema(requiredMode = REQUIRED)
    private String firstName;

    @Schema(requiredMode = NOT_REQUIRED)
    private Optional<String> lastName;

    public CustomerV2(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = Optional.ofNullable(lastName);
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = Optional.ofNullable(lastName);
    }
}
