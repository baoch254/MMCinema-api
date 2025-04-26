package com.mm_cinema.booking.repository;

import com.mm_cinema.booking.model.BookingActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookingActivityLogRepository extends JpaRepository<BookingActivityLog, Long> {
}
