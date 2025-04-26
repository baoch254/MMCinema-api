package com.mm_cinema.employee.service;

import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.employee.view_model.employee.EmployeeVm;
import com.mm_cinema.employee.view_model.employee.UpdateEmployeeVm;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    EmployeeVm getEmployeeDetail(Long id);
    EmployeeVm getEmployeeByEmail(String email);
    void updateEmployee(UpdateEmployeeVm customerVm);
    CollectionsResp getAllEmployees(Pageable pageable);
    void updateStatusById(Long id, int status);

}
