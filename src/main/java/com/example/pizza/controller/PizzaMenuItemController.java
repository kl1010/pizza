package com.example.pizza.controller;


import com.example.pizza.model.PizzaMenuItem;
import com.example.pizza.repository.PizzaMenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/product") // This means URL's start with /demo (after
public class PizzaMenuItemController {


    @Autowired
    PizzaMenuItemRepository pizzaMenuItemRepository;


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<PizzaMenuItem> getAll() {
        // This returns a JSON or XML with the users
        return pizzaMenuItemRepository.findAll();
    }


}


