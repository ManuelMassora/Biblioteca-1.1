package com.Biblioteca.repository;

import com.Biblioteca.model.Emprestimo;
import com.Biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findAllByUsuarioAndFinalizadoFalse(Usuario usuario);
}