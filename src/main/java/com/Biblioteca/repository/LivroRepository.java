package com.Biblioteca.repository;

import com.Biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    Optional<Livro> findByTitulo(String titulo);
    Livro findByCriador(String criador);
    List<Livro> findByTituloContainingIgnoreCase(String titulo);
    List<Livro> findByDisponivelTrue();
}
