package com.mm_cinema.employee.service.impl;

import com.mm_cinema.common_library.exception.NotFoundException;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.model.Pagination;
import com.mm_cinema.employee.model.Employee;
import com.mm_cinema.employee.repository.EmployeeRepository;
import com.mm_cinema.employee.service.IEmployeeService;
import com.mm_cinema.employee.utils.Constants;
import com.mm_cinema.employee.view_model.employee.EmployeeVm;
import com.mm_cinema.employee.view_model.employee.UpdateEmployeeVm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeVm getEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            throw new IllegalStateException(Constants.ErrorCode.EMPLOYEE_NOT_FOUND);
        }
        return EmployeeVm.fromModel(employee);
    }

    @Override
    public EmployeeVm getEmployeeDetail(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(new Employee());
        return EmployeeVm.fromModel(employee);
    }

    @Override
    public void updateEmployee(UpdateEmployeeVm employeeVm) {

        Employee employee = getEmployeeById(employeeVm.id());
        // Update logic validate and mapping employeeVm Update vs Existed ...

        // Basic mapping
        employee.setFirstName(employeeVm.firstName());
        employee.setLastName(employeeVm.lastName());
        employee.setGender(employeeVm.gender());
        employee.setStatus(employeeVm.status());
        employee.setIdNumber(employeeVm.idNumber());
        employee.setEmail(employeeVm.email());
        employee.setPersonalEmail(employeeVm.personalEmail());
        employee.setPhone(employeeVm.phone());
        employee.setBirthDay(employeeVm.birthDay());
        employee.setAvatarUrl(employeeVm.avatarUrl());
        employeeRepository.save(employee);
    }


    @Override
    public CollectionsResp getAllEmployees(Pageable pageable) {
        Page<Employee> employeePage = employeeRepository.findAll(pageable);

        List<EmployeeVm> employeeVms = employeePage.getContent().stream()
                .map(EmployeeVm::fromModel)
                .collect(Collectors.toList());

        Pagination pagination = new Pagination(
                employeePage.getTotalElements(),
                employeePage.getTotalPages(),
                employeePage.getSize(),
                employeePage.getNumber() + 1
        );

        return new CollectionsResp(employeeVms, pagination);
    }

    @Override
    public void updateStatusById(Long id, int status) {
        employeeRepository.updateStatusById(id, status);
    }

    private Employee getEmployeeById(long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new NotFoundException(Constants.ErrorCode.EMPLOYEE_NOT_FOUND, employeeId));
    }

}
