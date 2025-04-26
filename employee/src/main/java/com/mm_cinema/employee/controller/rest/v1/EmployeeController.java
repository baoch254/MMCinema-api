package com.mm_cinema.employee.controller.rest.v1;

import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import com.mm_cinema.employee.service.impl.EmployeeService;
import com.mm_cinema.employee.view_model.employee.EmployeeVm;
import com.mm_cinema.employee.view_model.employee.UpdateEmployeeVm;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeDetail(@PathVariable Long id) {
        EmployeeVm employee = employeeService.getEmployeeDetail(id);
        return ResponseUtil.successWithData(employee, "Employee retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody UpdateEmployeeVm employeeVm){
        employeeService.updateEmployee(employeeVm);
        return ResponseUtil.success("Employee updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllEmployees(Pageable pageable){
        CollectionsResp employees = employeeService.getAllEmployees(pageable);
        return ResponseUtil.successWithCollection(employees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStatusEmployee(@PathVariable Long id,@RequestParam int status){
        employeeService.updateStatusById(id,status);
        return ResponseUtil.success("Status employee updated successfully");
    }
}
