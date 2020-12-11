package com.fundatec.pagamento.controller;

import com.fundatec.pagamento.domain.Pagamento;
import com.fundatec.pagamento.repository.PagamentoRepository;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class PagamentoControllerTest {

    @Autowired
    private PagamentoController controller;

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllTest() throws Exception {
        repository.saveAndFlush(createPagamento());

        mockMvc
                .perform(MockMvcRequestBuilders.get("/pagamentos"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("[0].valor").value("1000.00"))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].status").value("Aberto"))
                .andExpect(MockMvcResultMatchers.jsonPath("[0].forma_pagamento").value("Prazo"));
    }

    private Pagamento createPagamento() {
        Pagamento pagamento = new Pagamento();
        pagamento.setFormaPagamento("Prazo");
        pagamento.setId(1L);
        pagamento.setStatus("Aberto");
        pagamento.setValor(new BigDecimal("1000.00"));
        return pagamento;
    }
}