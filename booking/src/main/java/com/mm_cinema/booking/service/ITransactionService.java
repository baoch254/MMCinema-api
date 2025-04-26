package com.mm_cinema.booking.service;

import com.mm_cinema.booking.view_model.transaction.TransactionVm;
import com.mm_cinema.booking.view_model.transaction.UpdateTransactionVm;
import com.mm_cinema.common_library.model.CollectionsResp;
import org.springframework.data.domain.Pageable;

public interface ITransactionService {
    TransactionVm getTransactionDetail(Long id);

    void updateTransaction(UpdateTransactionVm transactionVm);

    CollectionsResp getAllTransactions(Pageable pageable);

    void updateStatusById(Long id, int status);
}