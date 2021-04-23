package com.example.pizza.repository;

import com.example.pizza.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findById(long id);
}
