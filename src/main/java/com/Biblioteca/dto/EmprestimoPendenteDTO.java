package com.Biblioteca.dto;

import java.time.LocalDateTime;

public class EmprestimoPendenteDTO {
    private String livro;
    private LocalDateTime dataEmprestado;

    public EmprestimoPendenteDTO(String livro, LocalDateTime dataEmprestado) {
        this.livro = livro;
        this.dataEmprestado = dataEmprestado;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public LocalDateTime getDataEmprestado() {
        return dataEmprestado;
    }

    public void setDataEmprestado(LocalDateTime dataEmprestado) {
        this.dataEmprestado = dataEmprestado;
    }
}
