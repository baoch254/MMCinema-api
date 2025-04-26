package com.mm_cinema.campaign.repository;

import com.mm_cinema.campaign.model.Discount;
import com.mm_cinema.campaign.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Promotion p SET p.status = ?2 WHERE p.id = ?1")
    void updateStatusById(Long id, int status);
}
