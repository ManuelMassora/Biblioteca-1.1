package com.Biblioteca.dto;


public class FazerEmprestimoDTO {
    private Long idUsuario;
    private Long idLivro;

    public FazerEmprestimoDTO(Long idUsuario, Long idLivro) {
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }
}