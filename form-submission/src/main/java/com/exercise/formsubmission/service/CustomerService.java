package com.exercise.formsubmission.service;

import java.util.List;

import com.exercise.formsubmission.model.Customer;
import com.exercise.formsubmission.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {

        customerRepository.save(customer);
    }

    public void updateCustomer( Customer customer) {

        customerRepository.save(customer);

    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}