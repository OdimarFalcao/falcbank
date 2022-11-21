package com.falcbank.falcbank.dtos.Response;

import com.falcbank.falcbank.models.ClientModel;

import java.math.BigDecimal;

public class AccountDtoResponse {
    private ClientModel nameClient;
    private ClientModel typeUser;
    private BigDecimal balance;

    public String getTypeUser() {
        return typeUser.getTypeUser();
    }

    public void setTypeUser(ClientModel typeUser) {
        this.typeUser = typeUser;
    }

    public String getNameClient() {
        return nameClient.getName();
    }

    public void setNameClient(ClientModel nameClient) {
        this.nameClient = nameClient;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
