package com.mm_cinema.customer.service;

import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.customer.view_model.CustomerVM;
import com.mm_cinema.customer.view_model.UpdateCustomerVm;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    CustomerVM getCustomerById(Long id);
    CustomerVM getCustomerByBarcode(String barcode);
    void updateCustomer(UpdateCustomerVm customerVm);
    CollectionsResp getAllCustomers(Pageable pageable);

}
