package com.example.pizza.controller;


import com.example.pizza.model.Customer;
import com.example.pizza.model.Employee;
import com.example.pizza.model.PizzaOrder;
import com.example.pizza.repository.CustomerRepository;
import com.example.pizza.repository.EmployeeRepository;
import com.example.pizza.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/order") // This means URL's start with /demo (after
public class PizzaOrderController {

    @Autowired
    PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<PizzaOrder> getAll() {
        // This returns a JSON or XML with the users
        return pizzaOrderRepository.findAll();
    }

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewOrder(@RequestParam int employee_id, @RequestParam int customer_id) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Employee employee = employeeRepository.findById(employee_id);
        Customer customer = customerRepository.findById(customer_id);
        PizzaOrder c = new PizzaOrder(employee, customer);
        pizzaOrderRepository.save(c);
        return "Saved";
    }

}
