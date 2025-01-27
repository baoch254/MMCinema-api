package com.mm_cinema.customer.view_model;

import com.mm_cinema.customer.model.Customer;
import com.mm_cinema.customer.model.enumeration.CustomerStatus;
import com.mm_cinema.customer.model.enumeration.Gender;

import java.time.LocalDateTime;

public record GetCustomerDetailVm(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        int status,
        int gender,
        LocalDateTime birthDay,
        String avatarUrl,
        LocalDateTime createdDate
) {
    public static GetCustomerDetailVm fromModel(Customer customer) {
        return new GetCustomerDetailVm(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getStatus().getValue(),
                customer.getGender().getValue(),
                customer.getBirthDay(),
                customer.getAvatarUrl(),
                customer.getCreatedDate());
    }
}
