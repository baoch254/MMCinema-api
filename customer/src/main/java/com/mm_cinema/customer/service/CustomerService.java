package com.mm_cinema.customer.service;

import com.mm_cinema.common_library.exception.BadRequestException;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.model.Pagination;
import com.mm_cinema.customer.model.Customer;
import com.mm_cinema.customer.repository.CustomerRepository;
import com.mm_cinema.customer.utils.BarcodeUtil;
import com.mm_cinema.customer.view_model.*;
import com.mm_cinema.common_library.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService{

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerVM getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(new Customer());
        return CustomerVM.fromModel(customer);
    }

    @Override
    public CustomerVM getCustomerByBarcode(String barcode) {

        boolean is_valid = BarcodeUtil.isValidBarcodeFormat(barcode);
        if(!is_valid) {
            throw new BadRequestException("Invalid barcode");
        }

        Customer customer = customerRepository.findByBarcode(barcode);
        if (customer == null) {
            throw new NotFoundException(barcode);
        }

        return CustomerVM.fromModel(customer);
    }

    @Override
    public void updateCustomer(UpdateCustomerVm customerVm) {
        // write logic update user in here
    }

    @Override
    public CollectionsResp getAllCustomers(Pageable pageable) {
        Page<Customer> customerPage = customerRepository.findAll(pageable);

        List<CustomerVM> customerVMs = customerPage.getContent().stream()
                .map(CustomerVM::fromModel)
                .collect(Collectors.toList());

        Pagination pagination = new Pagination(
                customerPage.getTotalElements(),
                customerPage.getTotalPages(),
                customerPage.getSize(),
                customerPage.getNumber() + 1
        );

        return new CollectionsResp(customerVMs, pagination);
    }

}