package com.jsp.Security_Example.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseClass {
    @CreationTimestamp
    LocalDateTime createdAt;
    @LastModifiedDate
    LocalDateTime updatedAt;

    @CreatedBy
    String createdBy;
    @LastModifiedBy
    String updatedBy;

}
