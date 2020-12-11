package com.fundatec.pagamento.service;

import com.fundatec.pagamento.PagamentoApplication;
import com.fundatec.pagamento.controller.resources.PagamentoRequest;
import com.fundatec.pagamento.domain.Pagamento;
import com.fundatec.pagamento.repository.PagamentoRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = PagamentoApplication.class)
class PagamentoServiceTest {

    @MockBean
    private PagamentoRepository repository;

    @Autowired
    private PagamentoService service;

    @Test
    public void findAllTest() {
        List<Pagamento> pagamentos = new ArrayList<>();
        pagamentos.add(createPagamento());

        Mockito.when(repository.findAll()).thenReturn(pagamentos);

        List<Pagamento> resultado = service.findAll();

        Assertions.assertEquals(pagamentos, resultado);
    }

    @Test
    public void saveTest() {
        PagamentoRequest pagamentoRequest = createPagamentoRequest();
        Pagamento pagamento = pagamentoRequest.toPagamento();

        Mockito.when(
                repository.saveAndFlush(Mockito.any(Pagamento.class))
        ).thenReturn(pagamento);

        Pagamento resultado = service.save(pagamentoRequest);

        Assertions.assertEquals(pagamento, resultado);
    }

    @Test
    public void findByIdTest() {
        Long id = 1L;
        Pagamento expected = createPagamento();

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expected));

        Pagamento resultado = service.findById(id);

        Assertions.assertEquals(expected, resultado);
    }

    private PagamentoRequest createPagamentoRequest() {
        PagamentoRequest pagamentoRequest = new PagamentoRequest();
        pagamentoRequest.setFormaPagamento("Prazo");
        pagamentoRequest.setValor(new BigDecimal("1000.00"));
        return pagamentoRequest;
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