package com.example.rest_demo.database.repository;

import com.example.rest_demo.database.objects.Car;
import com.example.rest_demo.database.objects.User;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepo extends MyRepo<Car, Long> {

}
