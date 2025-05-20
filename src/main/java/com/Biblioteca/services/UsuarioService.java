package com.Biblioteca.services;

import com.Biblioteca.dto.AtualizarPerfil;
import com.Biblioteca.dto.AtualizarUsuarioDTO;
import com.Biblioteca.dto.CadastrarUsuarioDTO;
import com.Biblioteca.model.Role;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.repository.RoleRepository;
import com.Biblioteca.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          RoleRepository roleRepository) {
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void cadastrarUsuario(CadastrarUsuarioDTO cadastrarUsuarioDTO) {
        var basicRole = roleRepository.findByName(Role.Values.BASIC.name());

        if (basicRole == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Role BASIC não encontrada no banco de dados.");
        }

        if(usuarioRepository.findByEmail(cadastrarUsuarioDTO.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "O Email '" + cadastrarUsuarioDTO.getEmail() + "' já está cadastrado!");
        }
        var user = new Usuario();
        user.setRoles(Collections.singleton(basicRole));
        user.setNome(cadastrarUsuarioDTO.getNome());
        user.setEmail(cadastrarUsuarioDTO.getEmail());
        user.setBi(cadastrarUsuarioDTO.getBi());
        user.setDataCriacao(LocalDate.now());
        user.setSenha(cadastrarUsuarioDTO.getSenha());
        usuarioRepository.save(user);
    }

    @Transactional
    public void cadastrarAdmin(CadastrarUsuarioDTO cadastrarUsuarioDTO) {
        var adminRole = roleRepository.findByName(Role.Values.ADMIN.name());

        if (adminRole == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Role BASIC não encontrada no banco de dados.");
        }

        if(usuarioRepository.findByEmail(cadastrarUsuarioDTO.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "O Email '" + cadastrarUsuarioDTO.getEmail() + "' já está cadastrado!");
        }
        var admin = new Usuario();

        admin.setRoles(Collections.singleton(adminRole));
        admin.setNome(cadastrarUsuarioDTO.getNome());
        admin.setEmail(cadastrarUsuarioDTO.getEmail());
        admin.setBi(cadastrarUsuarioDTO.getBi());
        admin.setDataCriacao(LocalDate.now());
        admin.setSenha(cadastrarUsuarioDTO.getSenha());
        usuarioRepository.save(admin);
    }

    @Transactional
    public void atualizarPerfil(long id, AtualizarPerfil atualizarPerfilDTO) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Usuário não encontrado.");
        }

        Usuario usuario = usuarioOpt.get();

        if (atualizarPerfilDTO.getNome() != null && !atualizarPerfilDTO.getNome().isBlank()) {
            usuario.setNome(atualizarPerfilDTO.getNome());
        }

        if (atualizarPerfilDTO.getBi() != null && !atualizarPerfilDTO.getBi().isBlank()) {
            usuario.setBi(atualizarPerfilDTO.getBi());
        }

        if (atualizarPerfilDTO.getSenha() != null && !atualizarPerfilDTO.getSenha().isBlank()) {
            usuario.setSenha(atualizarPerfilDTO.getSenha());
        }
        usuarioRepository.save(usuario);
    }
}