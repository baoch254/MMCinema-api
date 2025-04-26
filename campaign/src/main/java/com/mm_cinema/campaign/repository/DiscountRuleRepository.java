package com.mm_cinema.campaign.repository;

import com.mm_cinema.campaign.model.DiscountRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRuleRepository extends JpaRepository<DiscountRule, Long> {
}
