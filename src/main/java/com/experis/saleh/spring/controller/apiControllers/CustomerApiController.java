package com.experis.saleh.spring.controller.apiControllers;

import com.experis.saleh.spring.models.daoModels.CustomerDao;
import com.experis.saleh.spring.data_access.CustomerRepository;
import com.experis.saleh.spring.models.daoModels.CustomerQuantityPerCountryDao;
import com.experis.saleh.spring.models.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerApiController {
    CustomerRepository customerRepository = new CustomerRepository();

    @GetMapping(value = "/api/customers")
    public ArrayList<CustomerDao> getAllCustomers(){
        ArrayList<CustomerDao> allCustomers  = customerRepository.getAllCustomers();
        return allCustomers;
    }

    @GetMapping(value = "/api/customer/quantityPerCountry")
    public ArrayList<CustomerQuantityPerCountryDao> getNumberOfCustomerPerCountry(){
        ArrayList<CustomerQuantityPerCountryDao> numberOfCustomerPerCountry   = customerRepository.getCustomerQuantityPerCountry();
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
