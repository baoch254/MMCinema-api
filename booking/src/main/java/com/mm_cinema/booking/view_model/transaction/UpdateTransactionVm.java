package com.mm_cinema.booking.view_model.transaction;


import com.mm_cinema.booking.model.Transaction;
import com.mm_cinema.booking.model.enumeration.TransactionStatus;

public record UpdateTransactionVm(
        Long id,
        Long bookingId,
        String transactionId,
        Integer amount,
        String partnerName,
        String paymentMethod,
        TransactionStatus status,
        String message
) {
    public Transaction toEntity() {
        Transaction transaction = new Transaction();
        transaction.setId(id);
        transaction.setTransactionId(transactionId);
        transaction.setAmount(amount);
        transaction.setPartnerName(partnerName);
        transaction.setPaymentMethod(paymentMethod);
        transaction.setStatus(status);
        transaction.setMessage(message);
        return transaction;
    }
}