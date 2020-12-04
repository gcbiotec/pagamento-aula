package com.fundatec.pagamento.controller.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fundatec.pagamento.domain.Pagamento;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagamentoProjection {

    @JsonProperty("pagamento_id")
    private Long pagamentoId;

    private String valor;

    @JsonProperty("forma_pagamento")
    private String formaPagamento;

    private String status;

    public Long getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Long pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static PagamentoProjection create(Pagamento pagamento) {
        PagamentoProjection pagamentoProjection = new PagamentoProjection();
        pagamentoProjection.setFormaPagamento(pagamento.getFormaPagamento());
        pagamentoProjection.setPagamentoId(pagamento.getId());
        pagamentoProjection.setStatus(pagamento.getStatus());
        pagamentoProjection.setValor(pagamento.getValor().toString());

        return pagamentoProjection;
    }

    public static PagamentoProjection createForFindAll(Pagamento pagamento) {
        PagamentoProjection pagamentoProjection = new PagamentoProjection();
        pagamentoProjection.setPagamentoId(pagamento.getId());
        pagamentoProjection.setStatus(pagamento.getStatus());
        pagamentoProjection.setValor(pagamento.getValor().toString());

        return pagamentoProjection;
    }
}
