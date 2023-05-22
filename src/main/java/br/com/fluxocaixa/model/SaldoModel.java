package br.com.fluxocaixa.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity(name = "SALDO")
public class SaldoModel {

	@Id
	private int id; 
	
	private BigDecimal saldo;
	
}
