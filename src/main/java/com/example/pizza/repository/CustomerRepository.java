package com.example.pizza.repository;

import com.example.pizza.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Customer findById(long id);
}
