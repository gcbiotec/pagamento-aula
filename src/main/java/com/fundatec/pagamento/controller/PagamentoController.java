package com.fundatec.pagamento.controller;

import com.fundatec.pagamento.controller.resources.PagamentoProjection;
import com.fundatec.pagamento.controller.resources.PagamentoRequest;
import com.fundatec.pagamento.domain.Pagamento;
import com.fundatec.pagamento.service.PagamentoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        return new ResponseEntity<>(novoResultado, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pagamento> save(@RequestBody PagamentoRequest pagamentoRequest) {
        return new ResponseEntity<>(pagamentoService.save(pagamentoRequest), HttpStatus.OK);
    }
}
