package com.renatobeltrao.transacao_api.service;
import java.time.Instant;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.renatobeltrao.transacao_api.Model.Cliente;
import com.renatobeltrao.transacao_api.Model.Extrato;
import com.renatobeltrao.transacao_api.Model.Saldo;
import com.renatobeltrao.transacao_api.Model.Transacao;
import com.renatobeltrao.transacao_api.dto.TransacaoExtratoDTO;
import com.renatobeltrao.transacao_api.repository.ClienteRepository;
import com.renatobeltrao.transacao_api.repository.TransacaoRepository;


@Service
public class ExtratoService {

    ClienteRepository clienteRepository;
    TransacaoRepository transacaoRepository;

    public ExtratoService(ClienteRepository clienteRepository, TransacaoRepository transacaoRepository){
        this.clienteRepository= clienteRepository;
        this.transacaoRepository = transacaoRepository;
    }
    
    public Extrato criarExtrato(Long id){

        Cliente cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404),"Cliente não encontrado"));

        Extrato extrato = new Extrato();
        Saldo saldo = new Saldo();  
        saldo.setLimite(cliente.getLimite());
        saldo.setTotal(cliente.getSaldo());
        saldo.setData_extrato(Instant.now());
        extrato.setSaldo(saldo);

        List<Transacao> lista = transacaoRepository.findTop10ByClienteIdOrderByRealizadaEmDesc(id);
        for(Transacao temp : lista){
            TransacaoExtratoDTO transacaoTemp = new TransacaoExtratoDTO();
            transacaoTemp.setValor(temp.getValor());
            transacaoTemp.setTipo(temp.getTipo());
            transacaoTemp.setDescricao(temp.getDescricao());
            transacaoTemp.setRealizada_em(temp.getRealizadaEm());
            
            extrato.addTransacao(transacaoTemp);
        }

        return extrato;
    }
    
}
