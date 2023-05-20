package br.inatel.dm110.trabalho.order.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "log_entity", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "operation")
    private String operation;

    @Column(name = "date")
    private Date date;

    public LogEntity(String orderCode, String operation, Date date) {
        this.orderCode = orderCode;
        this.operation = operation;
        this.date = date;
    }
}
