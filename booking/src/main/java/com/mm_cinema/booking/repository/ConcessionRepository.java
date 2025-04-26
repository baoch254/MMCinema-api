package com.mm_cinema.booking.repository;

import com.mm_cinema.booking.model.Concession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcessionRepository extends JpaRepository<Concession, Long> {
}
