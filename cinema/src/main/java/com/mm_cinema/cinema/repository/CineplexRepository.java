package com.mm_cinema.cinema.repository;

import com.mm_cinema.cinema.model.Cineplex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CineplexRepository extends JpaRepository<Cineplex, Long> {
}
