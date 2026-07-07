package com.renatobeltrao.transacao_api.service;

import java.time.Instant;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.renatobeltrao.transacao_api.Model.Cliente;
import com.renatobeltrao.transacao_api.Model.Transacao;
import com.renatobeltrao.transacao_api.dto.ClienteDTO;
import com.renatobeltrao.transacao_api.dto.TransacaoDTO;
import com.renatobeltrao.transacao_api.repository.ClienteRepository;
import com.renatobeltrao.transacao_api.repository.TransacaoRepository;

import jakarta.transaction.Transactional;



@Service
public class TransacaoService {
    
    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;

    public TransacaoService(ClienteRepository clienteRepository, TransacaoRepository transacaoRepository){
        this.clienteRepository= clienteRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @Transactional
    public ClienteDTO criarTransacao(TransacaoDTO transacaodto, Long id){

        // buscando cliente
        Cliente cliente = clienteRepository.findByIdForUpdate(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404),"Cliente não encontrado"));
        
        //se for debito
        if(transacaodto.getTipo() == 'd'){
            Long novosaldo = cliente.getSaldo() - transacaodto.getValor();
            // se o novo saldo estiver dentro do limite, ok, se não, lança o erro
            if(novosaldo < (-1*cliente.getLimite())){
                throw new ResponseStatusException(HttpStatusCode.valueOf(422),"Limite insuficiente");
            }
            cliente.setSaldo(novosaldo);
        }

        else if(transacaodto.getTipo() == 'c'){
            Long novosaldo = cliente.getSaldo() + transacaodto.getValor();
            cliente.setSaldo(novosaldo);
        }

        Transacao transacao = new Transacao();
        transacao.setValor(transacaodto.getValor());
        transacao.setTipo(transacaodto.getTipo());
        transacao.setDescricao(transacaodto.getDescricao());
        transacao.setRealizadaEm(Instant.now());
        transacao.setCliente(cliente);
        transacaoRepository.save(transacao);

        ClienteDTO clientedto = new ClienteDTO();
        clientedto.setLimite(cliente.getLimite());
        clientedto.setSaldo(cliente.getSaldo());
        return clientedto;

    }

}


