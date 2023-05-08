package com.example.rest_demo.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface MyRepo<T, U> extends PagingAndSortingRepository<T, U>, CrudRepository<T, U> {

}
