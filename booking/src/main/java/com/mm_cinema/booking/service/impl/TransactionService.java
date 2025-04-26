package com.mm_cinema.booking.service.impl;

import com.mm_cinema.booking.model.Transaction;
import com.mm_cinema.booking.repository.TransactionRepository;
import com.mm_cinema.booking.service.ITransactionService;
import com.mm_cinema.booking.utils.Constants;
import com.mm_cinema.booking.view_model.transaction.TransactionVm;
import com.mm_cinema.booking.view_model.transaction.UpdateTransactionVm;
import com.mm_cinema.common_library.exception.NotFoundException;
import com.mm_cinema.common_library.model.CollectionsResp;
import com.mm_cinema.common_library.model.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionService implements ITransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionVm getTransactionDetail(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.TRANSACTION_NOT_FOUND, id));
        return TransactionVm.fromModel(transaction);
    }

    @Override
    public void updateTransaction(UpdateTransactionVm updateConcessionVm) {
        Transaction transaction = transactionRepository.findById(updateConcessionVm.id())
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.TRANSACTION_NOT_FOUND, updateConcessionVm.id()));
        // Update fields here and save
        transactionRepository.save(transaction);
    }

    @Override
    public CollectionsResp getAllTransactions(Pageable pageable) {
        Page<Transaction> transactionPage = transactionRepository.findAll(pageable);
        List<TransactionVm> transactionVms = transactionPage.getContent().stream()
                .map(TransactionVm::fromModel)
                .collect(Collectors.toList());

        Pagination pagination = new Pagination(
                transactionPage.getTotalElements(),
                transactionPage.getTotalPages(),
                transactionPage.getSize(),
                transactionPage.getNumber() + 1
        );

        return new CollectionsResp(transactionVms, pagination);
    }

    @Override
    public void updateStatusById(Long id, int status) {
        transactionRepository.updateStatusById(id, status);
    }
}