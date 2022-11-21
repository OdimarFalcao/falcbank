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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Long idSender;
    @Column(nullable = false)
    private Long idRecepient;
    @Column(nullable = false)
    private BigDecimal valueOperation;

    @Column(nullable = false, length = 30)
    private LocalDateTime registrationDate;

    public TransactionsModel(Long id, Long idSender, Long idRecepient, BigDecimal value_operation, LocalDateTime registrationDate) {
        this.id = id;
        this.idSender = idSender;
        this.idRecepient = idRecepient;
        this.valueOperation = value_operation;
        this.registrationDate = registrationDate;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSender() {
        return idSender;
    }

    public void setIdSender(Long idSender) {
        this.idSender = idSender;
    }

    public Long getIdRecepient() {
        return idRecepient;
    }

    public void setIdRecepient(Long idRecepient) {
        this.idRecepient = idRecepient;
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
}

