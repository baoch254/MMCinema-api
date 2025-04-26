package com.mm_cinema.cinema.repository;

import com.mm_cinema.cinema.model.VersionCaption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionCaptionRepository extends JpaRepository<VersionCaption, Long> {
}
