package com.Biblioteca.controller;

import com.Biblioteca.dto.*;
import com.Biblioteca.model.Livro;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.repository.UsuarioRepository;
import com.Biblioteca.services.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PaginaAdminController {

    private final UsuarioService usuarioService;
    private final LivroService livroService;
    private final GestaoDeUsuarioService gestaoDeUsuarioService;
    private final EmprestimoService emprestimoService;
    private final PagamentoService pagamentoService;
    private final UsuarioRepository usuarioRepository;

    public PaginaAdminController(UsuarioService usuarioService,
                                 LivroService livroService,
                                 GestaoDeUsuarioService gestaoDeUsuarioService,
                                 EmprestimoService emprestimoService,
                                 PagamentoService pagamentoService,
                                 UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.livroService = livroService;
        this.gestaoDeUsuarioService = gestaoDeUsuarioService;
        this.emprestimoService = emprestimoService;
        this.pagamentoService = pagamentoService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/adm")
    public String paginaADM() {
        return "AdminUI";
    }

    @GetMapping("adm/livros/buscar")
    public String buscarLivro(@RequestParam String termo, Model model) {
        List<CadastrarLivroDTO> livros = livroService.buscarLivro(termo);
        model.addAttribute("livos", livros);
        return "GestaoLivros";
    }

    @GetMapping("/adm/signup")
    public String paginaCadastroUsuario() {
        return "SignupAdmin";
    }

    @PostMapping("/adm/usuarios/adicionar")
    public String cadastrarUsuario(@Valid @ModelAttribute CadastrarUsuarioDTO cadastrarUsuarioDTO) {
        usuarioService.cadastrarAdmin(cadastrarUsuarioDTO);
        return "redirect:/adm/usuarios";
    }

    @PostMapping("/adm")
    public String adicionarLivros(@ModelAttribute CadastrarLivroDTO cadastrarLivroDTO) {
        livroService.cadastrarLivro(cadastrarLivroDTO);
        return "redirect:/adm";
    }

    @GetMapping("/adm/usuarios")
    public String gestaoUsuarios(Model model) {
        model.addAttribute("usuarios", gestaoDeUsuarioService.listarUsuarios());
        return "GestaoUsuarios";
    }

    @GetMapping("/adm/livros")
    public String listarLivros(Model model) {
        var listaLivro = livroService.listarLivroComID();
        model.addAttribute("livros", listaLivro);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "GestaoLivros";
    }

    @PostMapping("/adm/livros/adicionar")
    public String adicionarLivro(@Valid @ModelAttribute CadastrarLivroDTO cadastrarLivroDTO) {
        livroService.cadastrarLivro(cadastrarLivroDTO);
        return "redirect:/adm/livros";
    }

    @GetMapping("/adm/pagamentos")
    public String listarPagamentos(Model model) {
        model.addAttribute("pagamentos", pagamentoService.listaPagamentos());
        return "GestaoPagamentos";
    }

    @GetMapping("/adm/Emprestimos")
    public String listarEmprestimos(Model model) {
        model.addAttribute("emprestimos", emprestimoService.listarEmprestimos());
        return "GestaoEmprestimos";
    }

    @PostMapping("/adm/usuarios/editar")
    public String atualizarUsuario(@RequestParam Long id, @Valid @ModelAttribute AtualizarUsuarioDTO atualizarUsuarioDTO) {
        gestaoDeUsuarioService.atualizarUsuario(id, atualizarUsuarioDTO);
        return "redirect:/adm/usuarios";
    }

    @PostMapping("/adm/usuarios/deletar")
    public String deletarUsuario(@RequestParam Long id) {
         gestaoDeUsuarioService.apagarUsuario(id);
        return "redirect:/adm/usuarios";
    }

    @PostMapping("/adm/livros/editar")
    public String atualizarLivro(@RequestParam Long id,
                                 @ModelAttribute CadastrarLivroDTO cadastrarLivroDTO) {
        livroService.atualizarLivro(id, cadastrarLivroDTO);
        return "redirect:/adm/livros";
    }

    @PostMapping("/adm/livros/deletar")
    public String apagarLivro(@RequestParam Long id) {
        livroService.removerLivro(id);
        return "redirect:/adm/livros";
    }

    @PostMapping("/adm/livros/emprestar")
    public String emprestar(@RequestParam Long idUsuario, @RequestParam Long idLivro) {
        FazerEmprestimoDTO fazerEmprestimoDTO = new FazerEmprestimoDTO(idUsuario, idLivro);
        emprestimoService.emprestarLivro(fazerEmprestimoDTO);
        return "redirect:/adm/livros";
    }

    @PostMapping("/adm/Emprestimos/devolver")
    public String devolverLivro(@RequestParam Long id) {
        emprestimoService.finalizarEmprestimo(id);
        return "redirect:/adm/Emprestimos";
    }

    @PostMapping("/adm/Emprestimos/pagar")
    public String pagar(@RequestParam Long id) {
        EfetuarPagamentoDTO efetuarPagamentoDTO = new EfetuarPagamentoDTO(id);
        pagamentoService.efetualPagamento(efetuarPagamentoDTO);
        return "redirect:/adm/Emprestimos";
    }
}