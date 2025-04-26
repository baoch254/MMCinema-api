package com.mm_cinema.booking.repository;

import com.mm_cinema.booking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Transaction t SET t.status = ?2 WHERE t.id = ?1")
    void updateStatusById(Long id, int status);
}
