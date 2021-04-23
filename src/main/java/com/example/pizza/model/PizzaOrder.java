package com.example.pizza.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PizzaOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @CreationTimestamp
    private Date created;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "pizzaorder_id"),
            inverseJoinColumns = @JoinColumn(name = "pizzamenuitems_id")
    )
    private Set<PizzaMenuItem> pizzaMenuItems = new HashSet<>();

    protected PizzaOrder() {
    }

    public PizzaOrder(Employee employee, Customer customer) {
        this.employee = employee;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Set<PizzaMenuItem> getProducts() {
        return pizzaMenuItems;
    }

    public void setProducts(Set<PizzaMenuItem> products) {
        this.pizzaMenuItems = products;
    }


    @Override
    public String toString() {
        return "PizzaOrder{" +
                "id=" + id +
                ", employee=" + employee +
                ", customer=" + customer +
                ", created=" + created +
                ", products=" + pizzaMenuItems +
                '}';
    }
}
