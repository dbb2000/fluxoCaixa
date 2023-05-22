package br.com.fluxocaixa.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class LancamentoDtoIn {

	@NotNull(message = "Data do lançamento deve ser preenchida.")
	@Pattern(regexp = "^[0-9]{2}-[0-9]{2}-[0-9]{4}", message = "Insira a data no formato 'dd-mm-aaaa'.")
	private String dataLancamento;
	
	@NotNull(message = "Campo Descrição deve ser preenchido.")
	private String descricao;
	
	@NotNull(message = "Campo Valor do lançamento deve ser preenchido.")
	@Pattern(regexp = "^[0-9]{1,}.{0,1}[0-9]{0,2}", message = "Use apenas '.' (ponto) para separar casas decimais.")
	private String valor;
	
	@NotNull(message = "Campo Tipo de entrada deve ser preenchido. Opções: CREDITO e DEBITO.")
	private String tipoEntrada;
}
