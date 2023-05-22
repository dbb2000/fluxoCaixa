package br.com.fluxocaixa.interfaces;

import java.math.BigDecimal;

public interface ProcessadorService {

	void executarCalculoSaldo(String tipoEntrada, BigDecimal valor);
}
