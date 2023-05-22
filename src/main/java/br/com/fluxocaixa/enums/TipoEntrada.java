package br.com.fluxocaixa.enums;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;


import br.com.fluxocaixa.interfaces.OperacaoMatService;
import br.com.fluxocaixa.processors.CreditoProcessor;
import br.com.fluxocaixa.processors.DebitoProcessor;

public enum TipoEntrada {

	CREDITO("CREDITO") {

		@Override
		public OperacaoMatService getProcessor(AutowireCapableBeanFactory beanFactory) {
			CreditoProcessor credProcessor = new CreditoProcessor();
			beanFactory.autowireBean(credProcessor);
			return credProcessor;
		}
		
	},
	
	DEBITO("DEBITO") {

		@Override
		public OperacaoMatService getProcessor(AutowireCapableBeanFactory beanFactory) {
			DebitoProcessor debProcessor = new DebitoProcessor();
			beanFactory.autowireBean(debProcessor);
			return debProcessor;
		}
		
	};
	
	private String tipo;

	TipoEntrada(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipoEntrada() {
		return tipo;
	}

	public abstract OperacaoMatService getProcessor(final AutowireCapableBeanFactory beanFactory);
}
