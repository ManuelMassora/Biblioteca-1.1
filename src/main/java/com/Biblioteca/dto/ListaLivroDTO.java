package com.Biblioteca.dto;

public class ListaLivroDTO {
    private String titulo;
    private String descricao;
    private String criador;
    private String disponivel;
    private String imagemUrl;

    public ListaLivroDTO(String titulo, String descricao, String criador, String disponivel, String imagemUrl) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.criador = criador;
        this.disponivel = disponivel;
        this.imagemUrl = imagemUrl;
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

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}
