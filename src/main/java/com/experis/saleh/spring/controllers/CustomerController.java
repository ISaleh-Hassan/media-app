package com.experis.saleh.spring.controllers;

import com.experis.saleh.spring.data_access.CustomerAPI;
import com.experis.saleh.spring.data_access.CustomerRepository;
import com.experis.saleh.spring.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {
    CustomerRepository customerRepository = new CustomerRepository();

    @GetMapping(value = "/api/customers")
    public ArrayList<CustomerAPI> getAllCustomers(){
        ArrayList<CustomerAPI> allCustomers      = customerRepository.getAllCustomers();
        return allCustomers;
    }

    @RequestMapping(value = "/api/customer/add", method = RequestMethod.POST)
    public Boolean addNewCustomer(@RequestBody Customer customer){
        return customerRepository.addCustomer(customer);
    }

    @RequestMapping(value = "/api/customer/update", method = RequestMethod.PUT)
    public Boolean updateCustomer(@RequestBody Customer customer){
        return customerRepository.updateCustomer(customer);
    }
}
