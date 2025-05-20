package com.Biblioteca.services;

import com.Biblioteca.dto.AutenticacaoDTO;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario auth(AutenticacaoDTO autenticacaoDTO) {
        return usuarioRepository.findByEmail(autenticacaoDTO.getEmail())
                .filter(user -> user.getSenha().equals(autenticacaoDTO.getSenha()))
                .orElse(null);
    }
}