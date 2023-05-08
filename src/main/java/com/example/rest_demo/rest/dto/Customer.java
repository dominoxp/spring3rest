package com.example.rest_demo.rest.dto;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Optional;

public record Customer(String id, @Schema(requiredMode = REQUIRED) String firstName,
                       @Schema(requiredMode = NOT_REQUIRED) Optional<String> lastName,
                       TestType type) {

}
