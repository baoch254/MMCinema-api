package com.mm_cinema.customer.controller;

import com.mm_cinema.customer.model.Customer;
import com.mm_cinema.customer.service.CustomerService;
import com.mm_cinema.customer.view_model.GetCustomerDetailVm;
import com.mm_cinema.customer.view_model.UpdateCustomerVm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PutMapping("")
    public ResponseEntity<Void> updateCustomer(@Valid @RequestBody UpdateCustomerVm customerVm) {
//        customerService.updateCustomer(customerVm);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCustomerDetailVm> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(GetCustomerDetailVm.fromModel(customer));
    }
}
