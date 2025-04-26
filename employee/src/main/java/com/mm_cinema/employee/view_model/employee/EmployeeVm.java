package com.mm_cinema.employee.view_model.employee;

import com.mm_cinema.employee.model.Employee;
import com.mm_cinema.employee.model.enumeration.EmployeeStatus;
import com.mm_cinema.employee.model.enumeration.Gender;

import java.time.LocalDateTime;

public record EmployeeVm(
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
        LocalDateTime birthDay,
        LocalDateTime createdDate
) {
    public static EmployeeVm fromModel(Employee employee) {
        return new EmployeeVm(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getStatus(),
                employee.getGender(),
                employee.getIdNumber(),
                employee.getPersonalEmail(),
                employee.getAvatarUrl(),
                employee.getBirthDay(),
                employee.getCreatedDate());
    }
}
