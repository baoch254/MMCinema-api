package com.mm_cinema.common_library.model;

import com.mm_cinema.common_library.model.listener.CustomAuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.ZonedDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(CustomAuditingEntityListener.class)
public class AbstractAuditEntity {

    @Column(name = "created_on", nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdOn;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "last_modified_on")
    @UpdateTimestamp
    private ZonedDateTime lastModifiedOn;

    @Column(name = "last_modified_by")
    @LastModifiedBy
    private String lastModifiedBy;
}
