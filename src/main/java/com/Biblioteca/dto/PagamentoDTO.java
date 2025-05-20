package com.Biblioteca.dto;

import com.Biblioteca.model.Emprestimo;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class PagamentoDTO {
    private Long id;
    private String usuario;
    private String livro;
    private Long idEmprestimo;
    private double valoPagamento;
    private LocalDateTime hora;

    public PagamentoDTO(Long id, String usuario, String livro, Long idEmprestimo, double valoPagamento, LocalDateTime hora) {
        this.id = id;
        this.usuario = usuario;
        this.livro = livro;
        this.idEmprestimo = idEmprestimo;
        this.valoPagamento = valoPagamento;
        this.hora = hora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public double getValoPagamento() {
        return valoPagamento;
    }

    public void setValoPagamento(double valoPagamento) {
        this.valoPagamento = valoPagamento;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }
}
