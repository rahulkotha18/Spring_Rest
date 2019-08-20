package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.exceptions.CustomerNotFoundException;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customers")
    public List<Customer> getCustomers()
    {
        return customerService.getCustomers();
    }
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id)
    {
        Customer theCustomer=customerService.getCustomer(id);
        if(theCustomer==null)
            throw  new CustomerNotFoundException("Customer_id not found");
        return theCustomer;
    }
    @PostMapping("/customers")
    public Customer setCustomer(@RequestBody Customer customer)
    {
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer)
    {
        customerService.saveCustomer(customer);
        return customer;
    }


    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id)
    {
        Customer customer=customerService.getCustomer(id);
        if(customer==null)
            throw new CustomerNotFoundException("id not found");
        customerService.deleteCustomer(id);
        return "deleted customer_id"+id;
    }

}
