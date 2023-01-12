package com.springrest.rest;

import com.springrest.entity.Customer;
import com.springrest.exception.CustomerNotFoundException;
import com.springrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getStudents() {
        return customerService.getCustomers();
    }

    @PostMapping("/postcustomer")
    public Customer saveCustomer(@RequestBody Customer theCustomer) {
        theCustomer.setId(0);
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @PutMapping("/putcustomer")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @DeleteMapping("/deletecustomer/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if(customer == null)
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        customerService.deleteCustomer(customerId);
        return "Deleted customer id - " + customerId;
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        if(customer == null)
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        return customer;
    }
}
