package com.mm_cinema.employee.view_model.employee;

import com.mm_cinema.employee.model.Employee;
import com.mm_cinema.employee.model.Role;
import com.mm_cinema.employee.model.enumeration.EmployeeStatus;
import com.mm_cinema.employee.model.enumeration.Gender;

import java.time.LocalDateTime;

public record UpdateEmployeeVm(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        EmployeeStatus status,
        Gender gender,
        String idNumber,
        String personalEmail,
        String avatarUrl,
        LocalDateTime birthDay
) {
    public Employee toEmployee() {
        return Employee.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .status(status)
                .gender(gender)
                .idNumber(idNumber)
                .personalEmail(personalEmail)
                .avatarUrl(avatarUrl)
                .birthDay(birthDay)
                .build();
    }
}