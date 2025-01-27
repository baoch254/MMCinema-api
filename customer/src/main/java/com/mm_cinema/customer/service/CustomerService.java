package com.mm_cinema.customer.service;

import com.mm_cinema.customer.model.Customer;
import com.mm_cinema.customer.model.enumeration.CustomerStatus;
import com.mm_cinema.customer.repository.CustomerRepository;
import com.mm_cinema.customer.view_model.UpdateCustomerVm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new IllegalStateException("Customer not found");
        }

        return customer;
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.
                findById(id).
                orElseThrow(() -> new IllegalStateException("Customer not found"));
    }

//    public void updateCustomer(UpdateCustomerVm customer) {
//        Customer customerToUpdate = customerRepository.
//                findById(customer.id()).
//                orElseThrow(() -> new IllegalStateException("Customer not found"));
//
//        if (customerToUpdate.getStatus().equals(CustomerStatus.INACTIVE)) {
//            throw new IllegalStateException("Customer is inactive");
//        }
//
//        customerRepository.save(customer);
//    }

    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.
                findById(id).
                orElseThrow(() -> new IllegalStateException("Customer not found"));

        if (customer.getStatus().equals(CustomerStatus.INACTIVE)) {
            throw new IllegalStateException("Customer is inactive");
        }

        customerRepository.deleteById(id);
    }

}
