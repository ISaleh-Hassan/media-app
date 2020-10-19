package com.experis.saleh.spring.apiControllers;

import com.experis.saleh.spring.models.ApiModels.CustomerApi;
import com.experis.saleh.spring.data_access.CustomerRepository;
import com.experis.saleh.spring.models.ApiModels.CustomerQuantityPerCountryApi;
import com.experis.saleh.spring.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerApiController {
    CustomerRepository customerRepository = new CustomerRepository();

    @GetMapping(value = "/api/customers")
    public ArrayList<CustomerApi> getAllCustomers(){
        ArrayList<CustomerApi> allCustomers  = customerRepository.getAllCustomers();
        return allCustomers;
    }

    @GetMapping(value = "/api/customer/quantityPerCountry")
    public ArrayList<CustomerQuantityPerCountryApi> getNumberOfCustomerPerCountry(){
        ArrayList<CustomerQuantityPerCountryApi> numberOfCustomerPerCountry   = customerRepository.getCustomerQuantityPerCountry();
        return numberOfCustomerPerCountry;
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
