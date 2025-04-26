package com.mm_cinema.employee.repository;

import com.mm_cinema.employee.model.Permission;
import com.mm_cinema.employee.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Permission e SET e.status = ?2 WHERE e.id = ?1")
    void updateStatusById(Long id, int status);
}
