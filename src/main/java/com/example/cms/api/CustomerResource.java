package com.example.cms.api;

import com.example.cms.model.Customer;
import com.example.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerResource  {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer (@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers () {
        return customerService.getCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer (@PathVariable("customerId") int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer (@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId,customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer (@PathVariable("customerId") int customerId) {
        customerService.deleteCustomer(customerId);
    }

    @DeleteMapping
    public void deleteAllCustomer () {
        customerService.deleteCustomer();
    }


}
