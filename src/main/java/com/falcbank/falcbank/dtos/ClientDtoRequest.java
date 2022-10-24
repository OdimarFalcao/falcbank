package com.falcbank.falcbank.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClientDtoRequest {
    @NotBlank(message = "O campo não pode ser vazio ou nulo")
    private String name;
    @NotBlank(message = "O campo não pode ser vazio ou nulo")
    @Size(max = 11)
    private String cpf_cnpj;
    @NotBlank(message = "O campo não pode ser vazio ou nulo")
    private String email;
    @NotBlank(message = "O campo não pode ser vazio ou nulo")
    private String password;

    @NotBlank(message = "O campo não pode ser vazio ou nulo")
    private String type_account;

    public String getType_account() {
        return type_account;
    }

    public void setType_account(String type_account) {
        this.type_account = type_account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
