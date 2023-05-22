package br.com.fluxocaixa.processors;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.fluxocaixa.interfaces.OperacaoMatService;
import br.com.fluxocaixa.model.SaldoModel;
import br.com.fluxocaixa.repositories.SaldoRepository;

@Service
@Component("credito")
public class CreditoProcessor implements OperacaoMatService{

	@Autowired
	private SaldoRepository repository;
	
	@Override
	public void processarCalculo(BigDecimal valor) {

		SaldoModel model =  repository.findById(1).get();
		model.setSaldo(model.getSaldo().add(valor));
		repository.save(model);
	}

}
