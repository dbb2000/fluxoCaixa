package br.com.fluxocaixa.enums;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import br.com.fluxocaixa.interfaces.OperacaoMatService;
import br.com.fluxocaixa.processors.CreditoProcessor;
import br.com.fluxocaixa.processors.DebitoProcessor;

public enum TipoEntrada {

	CREDITO {

		@Override
		public OperacaoMatService getProcessor(AutowireCapableBeanFactory beanFactory) {
			CreditoProcessor credProcessor = new CreditoProcessor();
			beanFactory.autowireBean(credProcessor);
			return credProcessor;
		}
		
	},
	
	DEBITO {

		@Override
		public OperacaoMatService getProcessor(AutowireCapableBeanFactory beanFactory) {
			DebitoProcessor debProcessor = new DebitoProcessor();
			beanFactory.autowireBean(debProcessor);
			return debProcessor;
		}
		
	};
	

	public abstract OperacaoMatService getProcessor(final AutowireCapableBeanFactory beanFactory);
}
