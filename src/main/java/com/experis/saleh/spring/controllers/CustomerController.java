package com.experis.saleh.spring.controllers;

import com.experis.saleh.spring.data_access.CustomerRepository;
import com.experis.saleh.spring.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {
    CustomerRepository customerRepository = new CustomerRepository();

    @GetMapping("/")
    public String index(){
        return "My first controller!";
    }
    @RequestMapping(value= "/greet", method = RequestMethod.GET)
    public String greet(@RequestParam("name") String name){
        return "Howdy " + name;
    }

    @RequestMapping(value = "/{firstName}/{lastName}", method = RequestMethod.GET)
    public String getCustomer(@PathVariable String firstName,@PathVariable String lastName){
        return firstName + " " + lastName;
    }

    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

}
