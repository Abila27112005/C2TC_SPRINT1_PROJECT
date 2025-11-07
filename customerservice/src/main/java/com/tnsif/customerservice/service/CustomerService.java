package com.tnsif.customerservice.service;

import java.util.List;
import com.tnsif.customerservice.entity.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    Customer updateCustomer(int id, Customer customer);
    void deleteCustomer(int id);
}
