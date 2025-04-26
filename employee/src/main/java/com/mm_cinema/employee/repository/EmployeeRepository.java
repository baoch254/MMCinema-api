package com.mm_cinema.employee.repository;

import com.mm_cinema.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);

    List<Employee> findByIdIn(List<Long> userIds);

    Boolean existsByEmail(String email);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.status = ?2 WHERE e.id = ?1")
    void updateStatusById(Long id, int status);
}
