package com.mopa.pacc.pmis.spouseinfo;

import java.time.Instant;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="spouseinfo")
public class SpouseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "spouse_nm")
    private Instant spouseName;
    @Column(name = "occup_nm")
    private String OccupName;
    @Column(name = "desig_nm")
    private String DesigName;
    @Column (name = "org_nm")
    private String OrgName;
    @Column (name = "home_nm")
    private String HomeName;
    @Column (name = "remark")
    private String remarks;
}