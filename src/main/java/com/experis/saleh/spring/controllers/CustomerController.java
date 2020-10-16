package com.experis.saleh.spring.controllers;

import com.experis.saleh.spring.data_access.CustomerRepository;
import com.experis.saleh.spring.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {
    CustomerRepository customerRepository = new CustomerRepository();

    @GetMapping(value = "/api/customers")
    public ArrayList<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

//TODO: A user should not get back an email when he call this method.
    @RequestMapping(value = "/api/addcustomer", method = RequestMethod.POST)
    public Boolean addNewCustomer(@RequestBody Customer customer){
        int custId= customer.getCustomerId();
        String custFirstName        = customer.getFirstName();
        String custLastName         = customer.getLastName();
        String custCountry          = customer.getCountry();
        String custPostalCode       = customer.getPostalCode();
        String custPhon             = customer.getPhone();

        customer= new Customer(custId,custFirstName,custLastName,custCountry, custPostalCode, custPhon,customer.getEmail());
        return customerRepository.addCustomer(customer);
    }
}
