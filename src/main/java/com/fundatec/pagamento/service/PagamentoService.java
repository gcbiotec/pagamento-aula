package com.fundatec.pagamento.service;

import com.fundatec.pagamento.domain.Pagamento;
import com.fundatec.pagamento.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }

    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.saveAndFlush(pagamento);
    }

    public Pagamento findById(Long id) {
        Optional<Pagamento> resultado = pagamentoRepository.findById(id);
        return resultado.get();
    }
}
