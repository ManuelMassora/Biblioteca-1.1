package com.Biblioteca.dto;

public class EfetuarPagamentoDTO {
    private Long idEmprestimo;

    public EfetuarPagamentoDTO(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }
}