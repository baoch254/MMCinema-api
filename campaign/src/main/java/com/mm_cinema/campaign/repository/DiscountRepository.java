package com.mm_cinema.campaign.repository;

import com.mm_cinema.campaign.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Discount d SET d.status = ?2 WHERE d.id = ?1")
    void updateStatusById(Long id, int status);
}
