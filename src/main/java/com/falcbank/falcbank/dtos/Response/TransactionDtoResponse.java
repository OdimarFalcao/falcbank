package com.falcbank.falcbank.dtos.Response;

import com.falcbank.falcbank.models.ClientModel;

import java.math.BigDecimal;

public class TransactionDtoResponse {
    private ClientModel clientSender;
    private ClientModel clienteRecepient;
    private BigDecimal balance;

    public String getClientSender() {
        return clientSender.getName();
    }

    public void setClientSender(ClientModel clientSender) {
        this.clientSender = clientSender;
    }

    public String getClienteRecepient() {
        return clienteRecepient.getName();
    }

    public void setClienteRecepient(ClientModel clienteRecepient) {
        this.clienteRecepient = clienteRecepient;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
