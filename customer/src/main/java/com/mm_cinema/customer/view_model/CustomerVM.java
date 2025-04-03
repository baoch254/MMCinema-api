package com.mm_cinema.customer.view_model;

import com.mm_cinema.customer.model.Customer;

import java.time.LocalDateTime;

public record CustomerVM (
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
    public static CustomerVM fromModel(Customer customer) {
        return new CustomerVM(
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
