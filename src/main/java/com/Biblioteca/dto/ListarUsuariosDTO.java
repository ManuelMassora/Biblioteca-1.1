package com.Biblioteca.dto;

import java.time.LocalDate;

public class ListarUsuariosDTO {
    private long id;
    private String nome;
    private String email;
    private String bi;
    private LocalDate dataCriacao;
    private String role;

    public ListarUsuariosDTO(long id, String nome, String email, String bi, LocalDate dataCriacao, String role) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.bi = bi;
        this.dataCriacao = dataCriacao;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}