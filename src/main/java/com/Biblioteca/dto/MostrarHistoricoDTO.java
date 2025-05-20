package com.Biblioteca.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class MostrarHistoricoDTO {
    private String livro;
    private double valor;
    private LocalDateTime horaPaga;

    public MostrarHistoricoDTO(String livro, double valor, LocalDateTime horaPaga) {
        this.livro = livro;
        this.valor = valor;
        this.horaPaga = horaPaga;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getHoraPaga() {
        return horaPaga;
    }

    public void setHoraPaga(LocalDateTime horaPaga) {
        this.horaPaga = horaPaga;
    }
}