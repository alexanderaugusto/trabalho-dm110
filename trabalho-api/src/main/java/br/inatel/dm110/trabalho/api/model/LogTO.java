package br.inatel.dm110.trabalho.api.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogTO {
  private String orderCode;
  private String operation;
  private Date date;
}
