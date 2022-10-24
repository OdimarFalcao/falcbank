package com.falcbank.falcbank.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AccountDtoRequest {
    @NotBlank(message = "O campo não pode ser vazio ou nulo")
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
