package com.mm_cinema.customer.model;

import com.mm_cinema.customer.model.enumeration.CustomerStatus;
import com.mm_cinema.customer.model.enumeration.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "google_id", length = 255)
    private String googleId;

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

    @Column(name = "status")
    private CustomerStatus status;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "barcode", length = 255)
    private String barcode;

    @Column(name = "birth_day")
    private LocalDateTime birthDay;

    @Column(name = "avatar_url", length = 255)
    private String avatarUrl;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
