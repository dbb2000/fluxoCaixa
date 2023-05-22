package br.com.fluxocaixa.interfaces;

import br.com.fluxocaixa.model.SaldoModel;

public interface SaldoService {

	SaldoModel getSaldo();
	void updateSaldo(SaldoModel model);
	
}
