package com.Biblioteca.dto;

public class ListarLivroComIdDTO {
    private long id;
    private String titulo;
    private String descricao;
    private String criador;
    private String disponivel;

    public ListarLivroComIdDTO(long id, String titulo, String descricao, String criador, String disponivel) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.criador = criador;
        this.disponivel = disponivel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }
}
