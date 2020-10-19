package com.experis.saleh.spring.viewController;
import com.experis.saleh.spring.controllers.CustomerController;
import com.experis.saleh.spring.data_access.CustomerAPI;
import com.experis.saleh.spring.data_access.CustomerRepository;
import com.experis.saleh.spring.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class CustomerViewController {
    CustomerRepository customerRepository = new CustomerRepository();

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String showAllCustomemrs(Model model){
        ArrayList<CustomerAPI> customers = customerRepository.getAllCustomers();
        model.addAttribute("customers", customers);

        return "customerList";
    }
}
