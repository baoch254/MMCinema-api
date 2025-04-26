package com.mm_cinema.booking.controller.rest.v1;

import com.mm_cinema.booking.service.impl.TransactionService;
import com.mm_cinema.booking.view_model.transaction.TransactionVm;
import com.mm_cinema.booking.view_model.transaction.UpdateTransactionVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.utils.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransactionDetail(@PathVariable Long id) {
        TransactionVm transaction = transactionService.getTransactionDetail(id);
        return ResponseUtil.successWithData(transaction, "Transaction retrieved successfully");
    }

    @PutMapping("")
    public ResponseEntity<?> updateTransaction(@Valid @RequestBody UpdateTransactionVm transactionVm) {
        transactionService.updateTransaction(transactionVm);
        return ResponseUtil.success("Transaction updated successfully");
    }

    @GetMapping("")
    public ResponseEntity<?> getAllTransactions(Pageable pageable) {
        CollectionsResp transactions = transactionService.getAllTransactions(pageable);
        return ResponseUtil.successWithCollection(transactions);
    }
}