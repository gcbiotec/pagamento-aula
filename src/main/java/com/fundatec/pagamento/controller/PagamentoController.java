package com.fundatec.pagamento.controller;

import com.fundatec.pagamento.controller.resources.PagamentoProjection;
import com.fundatec.pagamento.domain.Pagamento;
import com.fundatec.pagamento.repository.PagamentoRepository;
import com.fundatec.pagamento.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<PagamentoProjection>> findAll() {
        List<Pagamento> resultado = pagamentoService.findAll();

        List<PagamentoProjection> novoResultado = new ArrayList<>();

        for (Pagamento pagamentoInst : resultado) {
            PagamentoProjection pagamentoProjection = PagamentoProjection.create(pagamentoInst);
            novoResultado.add(pagamentoProjection);
        }

        return new ResponseEntity<List<PagamentoProjection>>(novoResultado, HttpStatus.OK);
    }
}
