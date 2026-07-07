package com.renatobeltrao.transacao_api.dto;

import java.time.Instant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransacaoExtratoDTO {

    @NotNull
    @Positive
    private long valor;

    private char tipo;

    @NotBlank(message= "Descrição nao pode ser vazio")
    private String descricao;

    private Instant realizada_em;

    public TransacaoExtratoDTO() {
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Instant getRealizada_em() {
        return realizada_em;
    }

    public void setRealizada_em(Instant realizada_em) {
        this.realizada_em = realizada_em;
    }

    
    
}
