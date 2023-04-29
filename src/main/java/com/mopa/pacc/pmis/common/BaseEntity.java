package com.mopa.pacc.pmis.common;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors (chain = true)
@MappedSuperclass
@EnableJpaAuditing 
@Embeddable 
public abstract class BaseEntity extends AbstractPersistable<Long>{

    @Column(nullable = true, updatable = false, name = "create_date")
    @CreatedDate
    private Instant createdDate;

    @Column(nullable = true, name = "last_update_date")
    @LastModifiedDate
    private Instant updatedDate;

    @Column(nullable = true, updatable = false, name = "create_user")
    @CreatedBy
    private Long createdBy;

    @Column(nullable = true, name = "update_user")
    @LastModifiedBy
    private Long modifiedBy;
    
    @Column(nullable = true, name = "version_no")
    @Version
    private int version;

    // Active (A) or Inactive (I) or Deleted (D)
    @Column(name = "record_status", nullable=true)
    private Long recordStatus;


    // @PrePersist 
    // public void prePersit(){

    // Long createdBy = new Long ("1");
    // this.createdBy = createdBy;  
    // // from login user
    // }

    // @PreUpdate
    // public void preUpdate() {

    //     // Last modified user 

    //     // last modified by 

    //     // get from logged in user 
    // }

    
}