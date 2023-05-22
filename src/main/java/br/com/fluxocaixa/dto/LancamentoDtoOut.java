package br.com.fluxocaixa.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class LancamentoDtoOut {
	
	private Long idLancamento;
	private String descricao;
	private Date dataLancamento;
	private BigDecimal valor;
	private String tipoEntrada;
	
}
