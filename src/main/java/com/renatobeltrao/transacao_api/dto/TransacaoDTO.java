package com.renatobeltrao.transacao_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
public class TransacaoDTO {

    @NotNull
    @Positive
    private long valor;

    private char tipo;

    @NotBlank(message= "Descrição nao pode ser vazio")
    private String descricao;

    // getters e setters

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
    
    

}