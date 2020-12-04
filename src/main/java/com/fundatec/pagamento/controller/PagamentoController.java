package com.fundatec.pagamento.controller;

import com.fundatec.pagamento.domain.Pagamento;
import com.fundatec.pagamento.repository.PagamentoRepository;
import com.fundatec.pagamento.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    public ResponseEntity<List<Pagamento>> findAll() {
        List<Pagamento> resultado = pagamentoService.findAll();
        return new ResponseEntity<List<Pagamento>>(resultado, HttpStatus.OK);
    }
}
