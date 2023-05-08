package com.example.rest_demo.database.objects;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Car {

    @Id
    private Long id;

    private String manufacturer;

    private int tieres;
}
