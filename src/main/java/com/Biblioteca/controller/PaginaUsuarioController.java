package com.Biblioteca.controller;

import com.Biblioteca.dto.AtualizarPerfil;
import com.Biblioteca.dto.AutenticacaoDTO;
import com.Biblioteca.dto.CadastrarLivroDTO;
import com.Biblioteca.dto.CadastrarUsuarioDTO;
import com.Biblioteca.model.Role;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.services.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PaginaUsuarioController {

    private final UsuarioService usuarioService;
    private final LivroService livroService;
    private final HistoricoService historicoService;
    private final AuthService authService;
    private final EmprestimoService emprestimoService;

    public PaginaUsuarioController(UsuarioService usuarioService, LivroService livroService, HistoricoService historicoService, AuthService authService, EmprestimoService emprestimoService) {
        this.usuarioService = usuarioService;
        this.livroService = livroService;
        this.historicoService = historicoService;
        this.authService = authService;
        this.emprestimoService = emprestimoService;
    }

    @GetMapping("/signup")
    public String paginaCadastroUsuario() {
        return "SignupBasic";
    }

    @PostMapping("/signup")
    public String cadastrarUsuario(@Valid @ModelAttribute CadastrarUsuarioDTO cadastrarUsuarioDTO) {
        usuarioService.cadastrarUsuario(cadastrarUsuarioDTO);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String authPage(Model model) {
        model.addAttribute("autenticacaoDTO", new AutenticacaoDTO());
        return "Login";
    }

    @PostMapping("/login")
    public String auth(@Valid @ModelAttribute AutenticacaoDTO loginDTO,
                       HttpSession session) {
        Usuario usuario = authService.auth(loginDTO);
        if (usuario == null) {
            return "redirect:/login";
        }
        session.setAttribute("usuarioLogado", usuario);
        if (usuario.hasRole(Role.Values.ADMIN.name())) {
            return "redirect:/adm";
        }
        if (usuario.hasRole(Role.Values.BASIC.name())) {
            return "redirect:/livros";
        }
        return "redirect:/login";
    }

    @GetMapping("/livros")
    public String listarLivros(Model model) {
        model.addAttribute("livros", livroService.listarLivro());
        return "UsuarioUI";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/livros/buscar")
    @ResponseBody
    public List<CadastrarLivroDTO> buscarLivro(@RequestParam String texto) {
        return livroService.buscarLivro(texto);
    }

    @GetMapping("/livros/historico")
    public String historico(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/login";
        }
        Long idUsuario = usuario.getId();
        model.addAttribute("historico", historicoService.MostrarHistorico(idUsuario));
        return "UsuariohistoricoUI";
    }

    @GetMapping("/livros/emprestimos")
    public String emprestimosPendentes(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/login";
        }
        Long idUsuario = usuario.getId();
        model.addAttribute("emprestimos", emprestimoService.listarEmprestimosPendentes(idUsuario));
        return "UsuarioEmprestimosUI";
    }

    @PostMapping("/perfil")
    public String alterarPerfil(HttpSession session, @Valid @ModelAttribute AtualizarPerfil perfil) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/login";
        }
        Long idUsuario = usuario.getId();
        usuarioService.atualizarPerfil(idUsuario, perfil);
        return "redirect:/livros";
    }
}