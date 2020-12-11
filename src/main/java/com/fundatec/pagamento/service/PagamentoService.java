package com.fundatec.pagamento.service;

import com.fundatec.pagamento.controller.resources.PagamentoRequest;
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

    public Pagamento save(PagamentoRequest pagamentoRequest) {
        Pagamento pagamentoToSave = pagamentoRequest.toPagamento();
        pagamentoToSave.setStatus("ABERTO");

        return pagamentoRepository.saveAndFlush(pagamentoToSave);
    }

    public Pagamento findById(Long id) {
        Optional<Pagamento> resultado = pagamentoRepository.findById(id);
        return resultado.get();
    }
}
