package com.mm_cinema.cinema.repository;

import com.mm_cinema.cinema.model.Row;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowRepository extends JpaRepository<Row, Long> {
}
