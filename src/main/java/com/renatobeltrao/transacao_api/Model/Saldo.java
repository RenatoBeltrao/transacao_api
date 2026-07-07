package com.renatobeltrao.transacao_api.Model;

import java.time.Instant;



public class Saldo {

    private long total;

    private Instant data_extrato;

    private long limite;

    public Saldo() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Instant getData_extrato() {
        return data_extrato;
    }

    public void setData_extrato(Instant data_extrato) {
        this.data_extrato = data_extrato;
    }

    public long getLimite() {
        return limite;
    }

    public void setLimite(long limite) {
        this.limite = limite;
    }
    
    

}
