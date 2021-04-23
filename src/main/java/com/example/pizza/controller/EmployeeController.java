package com.example.pizza.controller;


import com.example.pizza.model.Employee;
import com.example.pizza.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/employee") // This means URL's start with /demo (after
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Employee> getAll() {
        // This returns a JSON or XML with the users
        return employeeRepository.findAll();
    }

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewEmployee(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String address,
            @RequestParam Long tin,
            @RequestParam boolean active

    ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Employee c = new Employee(firstName, lastName, address, tin, active);
        employeeRepository.save(c);
        return "Saved";
    }

}
