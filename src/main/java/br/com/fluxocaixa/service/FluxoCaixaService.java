package br.com.fluxocaixa.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.fluxocaixa.dto.ConsolidadoDto;
import br.com.fluxocaixa.dto.LancamentoDtoIn;
import br.com.fluxocaixa.dto.LancamentoDtoOut;
import br.com.fluxocaixa.exceptions.ConversaoException;
import br.com.fluxocaixa.interfaces.AnuladorEntradaService;
import br.com.fluxocaixa.interfaces.ConversorService;
import br.com.fluxocaixa.interfaces.FluxoCaixaOperacoes;
import br.com.fluxocaixa.interfaces.ProcessadorService;
import br.com.fluxocaixa.model.LancamentoModel;
import br.com.fluxocaixa.repositories.LancamentoRepository;
import br.com.fluxocaixa.repositories.SaldoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FluxoCaixaService implements FluxoCaixaOperacoes {
	
	private final LancamentoRepository lancamentoRepository;
	private final SaldoRepository saldoRepository;
	private final ConversorService conversor;
	private static final Logger LOGGER = LoggerFactory.getLogger(FluxoCaixaService.class);
	private final AnuladorEntradaService anuladorService;
	private final ProcessadorService processadorService;

	@Override
	public LancamentoDtoOut getLancamento(Long idLancamento) {
		LOGGER.info("FluxoCaixaService::getLancamento() - buscando lançamento de ID: {}", idLancamento);
		
		Optional<LancamentoModel> lancamento = lancamentoRepository.findById(idLancamento);
		LancamentoDtoOut dto = conversor.modelToDtoOut(lancamento.get());
        return dto;		
	}

	@Override
	public void postLancamento(LancamentoDtoIn dto) {
		LOGGER.info("FluxoCaixaService::postLancamento() - inserindo lançamento: {}", dto);
		
		LancamentoModel lancamentoModel = conversor.dtoInToModel(dto);
		lancamentoRepository.save(lancamentoModel);
		processadorService.executarCalculoSaldo(dto.getTipoEntrada(), lancamentoModel.getValor());
	}

	@Override
	public void putLancamento(Long idLancamento, LancamentoDtoIn dto) {
		LOGGER.info("FluxoCaixaService::putLancamento() - alterando lançamento de ID: {}", idLancamento);
		LancamentoModel velhoModel = lancamentoRepository.findById(idLancamento).get();
		LancamentoModel novoModel = conversor.dtoInToModel(dto);
		novoModel.setIdLancamento(idLancamento);
		
		lancamentoRepository.save(novoModel);
		anuladorService.anularLancamento(velhoModel);
		processadorService.executarCalculoSaldo(dto.getTipoEntrada(), novoModel.getValor());
	}

	@Override
	public void deleteLancamento(Long idLancamento) {
		LOGGER.info("FluxoCaixaService::deleteLancamento() - deletando lançamento de ID: {}", idLancamento);
		Optional<LancamentoModel> lancamento = lancamentoRepository.findById(idLancamento);
		
		if(lancamento.isPresent()) {
			lancamentoRepository.delete(lancamento.get());
			anuladorService.anularLancamento(lancamento.get());
		}else {
			throw new NoSuchElementException();
		}
	}


	@Override
	public ConsolidadoDto getConsolidado(String dataConsolidado) {
		LOGGER.info("FluxoCaixaService::getConsolidado() - Gerando relatório com base no dia: {}", dataConsolidado);
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			
			date = df.parse(dataConsolidado);
			
		} catch (ParseException e) {
			LOGGER.error("FluxoCaixaService::getConsolidado() - erro na conversão de data: {}", dataConsolidado);
			throw new ConversaoException("Erro na conversão de data. Use o formato dd-mm-yyyy", e);
		}

		List<LancamentoDtoOut> list = conversor.modelListToDtoList(lancamentoRepository.findByDataLancamento(date)); 
		
		if(list.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		BigDecimal saldo = saldoRepository.findById(1).get().getSaldo();
		return new ConsolidadoDto(list, saldo);
	}
}
