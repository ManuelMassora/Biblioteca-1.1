package com.Biblioteca.services;

import com.Biblioteca.dto.AtualizarUsuarioDTO;
import com.Biblioteca.dto.ListarUsuariosDTO;
import com.Biblioteca.model.Role;
import com.Biblioteca.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GestaoDeUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public GestaoDeUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<ListarUsuariosDTO> listarUsuarios () {
        var list = usuarioRepository.findAll();
        return list.stream()
                .map(user -> new ListarUsuariosDTO(
                        user.getId(),
                        user.getNome(),
                        user.getEmail(),
                        user.getBi(),
                        user.getDataCriacao(),
                        user.getRoles().stream()
                                .map(Role::getName)
                                .collect(Collectors.joining(", "))
                )).toList();
    }

    public void apagarUsuario(long id) {
        var usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));

        usuarioRepository.delete(usuario);
    }

    @Transactional
    public void atualizarUsuario(Long id, AtualizarUsuarioDTO atualizarUsuarioDTO) {
        var usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));

        if (atualizarUsuarioDTO.getBi() != null &&
                usuarioRepository.findByBi(atualizarUsuarioDTO.getBi()).isPresent() &&
                !usuario.getBi().equals(atualizarUsuarioDTO.getBi())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "O BI '" + atualizarUsuarioDTO.getBi() + "' já nao cadastrado!");
        }

        if (atualizarUsuarioDTO.getNome() != null) {
            usuario.setNome(atualizarUsuarioDTO.getNome());
        }
        if (atualizarUsuarioDTO.getEmail() != null) {
            usuario.setEmail(atualizarUsuarioDTO.getEmail());
        }
        if (atualizarUsuarioDTO.getBi() != null) {
            usuario.setBi(atualizarUsuarioDTO.getBi());
        }
        if (atualizarUsuarioDTO.getSenha() != null) {
            usuario.setSenha(atualizarUsuarioDTO.getSenha());
        }

        usuarioRepository.save(usuario);
    }
}
