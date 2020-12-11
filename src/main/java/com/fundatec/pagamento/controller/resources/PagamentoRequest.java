package com.fundatec.pagamento.controller.resources;

import com.fundatec.pagamento.domain.Pagamento;
import java.math.BigDecimal;

public class PagamentoRequest {

    private BigDecimal valor;
    private String formaPagamento;

    public Pagamento toPagamento() {
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(getValor());
        pagamento.setFormaPagamento(getFormaPagamento());
        return pagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
