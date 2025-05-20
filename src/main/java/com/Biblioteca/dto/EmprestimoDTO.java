package com.Biblioteca.dto;

import java.time.LocalDate;

public class EmprestimoDTO {
    private long id;
    private String usuario;
    private String livro;
    private LocalDate dataEmprestado;
    private LocalDate dataEntrega;
    private boolean finalizado;
    private boolean pago;
    private Double total;


    public EmprestimoDTO(long id, String usuario, String livro, LocalDate dataEmprestado, LocalDate dataEntrega, boolean finalizado, boolean pago, Double total) {
        this.id = id;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestado = dataEmprestado;
        this.dataEntrega = dataEntrega;
        this.finalizado = finalizado;
        this.pago = pago;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public LocalDate getDataEmprestado() {
        return dataEmprestado;
    }

    public void setDataEmprestado(LocalDate dataEmprestado) {
        this.dataEmprestado = dataEmprestado;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
