package com.renatobeltrao.transacao_api.dto;

public class ClienteDTO {
    
    
    private long limite;

    private long id;
    
    private long saldo;

    public ClienteDTO() {
    }

    public long getLimite() {
        return limite;
    }

    public void setLimite(long limite) {
        this.limite = limite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }



}
