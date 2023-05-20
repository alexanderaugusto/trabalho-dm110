package br.inatel.dm110.trabalho.api.model;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
    private String code;
    private String productCode;
    private String cpf;
    private int amount;
    private Date date;
    private double value;
}
