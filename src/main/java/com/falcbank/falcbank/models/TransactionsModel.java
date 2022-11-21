package com.falcbank.falcbank.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Accessors(chain = true)
@Entity
@Table(name="TRANSACTIONS")
@NoArgsConstructor
public class TransactionsModel {
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfCnpjSender() {
        return cpfCnpjSender;
    }

    public void setCpfCnpjSender(String cpfCnpjSender) {
        this.cpfCnpjSender = cpfCnpjSender;
    }

    public String getCpfCnpjRecepient() {
        return cpfCnpjRecepient;
    }

    public void setCpfCnpjRecepient(String cpfCnpjRecepient) {
        this.cpfCnpjRecepient = cpfCnpjRecepient;
    }

    public BigDecimal getValueOperation() {
        return valueOperation;
    }

    public void setValueOperation(BigDecimal valueOperation) {
        this.valueOperation = valueOperation;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String cpfCnpjSender;
    @Column(nullable = false)
    private String cpfCnpjRecepient;
    @Column(nullable = false)
    private BigDecimal valueOperation;

    @Column(nullable = false, length = 30)
    private LocalDateTime registrationDate;

    public TransactionsModel(Long id, String cpfCnpjSender, String cpfCnpjRecepient, BigDecimal value_operation, LocalDateTime registrationDate) {
        this.id = id;
        this.cpfCnpjSender = cpfCnpjSender;
        this.cpfCnpjRecepient = cpfCnpjRecepient;
        this.valueOperation = value_operation;
        this.registrationDate = registrationDate;
    }
}

