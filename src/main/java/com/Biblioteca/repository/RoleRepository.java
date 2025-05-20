package com.Biblioteca.repository;

import com.Biblioteca.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String nome);
}