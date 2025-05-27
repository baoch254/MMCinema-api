package com.mm_cinema.campaign.repository;

import com.mm_cinema.campaign.model.DiscountRuleCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRuleConditionRepository  extends JpaRepository<DiscountRuleCondition,Long>{
}
