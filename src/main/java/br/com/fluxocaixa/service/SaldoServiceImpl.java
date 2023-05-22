package br.com.fluxocaixa.service;

import org.springframework.stereotype.Service;

import br.com.fluxocaixa.interfaces.SaldoService;
import br.com.fluxocaixa.model.SaldoModel;
import br.com.fluxocaixa.repositories.SaldoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaldoServiceImpl implements SaldoService {

	private final SaldoRepository saldoRepository;
	
	@Override
	public SaldoModel getSaldo() {
		return saldoRepository.findById(1).get();
	}

	@Override
	public void updateSaldo(SaldoModel model) {
		saldoRepository.save(model);
	}

}
