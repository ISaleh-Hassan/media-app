package com.experis.saleh.spring.viewController;
import com.experis.saleh.spring.models.ApiModels.CustomerApi;
import com.experis.saleh.spring.data_access.CustomerRepository;
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
        ArrayList<CustomerApi> customers = customerRepository.getAllCustomers();
        model.addAttribute("customers", customers);

        return "customerList";
    }
}
