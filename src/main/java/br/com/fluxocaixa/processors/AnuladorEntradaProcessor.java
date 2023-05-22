package br.com.fluxocaixa.processors;

import static br.com.fluxocaixa.enums.TipoEntrada.CREDITO;
import static br.com.fluxocaixa.enums.TipoEntrada.DEBITO;

import org.springframework.stereotype.Service;

import br.com.fluxocaixa.interfaces.AnuladorEntradaService;
import br.com.fluxocaixa.interfaces.ProcessadorService;
import br.com.fluxocaixa.model.LancamentoModel;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnuladorEntradaProcessor implements AnuladorEntradaService {
	
	private final ProcessadorService processadorService;

	@Override
	public void anularLancamento(LancamentoModel model) {
		
		if (model.getTipoEntrada() == CREDITO) {
			processadorService.executarCalculoSaldo(DEBITO.getTipoEntrada(), model.getValor());
		
		}else if(model.getTipoEntrada() == DEBITO) {
			processadorService.executarCalculoSaldo(CREDITO.getTipoEntrada(), model.getValor());
		}
	}
}
