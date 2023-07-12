package com.example.cms.service;

import com.example.cms.dao.CustomerDAO;
import com.example.cms.exception.CustomerNotFoundException;
import com.example.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
    /*private int customerCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();*/

    public Customer addCustomer (Customer customer) {
        /*customer.setCustomerId(customerCount);
        customerList.add(customer);
        customerCount++;
        return customer;*/

        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers () {
        /*return customerList;*/
        return customerDAO.findAll();
    }

    public Customer getCustomer (int customerId) {
        /*return customerList.stream().filter(c -> c.getCustomerId() == customerId).findFirst().get();*/

        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if (optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Customer record is not available...");
        }
        return optionalCustomer.get();
    }

    public Customer updateCustomer (int customerId, Customer customer) {
        /*customerList.stream().forEach(c -> {
                    if (c.getCustomerId() == customerId) {
                        c.setFirstName(customer.getFirstName());
                        c.setLastName(customer.getLastName());
                        c.setEmail(customer.getEmail());
                    }
                });
        return customerList.stream().filter(c -> c.getCustomerId() == customerId).findFirst().get();*/

        customer.setCustomerId(customerId);

        return customerDAO.save(customer);
    }

    public void deleteCustomer (int customerId) {
        /*customerList.stream().forEach(c -> {
            if(c.getCustomerId() == customerId){
                customerList.remove(c);
            }
        });*/

        customerDAO.deleteById(customerId);
    }

    public void deleteCustomer () {
        customerDAO.deleteAll();
    }
}
