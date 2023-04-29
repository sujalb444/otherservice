package com.mopa.pacc.pmis.promotion;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.*;

import com.mopa.pacc.pmis.common.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="t_promotioninfo")
public class Promotion extends BaseEntity implements Serializable {
    
   private static final long serialVersionUID=1L;

    @Column(name="prom_dt")
    private Instant promotionDate;
    @Column(name="rank_nm")
    private String rankName;
    @Column(name="pay_scale")
    private String payScale;
    @Column(name="nat_prom")
    private String natureOfPromotion;
    @Column(name="act_prom_dt")
    private Instant actualPromotionDate;
    @Column(name="remark")
    private String remarks;
    
}
