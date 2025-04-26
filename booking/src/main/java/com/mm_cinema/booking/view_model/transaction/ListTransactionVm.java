package com.mm_cinema.booking.view_model.transaction;

import com.mm_cinema.booking.model.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public record ListTransactionVm(List<TransactionVm> transactions) {
    public static ListTransactionVm fromListEntity(List<Transaction> transactions) {
        List<TransactionVm> vmList = transactions.stream()
                .map(TransactionVm::fromModel)
                .collect(Collectors.toList());
        return new ListTransactionVm(vmList);
    }
}