package com.Biblioteca.services;

import com.Biblioteca.dto.CadastrarLivroDTO;
import com.Biblioteca.dto.ListaLivroDTO;
import com.Biblioteca.dto.ListarLivroComIdDTO;
import com.Biblioteca.model.Livro;
import com.Biblioteca.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Transactional
    public void cadastrarLivro(CadastrarLivroDTO cadastrarLivro) {
        var titulo = livroRepository.findByTitulo(cadastrarLivro.getTitulo());
        if (titulo.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "O titulo ja existe");
        }
        Livro livro = new Livro();
        livro.setTitulo(cadastrarLivro.getTitulo());
        livro.setCriador(cadastrarLivro.getCriador());
        livro.setDescricao(cadastrarLivro.getDescricao());
        livro.setImagemUrl(cadastrarLivro.getImagemUrl());
        livro.setDisponivel(true);
        livroRepository.save(livro);
    }

    public List<ListaLivroDTO> listarLivro() {
        List<Livro> livros = livroRepository.findAll();
        livros.sort(Comparator.comparing(l -> l.getId(), Comparator.reverseOrder()));
        return livros.stream().map(livro -> new ListaLivroDTO(
                livro.getTitulo(),
                livro.getDescricao(),
                livro.getCriador(),
                livro.isDisponivel() ? "Disponível" : "Indisponível",
                livro.getImagemUrl()
        )).toList();
    }

    public List<ListarLivroComIdDTO> listarLivroComID() {
        return livroRepository.findAll()
                .stream()
                .map(livro -> new ListarLivroComIdDTO(
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getDescricao(),
                        livro.getCriador(),
                        livro.isDisponivel() ? "Disponível" : "Indisponível"
                )).toList();
    }

    public List<CadastrarLivroDTO> buscarLivro(String titulo) {
        List<Livro> livros = livroRepository.findByTituloContainingIgnoreCase(titulo);
        return livros.stream()
                .map(livro -> new CadastrarLivroDTO(
                        livro.getTitulo(),
                        livro.getCriador(),
                        livro.getDescricao(),
                        livro.getImagemUrl()
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public void removerLivro(Long id) {
        var livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de livro nao econtrado"));
        livroRepository.delete(livro);
    }

    @Transactional
    public void atualizarLivro(long id, CadastrarLivroDTO cadastrarLivroDTO) {
        var livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro nao econtrado"));

        if (cadastrarLivroDTO.getTitulo() != null) {
            livro.setTitulo(cadastrarLivroDTO.getTitulo());
        }
        if (cadastrarLivroDTO.getCriador() != null) {
            livro.setCriador(cadastrarLivroDTO.getCriador());
        }
        if (cadastrarLivroDTO.getDescricao() != null) {
            livro.setDescricao(cadastrarLivroDTO.getDescricao());
        }

        livroRepository.save(livro);
    }
}