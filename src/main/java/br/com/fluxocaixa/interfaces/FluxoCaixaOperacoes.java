package br.com.fluxocaixa.interfaces;

import br.com.fluxocaixa.dto.ConsolidadoDto;
import br.com.fluxocaixa.dto.LancamentoDtoIn;
import br.com.fluxocaixa.dto.LancamentoDtoOut;

public interface FluxoCaixaOperacoes {

	LancamentoDtoOut getLancamento(Long idLancamento);
    void postLancamento(LancamentoDtoIn dto);
    void putLancamento(Long idLancamento, LancamentoDtoIn dto);
    void deleteLancamento(Long idLancamento);
    ConsolidadoDto getConsolidado(String dataConsolidado);
} 
