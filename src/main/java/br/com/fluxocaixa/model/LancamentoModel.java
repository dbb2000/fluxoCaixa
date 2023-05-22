package br.com.fluxocaixa.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.fluxocaixa.enums.TipoEntrada;
import lombok.Data;

@Data
@Entity(name = "LANCAMENTOS")
public class LancamentoModel {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idLancamento;
	private Date dataLancamento;
	private String descricao;
	private BigDecimal valor;
	@Enumerated(EnumType.STRING)
	private TipoEntrada tipoEntrada;
	
}
