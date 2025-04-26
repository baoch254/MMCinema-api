package com.mm_cinema.cinema.repository;

import com.mm_cinema.cinema.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Seat s SET s.status = ?2 WHERE s.id = ?1")
    void updateStatusById(Long id, int status);
}
