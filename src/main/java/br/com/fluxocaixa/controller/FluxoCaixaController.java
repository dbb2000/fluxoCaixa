package br.com.fluxocaixa.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fluxocaixa.dto.ConsolidadoDto;
import br.com.fluxocaixa.dto.LancamentoDtoIn;
import br.com.fluxocaixa.dto.LancamentoDtoOut;
import br.com.fluxocaixa.interfaces.FluxoCaixaOperacoes;
import br.com.fluxocaixa.interfaces.ValidadorService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FluxoCaixaController {
	
	private final FluxoCaixaOperacoes service;
	private final ValidadorService validadorService;

    @GetMapping(value = "/lancamentos/{idLancamento}")
    public ResponseEntity<LancamentoDtoOut> getLancamento(@PathVariable Long idLancamento) {
        return ResponseEntity.ok(service.getLancamento(idLancamento));
    }
    
    @PostMapping(value = "/lancamentos")
    public ResponseEntity<Void> postLancamento(@RequestBody LancamentoDtoIn lancamento) {
    	validadorService.validarDto(lancamento);
    	service.postLancamento(lancamento);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
    	return ResponseEntity.created(uri).body(null);
    }
    
    @PutMapping(value = "/lancamentos/{idLancamento}")
    public ResponseEntity<Void> putLancamento(@PathVariable Long idLancamento, @RequestBody LancamentoDtoIn lancamento) {
    	validadorService.validarDto(lancamento);
    	service.putLancamento(idLancamento, lancamento);
    	return ResponseEntity.ok().build();
    }
    
    @DeleteMapping(value = "/lancamentos/{idLancamento}")
    public ResponseEntity<Void> deleteLancamento(@PathVariable Long idLancamento) {
    	service.deleteLancamento(idLancamento);
    	return ResponseEntity.ok().build();
    }
    
    @GetMapping(value = "/consolidado/{dataConsolidado}")
    public ResponseEntity<ConsolidadoDto> getConsolidado(@PathVariable String dataConsolidado) {
        return ResponseEntity.ok(service.getConsolidado(dataConsolidado));
    }
}
