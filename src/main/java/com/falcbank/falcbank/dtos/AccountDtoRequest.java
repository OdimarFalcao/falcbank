package com.falcbank.falcbank.dtos;

import com.falcbank.falcbank.models.ClientModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class AccountDtoRequest {
    //@Length(min = 1,message = "O campo não pode ser vazio ou nulo")
   // @DecimalMax("10.0")
   // @DecimalMin("0.0")
    @NotNull( message = "Please Enter a valid Deposit Amount")
    private Double balance;

    @NotNull(message = "O campo não pode ser vazio ou nulo")
    private Long idClient;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
