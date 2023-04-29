package com.mopa.pacc.pmis.foreigntraining;


import java.io.Serializable;
import java.time.Instant;


import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.mopa.pacc.pmis.common.BaseEntity;
import com.mopa.pacc.pmis.general.GeneralInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Entity class to store data about Foreign Training Information.
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "t_foreign_training_info")
@EntityListeners(AuditingEntityListener.class)
@Inheritance (strategy = InheritanceType.JOINED)
@AttributeOverride(name="id", column=@Column(name="foreign_training_id"))



public class ForeignTrainingInfo extends BaseEntity implements Serializable {
    private static final long serialVersionUID=1L;
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private long id;

    @Column(name = "f_t_title_nm")
    private String foreignTrainingTitleName;
    @Column(name = "institute_nm")
    private String instituteName;
    @Column(name = "cuntry_nm")
    private String cuntryName;
    @Column(name = "from_dt")
    private Instant fromDate;
    @Column(name = "end_dt")
    private Instant endDate;
    @Column(name = "duration")
    private String duration;
    @Column(name = "cgpa")
    private String cgpa;
    @Column(name = "position")
    private String position;
    @Column(name = "remark")
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "gov_id", nullable = false)
    GeneralInfo generalInfo;

}
