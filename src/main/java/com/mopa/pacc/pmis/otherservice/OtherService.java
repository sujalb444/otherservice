package com.mopa.pacc.pmis.otherservice;


import com.mopa.pacc.pmis.common.BaseEntity;
import com.mopa.pacc.pmis.general.GeneralInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_otherservices")
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(name = "id", column = @Column(name = "otherservice_id"))
public class OtherService extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "from_date")
    private Instant fromDate;
    @Column(name = "end_date")
    private Instant  endDate;
    @Column(name = "empr_nm")
    private String employeeName;
    @Column(name = "empr_addr")
    private String employeeAddress;
    @Column(name = "serv_type")
    private String serviceType;
    @Column(name = "designation")
    private String designation;
    @Column(name = "Remarks")
    private String remarks;
 @ManyToOne
    @JoinColumn(name = "general_id", nullable = false)
    private GeneralInfo generalInfo;
}
