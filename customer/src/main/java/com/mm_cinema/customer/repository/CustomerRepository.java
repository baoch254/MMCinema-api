package com.mm_cinema.customer.repository;

import com.mm_cinema.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);

    List<Customer> findByIdIn(List<Long> userIds);

    Boolean existsByEmail(String email);

    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.status = ?2 WHERE c.id = ?1")
    void updateStatusById(Long id, Boolean status);
}
