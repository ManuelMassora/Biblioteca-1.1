package com.Biblioteca.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class AutenticacaoDTO {
    @Email
    private String email;
    @NotNull
    private String senha;

    public AutenticacaoDTO() {

    }

    public AutenticacaoDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
