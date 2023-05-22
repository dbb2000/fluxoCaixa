package br.com.fluxocaixa.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConsolidadoDto {

	private List<LancamentoDtoOut> lancamentos;
	private BigDecimal saldo;
	
}
