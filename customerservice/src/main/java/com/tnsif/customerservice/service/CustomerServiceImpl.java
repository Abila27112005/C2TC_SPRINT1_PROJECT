package com.tnsif.customerservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tnsif.customerservice.entity.Customer;
import com.tnsif.customerservice.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer addCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Customer updateCustomer(int id, Customer customer) {
        Customer existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(customer.getName());
            existing.setEmail(customer.getEmail());
            existing.setPhone(customer.getPhone());
            existing.setAddress(customer.getAddress());
            existing.setCity(customer.getCity());
            existing.setMembershipType(customer.getMembershipType());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteCustomer(int id) {
        repository.deleteById(id);
    }
}
