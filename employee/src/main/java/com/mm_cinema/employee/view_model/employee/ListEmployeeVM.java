package com.mm_cinema.employee.view_model.employee;

import com.mm_cinema.employee.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

public record ListEmployeeVM(List<EmployeeVm> employees) {

    public static ListEmployeeVM fromListEmployeesEntity(List<Employee> employeeEntities){
        List<EmployeeVm> employeeVms = employeeEntities.stream()
                .map(EmployeeVm::fromModel)
                .collect(Collectors.toList());
        return new ListEmployeeVM(employeeVms);
    }
}
