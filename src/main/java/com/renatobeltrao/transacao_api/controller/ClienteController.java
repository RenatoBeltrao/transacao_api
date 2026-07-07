package com.renatobeltrao.transacao_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renatobeltrao.transacao_api.Model.Extrato;
import com.renatobeltrao.transacao_api.dto.ClienteDTO;
import com.renatobeltrao.transacao_api.dto.TransacaoDTO;
import com.renatobeltrao.transacao_api.service.ExtratoService;
import com.renatobeltrao.transacao_api.service.TransacaoService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final TransacaoService transacaoService;
    private final ExtratoService extratoService;
    
    public ClienteController(TransacaoService transacaoService,ExtratoService extratoService){
        this.transacaoService = transacaoService;
        this.extratoService = extratoService;
    }


    @PostMapping("/{id}/transacoes")
    public ResponseEntity<ClienteDTO> transacao(@PathVariable Long id,@RequestBody @Valid TransacaoDTO transacaoDTO){
        

        
        
        ClienteDTO clienteDTO = transacaoService.criarTransacao(transacaoDTO,id);
        return ResponseEntity.status(200).body(clienteDTO);
        
    }

    @GetMapping("/{id}/extrato")
    public ResponseEntity<Extrato> extrato(@PathVariable Long id){


        return ResponseEntity.status(200).body(extratoService.criarExtrato(id));
    }

    

    
}
