package br.inatel.dm110.trabalho.api.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderTO {
    private String code;
    private String productCode;
    private String cpf;
    private int amount;
    private Date date;
    private double value;
}
