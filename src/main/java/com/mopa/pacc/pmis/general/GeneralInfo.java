package com.mopa.pacc.pmis.general;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.mopa.pacc.pmis.common.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class to store data about Posting information. 
 */
@Getter
@Setter 
@Entity
@NoArgsConstructor
@Table(name="t_general_info")
@EntityListeners(AuditingEntityListener.class)
@Inheritance (strategy = InheritanceType.JOINED)
@AttributeOverride(name="id", column=@Column(name="general_id"))
public class GeneralInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L; 

    @Column(name = "gov_id", unique=true, nullable = false)
    private String govId;

    @Column(name = "first_name", nullable = false )
    private String firstName;

    @Column(name = "last_name", nullable = false )
    private String lastName;


    }

