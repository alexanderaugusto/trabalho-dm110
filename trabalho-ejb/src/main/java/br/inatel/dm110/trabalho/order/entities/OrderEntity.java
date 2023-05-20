package br.inatel.dm110.trabalho.order.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_entity", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    private String code;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "amount")
    private int amount;

    @Column(name = "date")
    private Date date;

    @Column(name = "value")
    private double value;
}
