package br.com.fluxocaixa.processors;

import static br.com.fluxocaixa.enums.TipoEntrada.CREDITO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.fluxocaixa.interfaces.AnuladorEntradaService;
import br.com.fluxocaixa.interfaces.OperacaoMatService;
import br.com.fluxocaixa.model.LancamentoModel;

@Service

public class AnuladorEntradaProcessor implements AnuladorEntradaService {

	@Autowired
	@Qualifier("credito")
	private  OperacaoMatService serviceCred;
	
	@Autowired
	@Qualifier("debito")
	private OperacaoMatService serviceDeb;

	@Override
	public void anularLancamento(LancamentoModel model) {
		
		if (model.getTipoEntrada() == CREDITO) {
			serviceDeb.processarCalculo(model.getValor());
		}else {
			serviceCred.processarCalculo(model.getValor());
		}
		
	}
}
