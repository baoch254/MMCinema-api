package com.mm_cinema.employee.model;

import com.mm_cinema.common_library.model.AbstractAuditEntity;
import com.mm_cinema.employee.model.enumeration.EmployeeStatus;
import com.mm_cinema.employee.model.enumeration.EmployeeStatusConverter;
import com.mm_cinema.employee.model.enumeration.Gender;
import com.mm_cinema.employee.model.enumeration.GenderConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 255, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 255, nullable = false)
    private String lastName;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "salt", length = 255)
    private String salt;

    @Convert(converter = EmployeeStatusConverter.class)
    @Column(name = "status")
    private EmployeeStatus status;
    @Convert(converter = GenderConverter.class)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "id_number", length = 255)
    private String idNumber;

    @Column(name = "personal_email", length = 255)
    private String personalEmail;

    @Column(name = "avatar_url", length = 255)
    private String avatarUrl;

    @Column(name = "birthday")
    private LocalDateTime birthDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "start_date", nullable = false, updatable = false)
    private LocalDateTime startDate;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
        this.startDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
