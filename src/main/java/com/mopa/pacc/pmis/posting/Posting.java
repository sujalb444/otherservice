package com.mopa.pacc.pmis.posting;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.mopa.pacc.pmis.common.BaseEntity;
import com.mopa.pacc.pmis.general.GeneralInfo;

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
@Table(name = "t_posting")
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(name = "id", column = @Column(name = "posting_id"))
public class Posting extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "designation")
    private String designation;

    @Column(name = "organization")
    private String organization;

    @Column(name = "location")
    private String location;

    @Column(name = "rank")
    private String rank;

    @ManyToOne
    @JoinColumn(name = "general_id", nullable = false)
    private GeneralInfo generalInfo;

}
