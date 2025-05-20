package com.Biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idRole;

    @NotNull
    @Column(name = "role_name")
    private String name;

    public Long getIdRole() { return idRole; }
    public void setIdRole(Long idRole) { this.idRole = idRole; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public enum Values {
        ADMIN(1L),
        BASIC(2L);

        Long roleId;

        Values(Long roleId) { this.roleId = roleId; }
        public Long getRoleId() { return roleId; }
    }
}