package com.Biblioteca.repository;

import com.Biblioteca.model.Historico;
import com.Biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
    List<Historico> findAllByUsuario(Usuario usuario);
}
