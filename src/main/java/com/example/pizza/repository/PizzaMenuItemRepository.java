package com.example.pizza.repository;

import com.example.pizza.model.PizzaMenuItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PizzaMenuItemRepository extends PagingAndSortingRepository<PizzaMenuItem, Long> {
    PizzaMenuItem findById(long id);
}
