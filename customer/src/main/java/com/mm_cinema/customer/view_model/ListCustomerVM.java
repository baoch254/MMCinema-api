package com.mm_cinema.customer.view_model;

import com.mm_cinema.customer.model.Customer;

import java.util.List;
import java.util.stream.Collectors;

public record ListCustomerVM(List<CustomerVM> customers) {

    public static ListCustomerVM fromListCustomersEntity(List<Customer> customerEntities) {
        List<CustomerVM> customerVMs = customerEntities.stream()
                .map(CustomerVM::fromModel)
                .collect(Collectors.toList());
        return new ListCustomerVM(customerVMs);
    }
}
