package com.myprojects.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

import static com.myprojects.infrastructure.persistence.constant.AuditConstant.*;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public abstract class Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Integer id;

    @Column(name = IS_ACTIVE)
    private Boolean isActive;

    @Column(name = CREATED_DATE)
    private LocalDateTime createdDate;

    @Column(name = UPDATED_DATE)
    private LocalDateTime updatedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = updatedDate = LocalDateTime.now();
        isActive = true;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }

}
