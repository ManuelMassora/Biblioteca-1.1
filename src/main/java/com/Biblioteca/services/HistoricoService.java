package com.Biblioteca.services;

import com.Biblioteca.dto.MostrarHistoricoDTO;
import com.Biblioteca.model.Historico;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.repository.HistoricoRepository;
import com.Biblioteca.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;

@Service
public class HistoricoService {

    private final HistoricoRepository historicoRepository;
    private final UsuarioRepository usuarioRepository;

    public HistoricoService(HistoricoRepository historicoRepository, UsuarioRepository usuarioRepository) {
        this.historicoRepository = historicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<MostrarHistoricoDTO> MostrarHistorico (long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do usuario nao econtrado"));
        List<Historico> historico = historicoRepository.findAllByUsuario(usuario);
        historico.sort(Comparator.comparing(h -> h.getPagamento().getHora(), Comparator.reverseOrder()));
        return historico.stream().map(h -> new MostrarHistoricoDTO(
                h.getPagamento().getEmprestimo().getLivroEmprestado().getTitulo(),
                h.getPagamento().getValoPagamento(),
                h.getPagamento().getHora()
        )).toList();
    }
}