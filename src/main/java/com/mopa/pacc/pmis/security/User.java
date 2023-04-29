package com.mopa.pacc.pmis.security;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "s_user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private boolean enabled;
    // 1 user may be belong to multiple roles
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "s_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private List<Role> roles;

}
