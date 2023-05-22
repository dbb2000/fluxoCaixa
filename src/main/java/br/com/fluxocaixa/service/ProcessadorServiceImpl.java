package br.com.fluxocaixa.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Service;

import br.com.fluxocaixa.enums.TipoEntrada;
import br.com.fluxocaixa.interfaces.ProcessadorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProcessadorServiceImpl implements ProcessadorService {
	
	protected final AutowireCapableBeanFactory beanFactory;

	@Override
	public void executarCalculoSaldo(String tipoEntrada, BigDecimal valor) {

		TipoEntrada operacao = TipoEntrada.valueOf(tipoEntrada.toUpperCase());
		operacao.getProcessor(beanFactory).processarCalculo(valor);
	}

}
