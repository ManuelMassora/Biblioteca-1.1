package com.Biblioteca.services;

import com.Biblioteca.dto.EmprestimoDTO;
import com.Biblioteca.dto.EmprestimoPendenteDTO;
import com.Biblioteca.dto.FazerEmprestimoDTO;
import com.Biblioteca.model.Emprestimo;
import com.Biblioteca.model.Livro;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.repository.EmprestimoRepository;
import com.Biblioteca.repository.LivroRepository;
import com.Biblioteca.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, LivroRepository livroRepository, UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public void emprestarLivro(FazerEmprestimoDTO fazerEmprestimoDTO) {
        Usuario usuario = usuarioRepository.findById(fazerEmprestimoDTO.getIdUsuario())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));
        Livro livro = livroRepository.findById(fazerEmprestimoDTO.getIdLivro())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro nao econtrado"));

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivroEmprestado(livro);
        emprestimo.setDataEmprestado(LocalDateTime.now());
        emprestimo.setFinalizado(false);
        emprestimo.setPago(false);
        emprestimo.setTotal(0.0);
        livro.setDisponivel(false);
        emprestimoRepository.save(emprestimo);
        livroRepository.save(livro);
    }

    @Transactional
    public void finalizarEmprestimo(Long id) {
        var emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID de Emprestimo nao econtardo"));

        emprestimo.setDataEntrega(LocalDateTime.now());
        emprestimo.setFinalizado(true);

        Duration duracao = Duration.between(emprestimo.getDataEmprestado(), emprestimo.getDataEntrega());
        long minutos = duracao.toMinutes();
        float hora = minutos / 60f;
        double valorPorHora = 2.5;
        double total = hora * valorPorHora;
        emprestimo.setTotal(total);

        Livro livro = emprestimo.getLivroEmprestado();
        livro.setDisponivel(true);
        emprestimoRepository.save(emprestimo);
        livroRepository.save(livro);
    }

    public List<EmprestimoDTO> listarEmprestimos() {
        return emprestimoRepository.findAll().stream()
                .map(e -> new EmprestimoDTO(
                        e.getId(),
                        e.getUsuario().getNome(),
                        e.getLivroEmprestado().getTitulo(),
                        e.getDataEmprestado().toLocalDate(),
                        e.getDataEntrega() != null
                                ? e.getDataEntrega().toLocalDate()
                                : null,
                        e.isFinalizado(),
                        e.isPago(),
                        e.getTotal()
                ))
                .toList();
    }


    public List<EmprestimoPendenteDTO> listarEmprestimosPendentes(long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do usuario nao econtrado"));
        List<Emprestimo> emprestimos = emprestimoRepository.findAllByUsuarioAndFinalizadoFalse(usuario);
        emprestimos.sort(Comparator.comparing(h -> h.getId(), Comparator.reverseOrder()));
        return emprestimos.stream()
                .map(e -> new EmprestimoPendenteDTO(
                        e.getLivroEmprestado().getTitulo(),
                        e.getDataEmprestado()
                )).toList();
    }

    public Optional<Emprestimo> buscarEmprestimo(Long id) {
        return emprestimoRepository.findById(id);
    }
}