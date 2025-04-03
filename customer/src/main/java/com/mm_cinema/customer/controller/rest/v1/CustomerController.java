package com.mm_cinema.customer.controller.rest.v1;

import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import com.mm_cinema.customer.service.CustomerService;
import com.mm_cinema.customer.view_model.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/barcodes/{barcode}")
    public ResponseEntity<?> getCustomerByBarcode(@PathVariable String barcode) {
        CustomerVM customer = customerService.getCustomerByBarcode(barcode);
        return ResponseUtil.successWithData(customer, "Customer retrieved successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        CustomerVM customer = customerService.getCustomerById(id);
        return ResponseUtil.successWithData(customer, "Customer retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody UpdateCustomerVm customerVm) {
        customerService.updateCustomer(customerVm);
        return ResponseUtil.success("Customer updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCustomers(Pageable pageable) {
        CollectionsResp customers = customerService.getAllCustomers(pageable);

        return ResponseUtil.successWithCollection(customers);
    }

}