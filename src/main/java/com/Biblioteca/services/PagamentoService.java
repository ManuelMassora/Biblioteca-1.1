package com.Biblioteca.services;

import com.Biblioteca.dto.EfetuarPagamentoDTO;
import com.Biblioteca.dto.PagamentoDTO;
import com.Biblioteca.model.Emprestimo;
import com.Biblioteca.model.Historico;
import com.Biblioteca.model.Pagamento;
import com.Biblioteca.repository.EmprestimoRepository;
import com.Biblioteca.repository.HistoricoRepository;
import com.Biblioteca.repository.PagamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final EmprestimoService emprestimoService;
    private final HistoricoRepository historicoRepository;
    private final EmprestimoRepository emprestimoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository,
                            EmprestimoService emprestimoService,
                            HistoricoRepository historicoRepository,
                            EmprestimoRepository emprestimoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.emprestimoService = emprestimoService;
        this.historicoRepository = historicoRepository;
        this.emprestimoRepository = emprestimoRepository;
    }

    @Transactional
    public void efetualPagamento(EfetuarPagamentoDTO efetuarPagamento) {
        Emprestimo emprestimo = emprestimoService.buscarEmprestimo(efetuarPagamento.getIdEmprestimo())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empréstimo não encontrado"));

        if (!emprestimo.isFinalizado()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empréstimo ainda não foi finalizado");
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setEmprestimo(emprestimo);
        pagamento.setValoPagamento(emprestimo.getTotal());
        pagamento.setHora(LocalDateTime.now());
        pagamentoRepository.save(pagamento);

        emprestimo.setPago(true);
        emprestimoRepository.save(emprestimo);

        Historico historico = new Historico();
        historico.setUsuario(emprestimo.getUsuario());
        historico.setPagamento(pagamento);
        historicoRepository.save(historico);
    }

    public List<PagamentoDTO> listaPagamentos() {
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        return pagamentos.stream()
                .map(pagamento -> new PagamentoDTO(
                        pagamento.getId(),
                        pagamento.getEmprestimo().getUsuario().getNome(),
                        pagamento.getEmprestimo().getLivroEmprestado().getTitulo(),
                        pagamento.getEmprestimo().getId(),
                        pagamento.getValoPagamento(),
                        pagamento.getHora()
                )).toList();
    }
}