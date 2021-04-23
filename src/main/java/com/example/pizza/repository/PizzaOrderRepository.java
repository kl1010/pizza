package com.example.pizza.repository;

import com.example.pizza.model.PizzaOrder;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PizzaOrderRepository extends PagingAndSortingRepository<PizzaOrder, Long> {
    PizzaOrder findById(long id);

}
