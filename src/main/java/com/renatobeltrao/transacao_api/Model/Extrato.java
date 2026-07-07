package com.renatobeltrao.transacao_api.Model;

import java.util.ArrayList;
import java.util.List;

import com.renatobeltrao.transacao_api.dto.TransacaoExtratoDTO;

public class Extrato {

    private Saldo saldo;
    private List<TransacaoExtratoDTO> ultimas_transacoes;

    
    

    public Extrato() {
        this.ultimas_transacoes = new ArrayList<>();
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

    public List<TransacaoExtratoDTO> getUltimas_transacoes() {
        return ultimas_transacoes;
    }

    public void addTransacao(TransacaoExtratoDTO transacao){
        this.ultimas_transacoes.add(transacao);
    }


    public void setUltimas_transacoes(List<TransacaoExtratoDTO> ultimas_transacoes) {
        this.ultimas_transacoes = ultimas_transacoes;
    }
    

    
    
}
