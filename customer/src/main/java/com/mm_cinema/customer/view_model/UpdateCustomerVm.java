package com.mm_cinema.customer.view_model;

import com.mm_cinema.customer.model.Customer;
import com.mm_cinema.customer.model.enumeration.CustomerStatus;
import com.mm_cinema.customer.model.enumeration.Gender;

import java.time.LocalDateTime;

public record UpdateCustomerVm(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        CustomerStatus status,
        Gender gender,
        LocalDateTime birthDay,
        String avatarUrl
) {
    public Customer toCustomer() {
        return Customer.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .status(status)
                .gender(gender)
                .birthDay(birthDay)
                .avatarUrl(avatarUrl)
                .build();
    }
}