package com.Biblioteca.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class AtualizarPerfil {

    @NotBlank
    private String nome;
    @NotBlank
    private String bi;

    @Min(value = 4)
    private String senha;

    public AtualizarPerfil(String nome, String bi, String senha) {
        this.nome = nome;
        this.bi = bi;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
