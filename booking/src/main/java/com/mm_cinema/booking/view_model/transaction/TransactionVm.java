package com.mm_cinema.booking.view_model.transaction;

import com.mm_cinema.booking.model.Concession;
import com.mm_cinema.booking.model.Transaction;
import com.mm_cinema.booking.model.enumeration.TransactionStatus;

import java.time.LocalDateTime;

import java.time.LocalDateTime;

public record TransactionVm(
        Long id,
        Long bookingId,
        String transactionId,
        Integer amount,
        String partnerName,
        String paymentMethod,
        TransactionStatus status,
        String message,
        LocalDateTime createdDate
) {
    public static TransactionVm fromModel(Transaction transaction) {
        return new TransactionVm(
                transaction.getId(),
                transaction.getBooking() != null ? transaction.getBooking().getId() : null,
                transaction.getTransactionId(),
                transaction.getAmount(),
                transaction.getPartnerName(),
                transaction.getPaymentMethod(),
                transaction.getStatus(),
                transaction.getMessage(),
                transaction.getCreatedDate()
        );
    }
}